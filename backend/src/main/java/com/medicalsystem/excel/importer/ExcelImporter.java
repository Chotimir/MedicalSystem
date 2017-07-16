package com.medicalsystem.excel.importer;

import lombok.extern.java.Log;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/*
TODO: na razie obsługiwany jest import jedynie z pierwszego arkusza (zabiegi otwarte)
TODO: EVARy różnią się kilkoma kolumnami, trzeba to rozkminić
 */

@Component
@Log
public class ExcelImporter {

    // Temporary for testing purposes
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

    /**
     * Imports data from the spreadsheet.
     */
    public void importToDB() {
        log.info("IMPORTING DATA...");

        importOpenSheet();
        importEvarSheet();

        log.info("IMPORT COMPLETE");
    }

    /**
     * Imports data from the 'open' sheet.
     */
    private void importOpenSheet() {
        /* Otwarte */
        Iterator<Row> rowIterator = openSheet.iterator();

        /* Skip headers */
        rowIterator.next();
        rowIterator.next();

        int rows = 0;

        /* Iterate over rows and put each to the DB */
        while (rowIterator.hasNext()) {
            /* TODO: remove for production */
            if (rows++ > 20)
                break;
            Row row = rowIterator.next();
            rowImporter.importToDB(row);
        }
    }

    /**
     * Imports data from the 'EVAR' sheet.
     */
    private void importEvarSheet() {
        // TODO: Implement
    }

}
