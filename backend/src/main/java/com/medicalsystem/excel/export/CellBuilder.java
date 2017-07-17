package com.medicalsystem.excel.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class CellBuilder {

    public void saveStringInRow(Row row, int excelIndex, String data) {
        Cell cell = row.createCell(excelIndex, Cell.CELL_TYPE_STRING);
        if (data == null) {
            cell.setCellValue("");
        } else {
            cell.setCellValue(data);
        }
    }

    public void saveIntInRow(Row row, int excelIndex, int data) {
        if (data == -1) {
            saveStringInRow(row, excelIndex, "x");
        } else {
            Cell cell = row.createCell(excelIndex, Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(data);
        }
    }

    public void saveDateInRow(Row row, int excelIndex, Date data) {
        Cell cell = row.createCell(excelIndex, Cell.CELL_TYPE_STRING);
        cell.setCellValue(data.toString());
    }

    public void saveDoubleInRow(Row row, int excelIndex, double data) {
        if (data == -1) {
            saveStringInRow(row, excelIndex, "x");
        } else {
            Cell cell = row.createCell(excelIndex, Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(data);
        }
    }

    public void saveBooleanInRow(Row row, int excelIndex, boolean data) {
        Cell cell = row.createCell(excelIndex, Cell.CELL_TYPE_NUMERIC);
        int value = (data == true) ? 1 : 0;
        cell.setCellValue(value);
    }
}
