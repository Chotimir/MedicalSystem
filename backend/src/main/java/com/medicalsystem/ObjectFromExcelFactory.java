package com.medicalsystem;

import com.medicalsystem.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.sql.Date;

public class ObjectFromExcelFactory {
    public static Patient createPatient(Row row) {
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

    public static Admission createAdmission(Row row) {
        Admission admission = new Admission();

        java.util.Date admissionDateCell = row.getCell(5).getDateCellValue();
        Date admissionDate = new Date(admissionDateCell.getYear(), admissionDateCell.getMonth(), admissionDateCell.getDay());
        admission.setAdmissionDate(admissionDate);

        java.util.Date operationDateCell = row.getCell(6).getDateCellValue();
        Date operationDate = new Date(operationDateCell.getYear(), operationDateCell.getMonth(), operationDateCell.getDay());
        admission.setOperationDate(operationDate);

        Cell commentsCell = row.getCell(104);
        admission.setComments((commentsCell == null) ? "" : commentsCell.getStringCellValue());

        Cell aaSymptomsCell = row.getCell(11);
        admission.setAaSymptoms((aaSymptomsCell == null) ? -1 : (int) aaSymptomsCell.getNumericCellValue());

        Cell aaSizeCell = row.getCell(12);
        admission.setAaSize((aaSizeCell == null) ? -1 : (int) aaSizeCell.getNumericCellValue());

        Cell maxAneurysmSizeCell = row.getCell(13);
        admission.setMaxAneurysmSize((maxAneurysmSizeCell == null) ? -1 : (int) maxAneurysmSizeCell.getNumericCellValue());

        admission.setImageExamination(1); //brak danych
        admission.setAneurysmLocation(1); //brak danych

        admission.setSmoking(createSmoking(row));

        Cell asaScaleCell = row.getCell(15);
        admission.setAsaScale((asaScaleCell == null) ? -1 : (int) asaScaleCell.getNumericCellValue());

        Cell leeRcriCell = row.getCell(28);
        admission.setLeeRcri((leeRcriCell == null) ? -1 : (int) leeRcriCell.getNumericCellValue());

        Cell pPossuCell = row.getCell(29);
        admission.setPPossu((pPossuCell == null) ? -1 : (int) pPossuCell.getNumericCellValue());

        Cell faintCell = row.getCell(16);
        admission.setFaint((faintCell == null) ? -1 : (int) faintCell.getNumericCellValue());

        //!!!!!!!!!!!
        Reoperation reoperation = new Reoperation((int) row.getCell(95).getNumericCellValue(), "");
        admission.setReopration(reoperation);

        //examinations
        //revisits
        //troponins
        //leki_stosowane_przed_zabiegiem
//        List<Medicament> medicaments =
        //rodzaj_zabiegu

        return admission;
    }

    public static Smoking createSmoking(Row row) {
        //!!!!!
        Smoking smoking = new Smoking();

        Cell smokingIdCell = row.getCell(14);
        smoking.setId((smokingIdCell == null) ? -1 : (int) smokingIdCell.getNumericCellValue());
        smoking.setText("");

        return smoking;
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

//    public static Complication createComplication(Row row) {
//        Complication complication = new Complication();
//
//
//        return complication;
//    }
//
//    public static ComplicationDescription createComplicationDescription(Row row) {
//        ComplicationDescription complicationDescription = new ComplicationDescription();
//        return complicationDescription;
//    }

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

    public static Operation createOperation(Row row) {
        Operation operation = new Operation();
        //anesthesia cell 8
        //anesthetic cell 10

        operation.setDuration((int) row.getCell(48).getNumericCellValue());

        operation.setAortaClottingTime((int) row.getCell(49).getNumericCellValue());
        int numericCellValue = (int) row.getCell(51).getNumericCellValue();
        Boolean nora = Boolean.valueOf(String.valueOf(numericCellValue));
        operation.setNoradrenaline(nora);

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

        Cell extendedVentilation = row.getCell(62);
        if (extendedVentilation != null) {
            operation.setExtendedVentilation((extendedVentilation.getNumericCellValue() == 1) ? true : false);
        }

        operation.setBloodLost((int) row.getCell(56).getNumericCellValue());
        operation.setUrineExpelled((int) row.getCell(57).getNumericCellValue());
        operation.setPackedCellsTransfused((int) row.getCell(58).getNumericCellValue());
        operation.setIcuTime((int) row.getCell(59).getNumericCellValue());
        operation.setHospitalTime((int) row.getCell(60).getNumericCellValue());
        operation.setVentilatorDays((int) row.getCell(63).getNumericCellValue());



        //"powiklania_operacja"
        //complications

        return operation;
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
