package com.medicalsystem.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelParser {

    public static XSSFSheet parseExcelFile(String filePath) {
        try {
            return transformExcelFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static XSSFSheet transformExcelFile(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        return workbook.getSheetAt(1);
    }
}
