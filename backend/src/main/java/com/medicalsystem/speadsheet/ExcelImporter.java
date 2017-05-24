package com.medicalsystem.speadsheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelImporter {
    public void parseExcelFile(String filePath) {
        try {
            XSSFSheet sheet = transformExcelFile(filePath);
            if (sheet == null) {
                return;
            }
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            rowIterator.next();
            int i = 1;
            while (rowIterator.hasNext() && i < 32) {
                addCelToDB(rowIterator.next());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addCelToDB(Row row) {
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            int columnIndex = cell.getColumnIndex();
            if (columnIndex == 5 || columnIndex == 6) {
                System.out.print(cell.getDateCellValue() + "\t");
            } else {
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                }
            }
        }
    }

    private XSSFSheet transformExcelFile(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\Kamil\\SkyDrive\\Studia Semestr 6\\7 inzynierka\\baza.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        return workbook.getSheetAt(0);
    }
}
