package com.medicalsystem.excel;

import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Patient;
import com.medicalsystem.service.AdmissionService;
import com.medicalsystem.service.PatientService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Iterator;

@Component
public class SaveDataFromExcelToDB {

    @Autowired
    PatientService patientService;

    @Autowired
    AdmissionService admissionService;

    @Autowired
    ObjectFromExcelFactory objectFromExcelFactory;

    public void configureRows() {
        XSSFSheet sheet = ExcelParser.parseExcelFile("C:\\Users\\Kamil\\SkyDrive\\Studia Semestr 6\\7 inzynierka\\baza.xlsx");
        if (sheet == null) {
            return;
        }
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        rowIterator.next();
        int i = 0;
        while (rowIterator.hasNext() && i < 3){
            insertRow(rowIterator.next());
            i++;
        }
    }

    private void insertRow(Row row) {
        Patient patient = objectFromExcelFactory.createPatient(row);
        patientService.saveOrUpdate(patient);
        Admission admission = objectFromExcelFactory.createAdmission(row);
        admissionService.saveOrUpdate(admission);

    }
}
