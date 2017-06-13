package com.medicalsystem.excel;

import com.medicalsystem.model.Patient;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class XlsxExport {

    @Autowired
    ObjectFromExcelFactory objectFromExcelFactory;
    private static final String path = "C:\\Users\\Kamil\\SkyDrive\\Studia Semestr 6\\7 inzynierka\\eksport\\results\\test.xls";
    private static final Logger log = LoggerFactory.getLogger(XlsxExport.class);

    public void exportToExcel() {
        Patient patient = objectFromExcelFactory.getPatientService().getById(1);
        List<String> patientData = new ArrayList<>();
        patientData.add(String.valueOf(patient.getId()));
        patientData.add(patient.getFirstName());
        patientData.add(patient.getLastName());
        patientData.add(String.valueOf(patient.getSex()));
        patientData.add(String.valueOf(patient.getAge()));
        String wynik = "";
        for (String s : patientData) {
            wynik = wynik + s + ",";
        }
        List<CSVRecord> csvRecords = divideStringIntoRows(wynik);

        String excelFileName = path;

        try (OutputStream fileOutput = new FileOutputStream(excelFileName)) {
            HSSFWorkbook wb = createCells(csvRecords);
            wb.write(fileOutput);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

    }


    private List<CSVRecord> divideStringIntoRows(String data) {
        Reader in = new StringReader(data);
        List<CSVRecord> elementsList = null;
        try {
            CSVParser parser = new CSVParser(in, CSVFormat.EXCEL);
            elementsList = parser.getRecords();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return elementsList;
    }

    private HSSFWorkbook createCells(List<CSVRecord> elementsList) {
        String sheetName = "Sheet1";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);

        for(int r = 0; r < elementsList.size(); r++) {
            HSSFRow row = sheet.createRow(r);
            for (int c = 0; c <elementsList.get(r).size(); c++) {
                HSSFCell cell = row.createCell(c);
                cell.setCellValue(elementsList.get(r).get(c));
            }
        }
        return wb;
    }
}
