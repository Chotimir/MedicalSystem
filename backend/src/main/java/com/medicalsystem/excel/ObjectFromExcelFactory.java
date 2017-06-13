package com.medicalsystem.excel;

import com.medicalsystem.model.*;
import com.medicalsystem.service.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    @Getter @Setter
    private PatientService patientService;
    private ReoperationService reoperationService;
    private RevisitCauseService revisitCauseService;
    private RevisitService revisitService;
    private SmokingService smokingService;
    private TroponinService troponinService;

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
    }

    public Patient createPatient(Row row) {
        Patient patient = new Patient();

        Cell patientIdCell = row.getCell(0);
        patient.setId((patientIdCell == null) ? -1 : (int) patientIdCell.getNumericCellValue());

        Cell lastNameCell = row.getCell(1);
        patient.setLastName((lastNameCell == null) ? "" : lastNameCell.getStringCellValue());

        Cell firstNameCell = row.getCell(2);
        patient.setFirstName((firstNameCell == null) ? "" : firstNameCell.getStringCellValue());

        Cell sexCell = row.getCell(3);
        patient.setSex((sexCell == null) ? 'x' : sexCell.getStringCellValue().charAt(0));

        Cell ageCell = row.getCell(4);
        patient.setAge((ageCell == null) ? -1 : (int) row.getCell(4).getNumericCellValue());

        patient.setDiseases(getDiseaseListWithKey(row)); //choroby wspolistniejace

        return patient;
    }

    public List<Disease> getDiseaseListWithKey(Row row) {
        List<Disease> diseases = new ArrayList<>();
        for (int excelCellNumber = 17, diseaseCount = 1; excelCellNumber < 28; excelCellNumber++, diseaseCount++) {
            Cell diseaseCell = row.getCell(excelCellNumber);
            if (diseaseCell != null && diseaseCell.getNumericCellValue() == 1) { //to analyse
                Disease disease = diseaseService.getById(diseaseCount);
                diseases.add(disease);
            }
        }
        return diseases;
    }

    public static DiseaseDescription createDiseaseDescription(Row row) {
        DiseaseDescription diseaseDescription = new DiseaseDescription();
        return diseaseDescription;
    }

    public Patient getPatientWithKey(Row row) {
        Cell patientCell = row.getCell(0);
        if (patientCell != null) {
            return patientService.getById((int) patientCell.getNumericCellValue());
        }
        return new Patient();
    }

    public Admission createAdmission(Row row) {
        Admission admission = new Admission();

        admission.setPatient(getPatientWithKey(row));

        admission.setOperation(createOperation(row));

        java.util.Date admissionDateCell = row.getCell(5).getDateCellValue();
        Date admissionDate = new Date(admissionDateCell.getYear(), admissionDateCell.getMonth(), admissionDateCell.getDay());
        admission.setAdmissionDate(admissionDate);

        java.util.Date operationDateCell = row.getCell(6).getDateCellValue();
        Date operationDate = new Date(operationDateCell.getYear(), operationDateCell.getMonth(), operationDateCell.getDay());
        admission.setOperationDate(operationDate);

        Cell aaSymptomsCell = row.getCell(11);
        admission.setAaSymptoms((aaSymptomsCell == null) ? -1 : (int) aaSymptomsCell.getNumericCellValue());

        Cell aaSizeCell = row.getCell(12);
        admission.setAaSize((aaSizeCell == null) ? -1 : (int) aaSizeCell.getNumericCellValue());

        Cell maxAneurysmSizeCell = row.getCell(13);
        admission.setMaxAneurysmSize((maxAneurysmSizeCell == null) ? -1 : (int) maxAneurysmSizeCell.getNumericCellValue());

        admission.setImageExamination(1); //brak danych w excelu
        admission.setAneurysmLocation(1); //brak danych w excelu

        admission.setSmoking(getSmokingWithKey(row));

        Cell asaScaleCell = row.getCell(15);
        admission.setAsaScale((asaScaleCell == null) ? -1 : (int) asaScaleCell.getNumericCellValue());

        Cell leeRcriCell = row.getCell(28);
        admission.setLeeRcri((leeRcriCell == null) ? -1 : (int) leeRcriCell.getNumericCellValue());

        Cell pPossuCell = row.getCell(29);
        admission.setPPossu((pPossuCell == null) ? -1 : (int) pPossuCell.getNumericCellValue());

        Cell faintCell = row.getCell(16);
        admission.setFaint((faintCell == null) ? -1 : (int) faintCell.getNumericCellValue());

        admission.setReopration(getReoperationWithKey(row));

        Cell commentsCell = row.getCell(104);
        admission.setComments((commentsCell == null) ? "" : commentsCell.getStringCellValue());

        admissionService.saveOrUpdate(admission); //because I need an ID in next method calls

        admission.setMedicaments(getMedicamentListWithKey(row));
        admission.setOperationTypes(getOperationTypeListWithKey(row));

        //doesn't work, empty tables in db
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
        for (int excelCellNumber = 30, examinationCount = 1; excelCellNumber < 36; excelCellNumber++, examinationCount++) {
            Cell examinationCell = row.getCell(excelCellNumber);
            if (examinationCell != null) {
                Examination examination = new Examination();
                examination.setDescription(examinationDescriptionService.getById(examinationCount));
                examination.setResult((float) examinationCell.getNumericCellValue());
                examination.setAdmission(admission);
                examinations.add(examination);
            }
        }
        return examinations;
    }

    public List<Medicament> getMedicamentListWithKey(Row row) {
        List<Medicament> medicaments = new ArrayList<>();
        for (int excelCellNumber = 36, medicamentCount = 1; excelCellNumber < 48; excelCellNumber++, medicamentCount++) {
            Cell medicamentCell = row.getCell(excelCellNumber);
            if (medicamentCell != null && medicamentCell.getNumericCellValue() == 1) {
                Medicament medicament = medicamentService.getById(medicamentCount);
                medicaments.add(medicament);
            }
        }
        return medicaments;
    }

    public Smoking getSmokingWithKey(Row row) {
        Cell smokingCell = row.getCell(14);
        if (smokingCell != null) {
            return smokingService.getById((int) smokingCell.getNumericCellValue());
        }
        return new Smoking(); //to do - remove "nullable = false" from domain classes
    }

    public Reoperation getReoperationWithKey(Row row) {
        Cell reoperationCell = row.getCell(95);
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

        Cell durationCell = row.getCell(48);
        operation.setDuration((durationCell == null) ? -1 : (int) durationCell.getNumericCellValue());

        Cell aortaClottingTimeCell = row.getCell(49);
        operation.setAortaClottingTime((aortaClottingTimeCell == null) ? -1 : (int) aortaClottingTimeCell.getNumericCellValue());

        Cell noradrenalineCell = row.getCell(51);
        if (noradrenalineCell != null) {
            operation.setNoradrenaline((noradrenalineCell.getNumericCellValue() == 1) ? true : false);
        }

        Cell adrenaline = row.getCell(52);
        if (adrenaline != null) {
            operation.setAdrenaline((adrenaline.getNumericCellValue() == 1) ? true : false);
        }

        Cell dopamine = row.getCell(53);
        if (dopamine != null) {
            operation.setDopamine((dopamine.getNumericCellValue() == 1) ? true : false);
        }

        Cell dobutamine = row.getCell(54);
        if (dobutamine != null) {
            operation.setDobutamine((dobutamine.getNumericCellValue() == 1) ? true : false);
        }

        Cell ephedrine = row.getCell(55);
        if (ephedrine != null) {
            operation.setEphedrine((ephedrine.getNumericCellValue() == 1) ? true : false);
        }

        operation.setBloodLost((int) row.getCell(56).getNumericCellValue());
        operation.setUrineExpelled((int) row.getCell(57).getNumericCellValue());
        operation.setPackedCellsTransfused((int) row.getCell(58).getNumericCellValue());
        operation.setIcuTime((int) row.getCell(59).getNumericCellValue());
        operation.setHospitalTime((int) row.getCell(60).getNumericCellValue());

        Cell extendedVentilation = row.getCell(62);
        if (extendedVentilation != null) {
            operation.setExtendedVentilation((extendedVentilation.getNumericCellValue() == 1) ? true : false);
        }

        operation.setVentilatorDays((int) row.getCell(63).getNumericCellValue());

//        List<Complication> complications = getComplicationList(row);
//        operation.setComplications(complications);
        operationService.saveOrUpdate(operation);

        return operation;
    }

    public Anesthesia getAnesthesiaWithKey(Row row) {
        Cell anesthesiaCell = row.getCell(8);
        if (anesthesiaCell != null) {
            return anesthesiaService.getById((int) anesthesiaCell.getNumericCellValue());
        }
        return new Anesthesia();
    }

    public Anesthetic getAnestheticWithKey(Row row) {
        Cell anestheticCell = row.getCell(9);
        if (anestheticCell != null) {
            return anestheticService.getById((int) anestheticCell.getNumericCellValue());
        }
        return new Anesthetic();

    }

    //add excel value in class
//    public List<Complication> getComplicationList(Row row) {
//        List<Complication> complications = new ArrayList<>(30);
//        for (int i = 1; i < 31; i++) {
//            Complication complication = complicationService.getById(i);
//            List<ComplicationDescription> complicationDescription = getComplicationDescriptionWithKey(row);
//             complication.setDescription(complicationDescription);
//        }
//        return complications;
//    }

    public List<ComplicationDescription> getComplicationDescriptionWithKey(Row row) {
        List<ComplicationDescription> complicationDescriptions = new ArrayList<>();
        complicationDescriptions.add(complicationDescriptionService.getById(1));
        return complicationDescriptions;

    }

    public OperationMode getOperationModeWithKey(Row row) {
        Cell operationModeCell = row.getCell(10);
        if (operationModeCell != null) {
            return operationModeService.getById((int) operationModeCell.getNumericCellValue());
        }
        return new OperationMode();
    }

    public List<OperationType> getOperationTypeListWithKey(Row row) {
        List<OperationType> operationTypes = new ArrayList<>();
        Cell operationTypeCell = row.getCell(7);
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

        Cell controlVisitCell = row.getCell(100);
        revisit.setControlVisit((controlVisitCell == null) ? -1 : (int) controlVisitCell.getNumericCellValue());

        Cell dateCell = row.getCell(102);
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
        Cell revisitCauseCell = row.getCell(103);
        if (revisitCauseCell != null) {
            return revisitCauseService.getById((int) revisitCauseCell.getNumericCellValue());
        }
        return new RevisitCause();
    }

    public List<Troponin> getTroponinListWithKey(Row row, Admission admission) {
        List<Troponin> troponins = new ArrayList<>();
        Troponin troponin = new Troponin();
        troponin.setAdmission(admission);


        Cell tnTCell = row.getCell(66);
        troponin.setTnt((tnTCell == null) ? -1 : (float) tnTCell.getNumericCellValue());

        Cell tnlUltraCell = row.getCell(67);
        troponin.setTnlUltra((tnlUltraCell == null) ? -1 : (float) tnlUltraCell.getNumericCellValue());

        Cell tnlCell = row.getCell(66);
        troponin.setTnl((tnlCell == null) ? -1 : (float) tnlCell.getNumericCellValue());

        Cell tntDayCell = row.getCell(67);
        troponin.setTntDay((tntDayCell == null) ? -1 : (float) tntDayCell.getNumericCellValue());

        Cell tnlDayCell = row.getCell(66);
        troponin.setTnl((tnlDayCell == null) ? -1 : (float) tnlDayCell.getNumericCellValue());

        return troponins;
    }

}