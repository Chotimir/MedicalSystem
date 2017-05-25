package com.medicalsystem;

import com.medicalsystem.model.*;
import org.apache.poi.ss.usermodel.Row;

import java.sql.Date;

public class ObjectFromExcelFactory {
    public static Patient createPatient(Row row) {
        Patient patient = new Patient();

        patient.setId((int) row.getCell(0).getNumericCellValue());
        patient.setLastName(row.getCell(1).getStringCellValue());
        patient.setFirstName(row.getCell(2).getStringCellValue());
        patient.setSex(row.getCell(3).getStringCellValue().charAt(0));
        patient.setAge((int) row.getCell(4).getNumericCellValue());

        //choroby wspolistniejace

        return patient;
    }

    public static Admission createAdmission(Row row) {
        Admission admission = new Admission();

        java.util.Date dateCellValue = row.getCell(5).getDateCellValue();
        Date admissionDate = new Date(dateCellValue.getYear(), dateCellValue.getMonth(), dateCellValue.getDay());
        admission.setAdmissionDate(admissionDate);

        dateCellValue = row.getCell(6).getDateCellValue();
        Date operationDate = new Date(dateCellValue.getYear(), dateCellValue.getMonth(), dateCellValue.getDay());
        admission.setOperationDate(operationDate);

        admission.setComments(row.getCell(104).getStringCellValue());

        admission.setAaSymptoms((int) row.getCell(11).getNumericCellValue());

        admission.setAaSize((int) row.getCell(12).getNumericCellValue());

        admission.setMaxAneurysmSize((int) row.getCell(13).getNumericCellValue());

        //imageExamination
        //aneurysmLocation

        //!!!!!
        Smoking smoking = new Smoking((int) row.getCell(14).getNumericCellValue(), "");
        admission.setSmoking(smoking);

        admission.setAsaScale((int) row.getCell(15).getNumericCellValue());

        admission.setLeeRcri((int) row.getCell(28).getNumericCellValue());

        admission.setPPossu(row.getCell(29).getNumericCellValue());

        admission.setFaint((int) row.getCell(16).getNumericCellValue());

        //!!!!!!!!!!!
        Reoperation reoperation = new Reoperation((int) row.getCell(95).getNumericCellValue(), "");
        admission.setReopration(reoperation);

        //examinations
        //revisits
        //troponins
        //leki_stosowane_przed_zabiegiem
        //rodzaj_zabiegu

        return admission;
    }

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

    public static Complication createComplication(Row row) {
        Complication complication = new Complication();


        return complication;
    }

    public static ComplicationDescription createComplicationDescription(Row row) {
        ComplicationDescription complicationDescription = new ComplicationDescription();
        return complicationDescription;
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
        return examination;
    }

    public static ExaminationDescription createExaminationDescription(Row row) {
        ExaminationDescription examinationDescription = new ExaminationDescription();
        return examinationDescription;
    }

    public static Medicament createMedicament(Row row) {
        Medicament medicament = new Medicament();

        return medicament;
    }

    public static Operation createOperation(Row row) {
        Operation operation = new Operation();
        OperationMode operationMode = new OperationMode();
        operationMode.setId((int) row.getCell(10).getNumericCellValue());
        operationMode.setName("");

        operation.setOperationMode(operationMode);

        //anesthesia cell 8
        //anesthetic cell 10

        operation.setDuration((int) row.getCell(48).getNumericCellValue());

        operation.setAortaClottingTime((int) row.getCell(49).getNumericCellValue());

        operation.setNoradrenaline((row.getCell(51).getBooleanCellValue()));
        operation.setAdrenaline((row.getCell(52).getBooleanCellValue()));
        operation.setDopamine((row.getCell(53).getBooleanCellValue()));
        operation.setDobutamine((row.getCell(54).getBooleanCellValue()));
        operation.setEphedrine((row.getCell(55).getBooleanCellValue()));
        operation.setBloodLost((int) row.getCell(56).getNumericCellValue());
        operation.setUrineExpelled((int) row.getCell(57).getNumericCellValue());
        operation.setPackedCellsTransfused((int) row.getCell(58).getNumericCellValue());
        operation.setIcuTime((int) row.getCell(59).getNumericCellValue());
        operation.setHospitalTime((int) row.getCell(60).getNumericCellValue());
        operation.setExtendedVentilation((row.getCell(62).getBooleanCellValue()));
        operation.setVentilatorDays((int) row.getCell(63).getNumericCellValue());

        //"powiklania_operacja"
        //complications

        return operation;
    }

    public static OperationMode createOperationMode(Row row) {
        OperationMode operationMode = new OperationMode();
        operationMode.setId((int) row.getCell(10).getNumericCellValue());
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
        //id przyjecia

        Revisit revisit = new Revisit();
        revisit.setControlVisit((int) row.getCell(100).getNumericCellValue());

        java.util.Date dateCellValue = row.getCell(102).getDateCellValue();
        Date date = null;
        try {
            date = new Date(dateCellValue.getYear(), dateCellValue.getMonth(), dateCellValue.getDay());
        } catch (Exception e) {

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

    public static Smoking createSmoking(Row row) {
        //!!!!!
        Smoking smoking = new Smoking((int) row.getCell(14).getNumericCellValue(), "");
        return smoking;
    }

    public static Troponin createTroponin(Row row) {
        Troponin troponin = new Troponin();
        //set id
        //set addmission

        troponin.setTnt((float) row.getCell(66).getNumericCellValue());
        troponin.setTnlUltra((float) row.getCell(67).getNumericCellValue());
        troponin.setTnl((float) row.getCell(68).getNumericCellValue());
        troponin.setTntDay((float) row.getCell(69).getNumericCellValue());
        troponin.setTnlDay((float) row.getCell(70).getNumericCellValue());

        return troponin;
    }



}
