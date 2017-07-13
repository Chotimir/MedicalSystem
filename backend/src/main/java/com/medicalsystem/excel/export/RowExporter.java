package com.medicalsystem.excel.export;


import com.medicalsystem.excel.ExcelColumnsProperties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RowExporter {

    private static ExcelColumnsProperties columnNames = new ExcelColumnsProperties();

    public static void setColumnNames(XSSFSheet sheet) {
        createCells(sheet.createRow(0), columnNames.getgGroupTitleProperties());
        createCells(sheet.createRow(2), columnNames.getColumnProperties());
    }

    private static void createCells(Row row, Map<String, Integer> columnNames) {
        for (Map.Entry<String, Integer> entry : columnNames.entrySet()) {
            Cell cell = row.createCell(entry.getValue(), Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(entry.getKey());
        }
    }
}
