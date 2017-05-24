package com.medicalsystem.speadsheet;

import com.medicalsystem.model.Patient;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class MSExcelImporter {

    public void importToDB(String spreadsheetFilePath) {
        Sheet sheet = getSheet(spreadsheetFilePath);

        for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            insertRow(row);
        }

    }

    private void insertRow(Row row) {

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
