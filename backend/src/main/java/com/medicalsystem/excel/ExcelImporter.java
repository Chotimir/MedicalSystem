package com.medicalsystem.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Component
public class ExcelImporter {

    private final String excelFile = "baza2.xlsx";

    private XSSFSheet openSheet;
    private XSSFSheet evarSheet;

    private final RowImporter rowImporter;

    @Autowired
    public ExcelImporter(RowImporter rowImporter) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(excelFile)));
        this.openSheet = workbook.getSheetAt(0);
        this.evarSheet = workbook.getSheetAt(1);
        this.rowImporter = rowImporter;
    }

    public void importToDB() {
        /* Otwarte */
        Iterator<Row> rowIterator = openSheet.iterator();

        /* Skip headers */
        rowIterator.next();
        rowIterator.next();

        /* Iterate over rows and put each to the DB */
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            rowImporter.importToDB(row);
        }

        // TODO: EVAR

        System.out.println("IMPORT COMPLETED");
    }

}
