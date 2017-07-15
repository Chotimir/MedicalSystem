package com.medicalsystem.excel.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;


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
        Cell cell = row.createCell(excelIndex, Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(data);
    }

}
