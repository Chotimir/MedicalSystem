package com.medicalsystem.speadsheet;

import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Patient;
import com.medicalsystem.util.DateUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class MSExcelImporter {

    public void importToDB(String spreadsheetFilePath) {
        Sheet sheet = getSheet(spreadsheetFilePath);

        for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            insertRow(row);
        }

    }

    private void insertRow(Row row) {
        // tu tworzysz obiekty z jednego rzedu z excela, robisz powiazania i zapisujesz do bazy
    }

    private Patient createPatient(Row row) {
        Patient patient = new Patient();

        // set id
        int id = Integer.parseInt(row.getCell(0).getStringCellValue());
        patient.setId(id);

        // set last name
        String lastName = row.getCell(1).getStringCellValue();
        patient.setLastName(lastName);

        // set first name
        String firstName = row.getCell(2).getStringCellValue();
        patient.setLastName(firstName);

        // set sex
        char sex = row.getCell(3).getStringCellValue().charAt(0);
        patient.setSex(sex);

        // set age
        int age = Integer.parseInt(row.getCell(4).getStringCellValue());
        patient.setAge(age);

        return patient;
    }

    private Admission createAdmission(Row row) {
        Admission admission = new Admission();

        // set admission date
        String admissionDateStr = row.getCell(5).getStringCellValue();
        Date admissionDate = DateUtils.fromExcelString(admissionDateStr);
        admission.setAdmissionDate(admissionDate);

        // set operation date
        String operationDateStr = row.getCell(6).getStringCellValue();
        Date operationDate = DateUtils.fromExcelString(operationDateStr);
        admission.setOperationDate(operationDate);



        return admission;

    }

    private Sheet getSheet(String spreadsheetFilePath) {
        Sheet sheet = null;
        try {
            Workbook wb = WorkbookFactory.create(new File(spreadsheetFilePath));
            sheet = wb.getSheetAt(0);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return sheet;
    }
}
