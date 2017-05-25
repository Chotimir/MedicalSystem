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

        admission.setComments(row.getCell(97).getStringCellValue());

        admission.setAaSymptoms((int) row.getCell(11).getNumericCellValue());

        admission.setAaSize((int) row.getCell(12).getNumericCellValue());

        admission.setMaxAneurysmSize((int) row.getCell(13).getNumericCellValue());



        Smoking smoking = new Smoking((int) row.getCell(14).getNumericCellValue(), "");
        admission.setSmoking(smoking);

        admission.setAsaScale((int) row.getCell(15).getNumericCellValue());

        admission.setLeeRcri((int) row.getCell(28).getNumericCellValue());

        admission.setPPossu(row.getCell(29).getNumericCellValue());

        admission.setFaint((int) row.getCell(16).getNumericCellValue());

        Reoperation reoperation = new Reoperation((int) row.getCell(88).getNumericCellValue(), "");
        admission.setReopration(reoperation);

        //BRAK W EXCELU
//        admission.setImageExamination((int) row.getCell().getNumericCellValue());
//        admission.setAneurysmLocation((int) row.getCell().getNumericCellValue());
        //id, patient, operation, examinations, revisits, troponins

        return admission;
    }


}
