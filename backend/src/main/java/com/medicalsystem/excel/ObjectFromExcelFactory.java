package com.medicalsystem.excel;

import com.medicalsystem.domain.*;
import com.medicalsystem.service.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Component
public class ObjectFromExcelFactory {

    private AdmissionService admissionService;
    private AnesthesiaService anesthesiaService;
    private AnestheticService anestheticService;
    private ComplicationDescriptionService complicationDescriptionService;
    private ComplicationService complicationService;
    private DiseaseDescriptionService diseaseDescriptionService;
    private DiseaseService diseaseService;
    private ExaminationDescriptionService examinationDescriptionService;
    private ExaminationService examinationService;
    private MedicamentService medicamentService;
    private OperationModeService operationModeService;
    private OperationService operationService;
    private OperationTypeService operationTypeService;
    @Getter
    @Setter
    private PatientService patientService;
    private ReoperationService reoperationService;
    private RevisitCauseService revisitCauseService;
    private RevisitService revisitService;
    private SmokingService smokingService;
    private TroponinService troponinService;

    private String excelColumnsFileName = "excelColumns.properties";
    private Properties properties;

    @Autowired
    public ObjectFromExcelFactory(AdmissionService admissionService, AnesthesiaService anesthesiaService,
                                  AnestheticService anestheticService, ComplicationDescriptionService
                                          complicationDescriptionService, ComplicationService complicationService,
                                  DiseaseDescriptionService diseaseDescriptionService, DiseaseService diseaseService,
                                  ExaminationDescriptionService examinationDescriptionService, ExaminationService examinationService,
                                  MedicamentService medicamentService, OperationModeService operationModeService,
                                  OperationService operationService, OperationTypeService operationTypeService,
                                  PatientService patientService, ReoperationService reoperationService,
                                  RevisitCauseService revisitCauseService, RevisitService revisitService,
                                  SmokingService smokingService, TroponinService troponinService) {
        this.admissionService = admissionService;
        this.anesthesiaService = anesthesiaService;
        this.anestheticService = anestheticService;
        this.complicationDescriptionService = complicationDescriptionService;
        this.complicationService = complicationService;
        this.diseaseDescriptionService = diseaseDescriptionService;
        this.diseaseService = diseaseService;
        this.examinationDescriptionService = examinationDescriptionService;
        this.examinationService = examinationService;
        this.medicamentService = medicamentService;
        this.operationModeService = operationModeService;
        this.operationService = operationService;
        this.operationTypeService = operationTypeService;
        this.patientService = patientService;
        this.reoperationService = reoperationService;
        this.revisitCauseService = revisitCauseService;
        this.revisitService = revisitService;
        this.smokingService = smokingService;
        this.troponinService = troponinService;

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        this.properties = new Properties();
        try (InputStream input = loader.getResourceAsStream(excelColumnsFileName)) {
            this.properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Patient createPatient(Row row) {
        Patient patient = new Patient();

        Cell patientIdCell = row.getCell(Integer.parseInt(properties.getProperty("id.number")));
        patient.setId((patientIdCell == null) ? -1 : (int) patientIdCell.getNumericCellValue());

        Cell lastNameCell = row.getCell(Integer.parseInt(properties.getProperty("lastName.number")));
        patient.setLastName((lastNameCell == null) ? "" : lastNameCell.getStringCellValue());

        Cell firstNameCell = row.getCell(Integer.parseInt(properties.getProperty("firstName.number")));
        patient.setFirstName((firstNameCell == null) ? "" : firstNameCell.getStringCellValue());

        Cell sexCell = row.getCell(Integer.parseInt(properties.getProperty("sex.number")));
        patient.setSex((sexCell == null) ? 'x' : sexCell.getStringCellValue().charAt(0));

        Cell ageCell = row.getCell(Integer.parseInt(properties.getProperty("age.number")));
        patient.setAge((ageCell == null) ? -1 : (int) ageCell.getNumericCellValue());

        patient.setDiseases(getDiseaseListWithKey(row)); //choroby wspolistniejace

        return patient;
    }

    public List<Disease> getDiseaseListWithKey(Row row) {
        List<Disease> diseases = new ArrayList<>();
        int firstDiseaseInExcel = Integer.parseInt(properties.getProperty("disease.shock.number"));
        int lastDiseaseInExcel = Integer.parseInt(properties.getProperty("disease.ekg.number"));
        for (int excelCellNumber = firstDiseaseInExcel, diseaseCount = 1; excelCellNumber <= lastDiseaseInExcel; excelCellNumber++, diseaseCount++) {
            Cell diseaseCell = row.getCell(excelCellNumber);
            if (diseaseCell != null && diseaseCell.getNumericCellValue() != 0) {
                Disease disease = diseaseService.getById(diseaseCount);
                diseases.add(disease);
            }
        }
        return diseases;
    }


    public Patient getPatientWithKey(Row row) {
        Cell patientCell = row.getCell(Integer.parseInt(properties.getProperty("id.number")));
        if (patientCell != null) {
            return patientService.getById((int) patientCell.getNumericCellValue());
        }
        return new Patient();
    }

    public Admission createAdmission(Row row) {
        Admission admission = new Admission();

        admission.setPatient(getPatientWithKey(row));

        admission.setOperation(createOperation(row));

        java.util.Date admissionDateCell = row.getCell(Integer.parseInt(properties.getProperty("admissionDate.number"))).getDateCellValue();
        Date admissionDate = new Date(admissionDateCell.getYear(), admissionDateCell.getMonth(), admissionDateCell.getDay());
        admission.setAdmissionDate(admissionDate);

        java.util.Date operationDateCell = row.getCell(Integer.parseInt(properties.getProperty("operationDate.number"))).getDateCellValue();
        Date operationDate = new Date(operationDateCell.getYear(), operationDateCell.getMonth(), operationDateCell.getDay());
        admission.setOperationDate(operationDate);

        Cell aaSymptomsCell = row.getCell(Integer.parseInt(properties.getProperty("aaSymptoms.number")));
        admission.setAaSymptoms((aaSymptomsCell == null) ? -1 : (int) aaSymptomsCell.getNumericCellValue());

        Cell aaSizeCell = row.getCell(Integer.parseInt(properties.getProperty("aaSize.number")));
        admission.setAaSize((aaSizeCell == null) ? -1 : (int) aaSizeCell.getNumericCellValue());

        Cell maxAneurysmSizeCell = row.getCell(Integer.parseInt(properties.getProperty("maxAneurysmSize.number")));
        admission.setMaxAneurysmSize((maxAneurysmSizeCell == null) ? -1 : (int) maxAneurysmSizeCell.getNumericCellValue());

        Cell imageExaminationCell = row.getCell(Integer.parseInt(properties.getProperty("imageExamination.number")));
        admission.setImageExamination((imageExaminationCell == null) ? -1 : (int) imageExaminationCell.getNumericCellValue());

        Cell aneurysmLocationCell = row.getCell(Integer.parseInt(properties.getProperty("aneurysmLocation.number")));
        admission.setAneurysmLocation((aneurysmLocationCell == null) ? -1 : (int) aneurysmLocationCell.getNumericCellValue());

        admission.setSmoking(getSmokingWithKey(row));

        Cell asaScaleCell = row.getCell(Integer.parseInt(properties.getProperty("asaScale.number")));
        admission.setAsaScale((asaScaleCell == null) ? -1 : (int) asaScaleCell.getNumericCellValue());

        Cell leeRcriCell = row.getCell(Integer.parseInt(properties.getProperty("leeRcri.number")));
        admission.setLeeRcri((leeRcriCell == null) ? -1 : (int) leeRcriCell.getNumericCellValue());

        Cell pPossumCell = row.getCell(Integer.parseInt(properties.getProperty("pPossum.number")));
        admission.setPPossum((pPossumCell == null) ? -1 : (int) pPossumCell.getNumericCellValue());

        Cell faintCell = row.getCell(Integer.parseInt(properties.getProperty("faint.number")));
        admission.setFaint((faintCell == null) ? -1 : (int) faintCell.getNumericCellValue());

        admission.setReoperation(getReoperationWithKey(row));

        Cell commentsCell = row.getCell(Integer.parseInt(properties.getProperty("comments.number")));
        admission.setComments((commentsCell == null) ? "" : commentsCell.getStringCellValue());

        admissionService.saveOrUpdate(admission); //because I need an ID in next method calls

        admission.setMedicaments(getMedicamentListWithKey(row));
        admission.setOperationTypes(getOperationTypeListWithKey(row));

        admission.setExaminations(getExaminationListWithKey(row, admission));
        admission.setRevisits(getRevisitListWithKey(row, admission));
        admission.setTroponins(getTroponinListWithKey(row, admission));

        return admission;
    }

    public List<Revisit> getRevisitListWithKey(Row row, Admission admission) {
        List<Revisit> revisits = new ArrayList<>();
        revisits.add(getRevisitWithKey(row, admission));
        return revisits;
    }

    public List<Examination> getExaminationListWithKey(Row row, Admission admission) {
        List<Examination> examinations = new ArrayList<>();
        int firstExaminationInExcel = Integer.parseInt(properties.getProperty("examination.pchn.number"));
        int lastExaminationInExcel = Integer.parseInt(properties.getProperty("examination.fibrinogen.number"));
        for (int excelCellNumber = firstExaminationInExcel, dbIndex = 1; excelCellNumber <= lastExaminationInExcel;
             excelCellNumber++, dbIndex++) {
            Cell examinationCell = row.getCell(excelCellNumber);
            if (examinationCell != null) {
                Examination examination = new Examination();
                examination.setDescription(examinationDescriptionService.getById(dbIndex));
                examination.setResult((float) examinationCell.getNumericCellValue());
                examination.setAdmission(admission);
                examinations.add(examination);
            }
        }
        return examinations;
    }

    public List<Medicament> getMedicamentListWithKey(Row row) {
        List<Medicament> medicaments = new ArrayList<>();
        int firstMedicamentInExcel = Integer.parseInt(properties.getProperty("medicament.aspirin.number"));
        int lastMedicamentInExcel = Integer.parseInt(properties.getProperty("medicament.fibrate.number"));
        for (int excelCellNumber = firstMedicamentInExcel, medicamentCount = 1; excelCellNumber <= lastMedicamentInExcel; excelCellNumber++, medicamentCount++) {
            Cell medicamentCell = row.getCell(excelCellNumber);
            if (medicamentCell != null && medicamentCell.getNumericCellValue() == 1) {
                Medicament medicament = medicamentService.getById(medicamentCount);
                medicaments.add(medicament);
            }
        }
        return medicaments;
    }

    public Smoking getSmokingWithKey(Row row) {
        Cell smokingCell = row.getCell(Integer.parseInt(properties.getProperty("smoking.number")));
        if (smokingCell != null) {
            return smokingService.getById((int) smokingCell.getNumericCellValue());
        }
        return new Smoking();
    }

    public Reoperation getReoperationWithKey(Row row) {
        Cell reoperationCell = row.getCell(Integer.parseInt(properties.getProperty("reoperation.number")));
        if (reoperationCell != null) {
            return reoperationService.getById((int) reoperationCell.getNumericCellValue());
        }
        return new Reoperation();
    }

    public Operation createOperation(Row row) {
        Operation operation = new Operation();

        operation.setOperationMode(getOperationModeWithKey(row));
        operation.setAnesthesia(getAnesthesiaWithKey(row));
        operation.setAnesthetic(getAnestheticWithKey(row));

        Cell durationCell = row.getCell(Integer.parseInt(properties.getProperty("operation.duration.number")));
        operation.setDuration((durationCell == null) ? -1 : (int) durationCell.getNumericCellValue());

        Cell aortaClottingTimeCell = row.getCell(Integer.parseInt(properties.getProperty("operation.aortaClottingTime.number")));
        operation.setAortaClottingTime((aortaClottingTimeCell == null) ? -1 : (int) aortaClottingTimeCell.getNumericCellValue());

        Cell noradrenalineCell = row.getCell(Integer.parseInt(properties.getProperty("operation.noradrenaline.number")));
        if (noradrenalineCell != null) {
            operation.setNoradrenaline((noradrenalineCell.getNumericCellValue() == 1) ? true : false);
        }

        Cell adrenaline = row.getCell(Integer.parseInt(properties.getProperty("operation.adrenaline.number")));
        if (adrenaline != null) {
            operation.setAdrenaline((adrenaline.getNumericCellValue() == 1) ? true : false);
        }

        Cell dopamine = row.getCell(Integer.parseInt(properties.getProperty("operation.dopamine.number")));
        if (dopamine != null) {
            operation.setDopamine((dopamine.getNumericCellValue() == 1) ? true : false);
        }

        Cell dobutamine = row.getCell(Integer.parseInt(properties.getProperty("operation.dobutamine.number")));
        if (dobutamine != null) {
            operation.setDobutamine((dobutamine.getNumericCellValue() == 1) ? true : false);
        }

        Cell ephedrine = row.getCell(Integer.parseInt(properties.getProperty("operation.ephedrine.number")));
        if (ephedrine != null) {
            operation.setEphedrine((ephedrine.getNumericCellValue() == 1) ? true : false);
        }

        operation.setBloodLost((int) row.getCell(Integer.parseInt(properties.getProperty("operation.bloodLost.number"))).getNumericCellValue());
        operation.setUrineExpelled((int) row.getCell(Integer.parseInt(properties.getProperty("operation.urineExpelled.number"))).getNumericCellValue());
        operation.setPackedCellsTransfused((int) row.getCell(Integer.parseInt(properties.getProperty("operation.packedCellsTransfused.number"))).getNumericCellValue());
        operation.setIcuTime((int) row.getCell(Integer.parseInt(properties.getProperty("operation.icuTime.number"))).getNumericCellValue());
        operation.setHospitalTime((int) row.getCell(Integer.parseInt(properties.getProperty("operation.hospitalTime.number"))).getNumericCellValue());

        Cell extendedVentilation = row.getCell(Integer.parseInt(properties.getProperty("operation.extendedVentilation.number")));
        if (extendedVentilation != null) {
            operation.setExtendedVentilation((extendedVentilation.getNumericCellValue() == 1) ? true : false);
        }

        operation.setVentilatorDays((int) row.getCell(Integer.parseInt(properties.getProperty("operation.ventilatorDays.number"))).getNumericCellValue());

        List<Complication> complications = getComplicationList(row);
        operation.setComplications(complications);
        operationService.saveOrUpdate(operation);

        return operation;
    }


    public List<Complication> getComplicationList(Row row) {
        List<Complication> complications = new ArrayList<>(30);
        int minsComplication = Integer.parseInt(properties.getProperty("complication.1.number"));
        int miComplication = Integer.parseInt(properties.getProperty("complication.2.number"));
        getComplications(minsComplication, miComplication, complications, row, 1);
        int firstComplicationInExcel = Integer.parseInt(properties.getProperty("complication.3.number"));
        int lastComplicationInExcel = Integer.parseInt(properties.getProperty("complication.30.number"));
        getComplications(firstComplicationInExcel, lastComplicationInExcel, complications, row, 3);

        return complications;
    }

    private List<Complication> getComplications(int firstIndex, int lastIndex, List<Complication> complications,
                                                Row row, int dbIndex) {
        for (int excelCellNumber = firstIndex; excelCellNumber <= lastIndex; excelCellNumber++) {
            Cell complicationCell = row.getCell(excelCellNumber);
            if (complicationCell != null && complicationCell.getNumericCellValue() == 1) { //what about "2"? - to do
                Complication complication = complicationService.getById(dbIndex);
                complication.setDescription(new ArrayList<>(Arrays.asList(complicationDescriptionService.getById(dbIndex))));
                complications.add(complication);
            }
            dbIndex++;
        }
        return complications;
    }


    public Anesthesia getAnesthesiaWithKey(Row row) {
        Cell anesthesiaCell = row.getCell(Integer.parseInt(properties.getProperty("anesthesia.number")));
        if (anesthesiaCell != null) {
            return anesthesiaService.getById((int) anesthesiaCell.getNumericCellValue());
        }
        return new Anesthesia();
    }

    public Anesthetic getAnestheticWithKey(Row row) {
        Cell anestheticCell = row.getCell(Integer.parseInt(properties.getProperty("anesthetic.number")));
        if (anestheticCell != null) {
            return anestheticService.getById((int) anestheticCell.getNumericCellValue());
        }
        return new Anesthetic();

    }


    public OperationMode getOperationModeWithKey(Row row) {
        Cell operationModeCell = row.getCell(Integer.parseInt(properties.getProperty("operationMode.number")));
        if (operationModeCell != null) {
            return operationModeService.getById((int) operationModeCell.getNumericCellValue());
        }
        return new OperationMode();
    }

    public List<OperationType> getOperationTypeListWithKey(Row row) {
        List<OperationType> operationTypes = new ArrayList<>();
        Cell operationTypeCell = row.getCell(Integer.parseInt(properties.getProperty("operationType.number")));
        if (operationTypeCell != null) {
            operationTypes.add(operationTypeService.getById((int) operationTypeCell.getNumericCellValue()));
            return operationTypes;
        }
        operationTypes.add(new OperationType());
        return operationTypes;
    }

    public Revisit getRevisitWithKey(Row row, Admission admission) {
        Revisit revisit = new Revisit();

        revisit.setAdmission(admission);

        Cell controlVisitCell = row.getCell(Integer.parseInt(properties.getProperty("controlVisit.number")));
        revisit.setControlVisit((controlVisitCell == null) ? -1 : (int) controlVisitCell.getNumericCellValue());

        Cell dateCell = row.getCell(Integer.parseInt(properties.getProperty("revisit.date.number")));
        if (dateCell != null) {
            Date date = null;
            java.util.Date dateCellValue = dateCell.getDateCellValue();
            try {
                date = new Date(dateCellValue.getYear(), dateCellValue.getMonth(), dateCellValue.getDay());
            } catch (Exception e) {
                e.printStackTrace();
            }
            revisit.setDate(date);
        }

        revisit.setCause(getRevisitCauseWithKey(row));

        return revisit;
    }

    public RevisitCause getRevisitCauseWithKey(Row row) {
        Cell revisitCauseCell = row.getCell(Integer.parseInt(properties.getProperty("revisit.cause.number")));
        if (revisitCauseCell != null) {
            return revisitCauseService.getById((int) revisitCauseCell.getNumericCellValue());
        }
        return new RevisitCause();
    }

    public List<Troponin> getTroponinListWithKey(Row row, Admission admission) {
        List<Troponin> troponins = new ArrayList<>();
        Troponin troponin = new Troponin();
        troponin.setAdmission(admission);

        Cell tnTCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tnt.number")));
        troponin.setTnt((tnTCell == null) ? -1 : (float) tnTCell.getNumericCellValue());

        Cell tnIUltraCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tniUltra.number")));
        troponin.setTniUltra((tnIUltraCell == null) ? -1 : (float) tnIUltraCell.getNumericCellValue());

        Cell tnICell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tni.number")));
        troponin.setTni((tnICell == null) ? -1 : (float) tnICell.getNumericCellValue());

        Cell tntDayCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tntDay.number")));
        troponin.setTntDay((tntDayCell == null) ? -1 : (float) tntDayCell.getNumericCellValue());

        Cell tnIDayCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tniDay.number")));
        troponin.setTni((tnIDayCell == null) ? -1 : (float) tnIDayCell.getNumericCellValue());

        troponins.add(troponin);
        return troponins;
    }

}