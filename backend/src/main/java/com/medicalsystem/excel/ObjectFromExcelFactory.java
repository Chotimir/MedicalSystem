package com.medicalsystem.excel;

import com.medicalsystem.domain.*;
import com.medicalsystem.service.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Component
public class ObjectFromExcelFactory {

    private final String excelColumnsFileName = "excelColumns.properties";
    private Properties properties;

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
    private PatientService patientService;
    private ReoperationService reoperationService;
    private RevisitCauseService revisitCauseService;
    private RevisitService revisitService;
    private SmokingService smokingService;
    private TroponinService troponinService;

    private DataFormatter formatter = new DataFormatter();

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
        String patientId = formatter.formatCellValue(patientIdCell);
        patient.setId(patientId.isEmpty() ? -1 : Integer.parseInt(patientId));

        Cell lastNameCell = row.getCell(Integer.parseInt(properties.getProperty("lastName.number")));
        String lastName = formatter.formatCellValue(lastNameCell);
        patient.setLastName(lastName);

        Cell firstNameCell = row.getCell(Integer.parseInt(properties.getProperty("firstName.number")));
        String firstName = formatter.formatCellValue(firstNameCell);
        patient.setFirstName(firstName);

        Cell sexCell = row.getCell(Integer.parseInt(properties.getProperty("sex.number")));
        String sex = formatter.formatCellValue(sexCell);
        patient.setSex(sex.isEmpty() ? 'x' : sex.charAt(0));

        Cell ageCell = row.getCell(Integer.parseInt(properties.getProperty("age.number")));
        String age = formatter.formatCellValue(ageCell);
        patient.setAge(age.isEmpty() ? -1 : Integer.parseInt(age));

        //choroby wspolistniejace
        patient.setDiseases(getDiseaseListWithKey(row));

        return patient;
    }

    public List<Disease> getDiseaseListWithKey(Row row) {
        List<Disease> diseases = new ArrayList<>();
        int firstDiseaseInExcel = Integer.parseInt(properties.getProperty("disease.shock.number"));
        int lastDiseaseInExcel = Integer.parseInt(properties.getProperty("disease.ekg.number"));
        for (int excelCellNumber = firstDiseaseInExcel, diseaseCount = 1; excelCellNumber <= lastDiseaseInExcel;
             excelCellNumber++, diseaseCount++) {
            Cell diseaseCell = row.getCell(excelCellNumber);
            String diseaseCellValue = formatter.formatCellValue(diseaseCell);
            if (!diseaseCellValue.equals("0")) {
                Disease disease = diseaseService.getById(diseaseCount);
                diseases.add(disease);
            }
        }
        return diseases;
    }


    public Patient getPatientWithKey(Row row) {
        Cell patientCell = row.getCell(Integer.parseInt(properties.getProperty("id.number")));
        String patientId = formatter.formatCellValue(patientCell);

        if (patientId.isEmpty())
            return new Patient();

        return patientService.getById(Integer.parseInt(patientId));
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
        String aaSymptoms = formatter.formatCellValue(aaSymptomsCell);
        admission.setAaSymptoms(aaSymptoms.isEmpty() || aaSymptoms.equals("x") ? -1 : Integer.parseInt(aaSymptoms));

        Cell aaSizeCell = row.getCell(Integer.parseInt(properties.getProperty("aaSize.number")));
        String aaSize = formatter.formatCellValue(aaSizeCell);
        admission.setAaSize(aaSize.isEmpty() || aaSize.equals("x") ? -1 : Integer.parseInt(aaSize));

        Cell maxAneurysmSizeCell = row.getCell(Integer.parseInt(properties.getProperty("maxAneurysmSize.number")));
        String maxAneurysmSize = formatter.formatCellValue(maxAneurysmSizeCell);
        admission.setMaxAneurysmSize(maxAneurysmSize.isEmpty() || maxAneurysmSize.equals("x") ? -1 : Integer.parseInt(maxAneurysmSize));

        Cell imageExaminationCell = row.getCell(Integer.parseInt(properties.getProperty("imageExamination.number")));
        String imageExamination = formatter.formatCellValue(imageExaminationCell);
        admission.setImageExamination(imageExamination.isEmpty() || imageExamination.equals("x") ? -1 : Integer.parseInt(imageExamination));

        Cell aneurysmLocationCell = row.getCell(Integer.parseInt(properties.getProperty("aneurysmLocation.number")));
        String aneurysmLocation = formatter.formatCellValue(aneurysmLocationCell);
        admission.setAneurysmLocation(aneurysmLocation.isEmpty() || aneurysmLocation.equals("x") ? -1 : Integer.parseInt(aneurysmLocation));

        admission.setSmoking(getSmokingWithKey(row));

        Cell asaScaleCell = row.getCell(Integer.parseInt(properties.getProperty("asaScale.number")));
        String asaScale = formatter.formatCellValue(asaScaleCell);
        admission.setAsaScale(asaScale.isEmpty() || asaScale.equals("x") ? -1 : Integer.parseInt(asaScale));

        Cell leeRcriCell = row.getCell(Integer.parseInt(properties.getProperty("leeRcri.number")));
        String leeRcri = formatter.formatCellValue(leeRcriCell);
        admission.setLeeRcri(leeRcri.isEmpty() || leeRcri.equals("x") ? -1 : Integer.parseInt(leeRcri));

        Cell pPossumCell = row.getCell(Integer.parseInt(properties.getProperty("pPossum.number")));
        String pPossum = formatter.formatCellValue(pPossumCell);
        admission.setPPossum(pPossum.isEmpty() || pPossum.equals("x") ? -1 : Integer.parseInt(pPossum));

        Cell faintCell = row.getCell(Integer.parseInt(properties.getProperty("faint.number")));
        String faint = formatter.formatCellValue(faintCell);
        admission.setFaint(faint.isEmpty() || faint.equals("x") ? -1 : Integer.parseInt(faint));

        admission.setReoperation(getReoperationWithKey(row));

        Cell commentsCell = row.getCell(Integer.parseInt(properties.getProperty("comments.number")));
        String comments = formatter.formatCellValue(commentsCell);
        admission.setComments(comments);

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
            String examinationCellValue = formatter.formatCellValue(examinationCell);
            if (!examinationCellValue.isEmpty()) {
                Examination examination = new Examination();
                examination.setDescription(examinationDescriptionService.getById(dbIndex));
                examination.setResult(Float.parseFloat(examinationCellValue));
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
            String medicamentCellValue = formatter.formatCellValue(medicamentCell);
            if (medicamentCellValue.equals("1")) {
                Medicament medicament = medicamentService.getById(medicamentCount);
                medicaments.add(medicament);
            }
        }
        return medicaments;
    }

    public Smoking getSmokingWithKey(Row row) {
        Cell smokingCell = row.getCell(Integer.parseInt(properties.getProperty("smoking.number")));
        String smoking = formatter.formatCellValue(smokingCell);

        if (smoking.isEmpty())
            return new Smoking();

        return smokingService.getById(Integer.parseInt(smoking));
    }

    public Reoperation getReoperationWithKey(Row row) {
        Cell reoperationCell = row.getCell(Integer.parseInt(properties.getProperty("reoperation.number")));
        String reoperation = formatter.formatCellValue(reoperationCell);

        if (reoperation.isEmpty())
            return new Reoperation();

        return reoperationService.getById((int) reoperationCell.getNumericCellValue());
    }

    public Operation createOperation(Row row) {
        Operation operation = new Operation();

        operation.setOperationMode(getOperationModeWithKey(row));
        operation.setAnesthesia(getAnesthesiaWithKey(row));
        operation.setAnesthetic(getAnestheticWithKey(row));

        Cell durationCell = row.getCell(Integer.parseInt(properties.getProperty("operation.duration.number")));
        String duration = formatter.formatCellValue(durationCell);
        operation.setDuration(duration.isEmpty() || duration.equals("x") ? -1 : Integer.parseInt(duration));

        Cell aortaClottingTimeCell = row.getCell(Integer.parseInt(properties.getProperty("operation.aortaClottingTime.number")));
        String aortaClottingTime = formatter.formatCellValue(aortaClottingTimeCell);
        operation.setAortaClottingTime(aortaClottingTime.isEmpty() || aortaClottingTime.equals("x") ? -1 : Integer.parseInt(aortaClottingTime));

        Cell noradrenalineCell = row.getCell(Integer.parseInt(properties.getProperty("operation.noradrenaline.number")));
        String noradrenaline = formatter.formatCellValue(noradrenalineCell);
        operation.setNoradrenaline(noradrenaline.equals("1"));

        Cell adrenalineCell = row.getCell(Integer.parseInt(properties.getProperty("operation.adrenaline.number")));
        String adrenaline = formatter.formatCellValue(adrenalineCell);
        operation.setAdrenaline(adrenaline.equals("1"));

        Cell dopamineCell = row.getCell(Integer.parseInt(properties.getProperty("operation.dopamine.number")));
        String dopamine = formatter.formatCellValue(dopamineCell);
        operation.setDopamine(dopamine.equals("1"));

        Cell dobutamineCell = row.getCell(Integer.parseInt(properties.getProperty("operation.dobutamine.number")));
        String dobutamine = formatter.formatCellValue(dobutamineCell);
        operation.setDobutamine(dobutamine.equals("1"));

        Cell ephedrineCell = row.getCell(Integer.parseInt(properties.getProperty("operation.ephedrine.number")));
        String ephedrine = formatter.formatCellValue(ephedrineCell);
        operation.setEphedrine(ephedrine.equals("1"));

        Cell bloodLostCell = row.getCell(Integer.parseInt(properties.getProperty("operation.bloodLost.number")));
        String bloodLost = formatter.formatCellValue(bloodLostCell);
        operation.setBloodLost(bloodLost.isEmpty() || bloodLost.equals("x") ? -1 : Integer.parseInt(bloodLost));

        Cell urineExpelledCell = row.getCell(Integer.parseInt(properties.getProperty("operation.urineExpelled.number")));
        String urineExpelled = formatter.formatCellValue(urineExpelledCell);
        operation.setUrineExpelled(urineExpelled.isEmpty() || bloodLost.equals("x") ? -1 : Integer.parseInt(urineExpelled));

        Cell packedCellsTransfusedCell = row.getCell(Integer.parseInt(properties.getProperty("operation.packedCellsTransfused.number")));
        String packedCellsTransfused = formatter.formatCellValue(packedCellsTransfusedCell);
        operation.setPackedCellsTransfused(packedCellsTransfused.isEmpty() || packedCellsTransfused.equals("x") ? -1 : Integer.parseInt(packedCellsTransfused));

        Cell icuTimeCell = row.getCell(Integer.parseInt(properties.getProperty("operation.icuTime.number")));
        String icuTime = formatter.formatCellValue(icuTimeCell);
        operation.setIcuTime(icuTime.isEmpty() || icuTime.equals("x") ? -1 : Integer.parseInt(icuTime));

        Cell hospitalTimeCell = row.getCell(Integer.parseInt(properties.getProperty("operation.hospitalTime.number")));
        String hospitalTime = formatter.formatCellValue(hospitalTimeCell);
        operation.setHospitalTime(hospitalTime.isEmpty() || hospitalTime.equals("x") ? -1 : Integer.parseInt(hospitalTime));

        Cell extendedVentilationCell = row.getCell(Integer.parseInt(properties.getProperty("operation.extendedVentilation.number")));
        String extendedVentilation = formatter.formatCellValue(extendedVentilationCell);
        operation.setExtendedVentilation(extendedVentilation.equals("1"));

        Cell ventilatorDaysCell = row.getCell(Integer.parseInt(properties.getProperty("operation.ventilatorDays.number")));
        String ventilatorDays = formatter.formatCellValue(ventilatorDaysCell);
        operation.setVentilatorDays(ventilatorDays.isEmpty() || ventilatorDays.equals("x") ? -1 : Integer.parseInt(ventilatorDays));

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
            String complicationCellValue = formatter.formatCellValue(complicationCell);
            if (complicationCellValue.equals("1")) { //what about "2"? - to do
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
        String anesthesia = formatter.formatCellValue(anesthesiaCell);

        if (anesthesia.isEmpty())
            return new Anesthesia();

        return anesthesiaService.getById(Integer.parseInt(anesthesia));
    }

    public Anesthetic getAnestheticWithKey(Row row) {
        Cell anestheticCell = row.getCell(Integer.parseInt(properties.getProperty("anesthetic.number")));
        String anesthetic = formatter.formatCellValue(anestheticCell);

        if (anesthetic.isEmpty())
            return new Anesthetic();

        return anestheticService.getById(Integer.parseInt(anesthetic));
    }


    public OperationMode getOperationModeWithKey(Row row) {
        Cell operationModeCell = row.getCell(Integer.parseInt(properties.getProperty("operationMode.number")));
        String operationMode = formatter.formatCellValue(operationModeCell);

        if (operationMode.isEmpty())
            return new OperationMode();

        return operationModeService.getById(Integer.parseInt(operationMode));
    }

    public List<OperationType> getOperationTypeListWithKey(Row row) {
        List<OperationType> operationTypes = new ArrayList<>();
        Cell operationTypeCell = row.getCell(Integer.parseInt(properties.getProperty("operationType.number")));
        String operationType = formatter.formatCellValue(operationTypeCell);

        if (operationType.isEmpty()) {
            operationTypes.add(new OperationType());
        } else {
            operationTypes.add(operationTypeService.getById(Integer.parseInt(operationType)));
        }

        return operationTypes;
    }

    public Revisit getRevisitWithKey(Row row, Admission admission) {
        Revisit revisit = new Revisit();

        revisit.setAdmission(admission);

        Cell controlVisitCell = row.getCell(Integer.parseInt(properties.getProperty("controlVisit.number")));
        String controlVisit = formatter.formatCellValue(controlVisitCell);
        revisit.setControlVisit(controlVisit.isEmpty() ? -1 : Integer.parseInt(controlVisit));

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
        String revisitCause = formatter.formatCellValue(revisitCauseCell);

        if (revisitCause.isEmpty())
            return new RevisitCause();

        return revisitCauseService.getById(Integer.parseInt(revisitCause));
    }

    public List<Troponin> getTroponinListWithKey(Row row, Admission admission) {
        List<Troponin> troponins = new ArrayList<>();
        Troponin troponin = new Troponin();
        troponin.setAdmission(admission);

        Cell tntCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tnt.number")));
        String tnt = formatter.formatCellValue(tntCell);
        troponin.setTnt(tnt.isEmpty() ? -1 : Float.parseFloat(tnt));

        Cell tniUltraCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tniUltra.number")));
        String tniUltra = formatter.formatCellValue(tniUltraCell);
        troponin.setTniUltra(tniUltra.isEmpty() ? -1 : Float.parseFloat(tniUltra));

        Cell tniCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tni.number")));
        String tni = formatter.formatCellValue(tniCell);
        troponin.setTni(tni.isEmpty() ? -1 : Float.parseFloat(tni));

        Cell tntDayCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tntDay.number")));
        String tntDay = formatter.formatCellValue(tntDayCell);
        troponin.setTntDay(tntDay.isEmpty() ? -1 : Float.parseFloat(tntDay));

        Cell tniDayCell = row.getCell(Integer.parseInt(properties.getProperty("troponin.tniDay.number")));
        String tniDay = formatter.formatCellValue(tniDayCell);
        troponin.setTniDay(tniDay.isEmpty() ? -1 : Float.parseFloat(tniDay));

        troponins.add(troponin);
        return troponins;
    }

}