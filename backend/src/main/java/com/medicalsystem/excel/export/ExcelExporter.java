package com.medicalsystem.excel.export;

import com.medicalsystem.service.AdmissionService;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class ExcelExporter {

    private final String excelFilePath = "bazaEskport.xlsx";

    private XSSFSheet openSheet;
    private XSSFSheet evarSheet;
    private XSSFWorkbook workbook;
    private RowExporter rowExporter;
    private AdmissionService admissionService;

    @Autowired
    public ExcelExporter(RowExporter rowExporter, AdmissionService admissionService) {
        workbook = new XSSFWorkbook();
        this.openSheet = workbook.createSheet("Otwarte");
        this.evarSheet = workbook.createSheet("EVAR");
        this.rowExporter = rowExporter;
        this.admissionService = admissionService;
    }

    public void exportToExcel() {
        try (OutputStream fileOutput = new FileOutputStream(excelFilePath)) {
            rowExporter.setColumnNames(openSheet);
            long count = admissionService.countEntities();

            for(int objectId = 1; objectId <= count; objectId++) {
                rowExporter.saveData(openSheet.createRow(objectId+1), objectId);
            }

            workbook.write(fileOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
