package com.medicalsystem;

import com.medicalsystem.model.*;
import com.medicalsystem.service.*;
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

    //DONE
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

        return patient;
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

        admission.setImageExamination(1); //brak danych
        admission.setAneurysmLocation(1); //brak danych

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

        //examinations
        //revisits
        //troponins
        //leki_stosowane_przed_zabiegiem
//        List<Medicament> medicaments =
        //rodzaj_zabiegu

        return admission;
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

//    public static Reoperation createReoperation(Row row) {
//        Reoperation reoperation = new Reoperation();
//    }


    public static Anesthesia createAnesthesia(Row row) {
        Anesthesia anesthesia = new Anesthesia();

        //!!!!!!!!!!
        anesthesia.setId((int) row.getCell(8).getNumericCellValue());
//        anesthesia.setName((int) row.getCell().getNumericCellValue());
        return anesthesia;
    }

    public static Anesthetic createAnesthetic(Row row) {
        Anesthetic anesthetic = new Anesthetic();

        anesthetic.setId((int) row.getCell(9).getNumericCellValue());
        //nazwa_leku_znieczulajacego
        return anesthetic;
    }



    public static Disease createDisease(Row row) {
        Disease disease = new Disease();
        return disease;
    }

    public static DiseaseDescription createDiseaseDescription(Row row) {
        DiseaseDescription diseaseDescription = new DiseaseDescription();
        return diseaseDescription;
    }

    public static Examination createExamination(Row row) {
        Examination examination = new Examination();
        examination.setResult(1.0f); //brak w excelu
        return examination;
    }

//    public static ExaminationDescription createExaminationDescription(Row row) {
//        ExaminationDescription examinationDescription = new ExaminationDescription();
//        return examinationDescription;
//    }

//    public static Medicament createMedicament(Row row) {
//        Medicament medicament = new Medicament();
//
//        return medicament;
//    }


    //DONE
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

        List<Complication> complications = getComplicationList(row);
        operation.setComplications(complications);

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

    public List<Complication> getComplicationList(Row row) {
        List<Complication> complications = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            Complication complication = complicationService.getById(i);
            ComplicationDescription complicationDescription = getComplicationDescriptionWithKey(row);
            complication.setDescription(complicationDescription);
        }
        return complications;
    }

    public ComplicationDescription getComplicationDescriptionWithKey(Row row) {
        return complicationDescriptionService.getById(0); //to do, po dodaniu tabel slownikowych

    }

    public OperationMode getOperationModeWithKey(Row row) {
        Cell operationModeCell = row.getCell(10);
        if (operationModeCell != null) {
            return operationModeService.getById((int) operationModeCell.getNumericCellValue());
        }
        return new OperationMode();
    }

    public static OperationMode createOperationMode(Row row) {
        OperationMode operationMode = new OperationMode();
//        operationMode.setId((int) row.getCell(10).getNumericCellValue());
        //nazwa trybu

        return operationMode;
    }

    public static OperationType createOperationType(Row row) {
        OperationType operationType = new OperationType();
        operationType.setId((int) row.getCell(7).getNumericCellValue());

        //nazwa rodzaju zabiegu

        return operationType;
    }


    public static Reoperation createReoperation(Row row) {
        //!!!!!!!!!!! nazwa
        Reoperation reoperation = new Reoperation((int) row.getCell(95).getNumericCellValue(), "");
        return reoperation;
    }

    public static Revisit createRevisit(Row row) {
        //id ponownej wizity
        Revisit revisit = new Revisit();
        revisit.setControlVisit((int) row.getCell(100).getNumericCellValue());

        java.util.Date dateCellValue = row.getCell(102).getDateCellValue();
        Date date = null;
        try {
            date = new Date(dateCellValue.getYear(), dateCellValue.getMonth(), dateCellValue.getDay());
        } catch (Exception e) {
            e.printStackTrace();
        }
        revisit.setDate(date);

        RevisitCause revisitCause = new RevisitCause((int) row.getCell(103).getNumericCellValue(), "");
        revisit.setCause(revisitCause);

        return revisit;
    }

    public static RevisitCause createRevisitCause(Row row) {
        RevisitCause revisitCause = new RevisitCause((int) row.getCell(103).getNumericCellValue(), "");
        return revisitCause;
    }



    public static Troponin createTroponin(Row row) {
        Troponin troponin = new Troponin();
        troponin.setTnt((float) row.getCell(66).getNumericCellValue());
        troponin.setTnlUltra((float) row.getCell(67).getNumericCellValue());
        troponin.setTnl((float) row.getCell(68).getNumericCellValue());
        troponin.setTntDay((float) row.getCell(69).getNumericCellValue());
        troponin.setTnlDay((float) row.getCell(70).getNumericCellValue());

        return troponin;
    }



}
