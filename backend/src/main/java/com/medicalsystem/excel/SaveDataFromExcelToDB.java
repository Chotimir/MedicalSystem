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

    final
    PatientService patientService;

    final
    AdmissionService admissionService;

    final
    ObjectFromExcelFactory objectFromExcelFactory;

    @Autowired
    public SaveDataFromExcelToDB(PatientService patientService, AdmissionService admissionService, ObjectFromExcelFactory objectFromExcelFactory) {
        this.patientService = patientService;
        this.admissionService = admissionService;
        this.objectFromExcelFactory = objectFromExcelFactory;
    }

    public void configureRows() {
        XSSFSheet sheet = ExcelParser.parseExcelFile("baza2.xlsx");
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
