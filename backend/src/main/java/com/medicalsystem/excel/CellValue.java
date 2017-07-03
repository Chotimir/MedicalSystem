package com.medicalsystem.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.sql.Date;

public class CellValue {

    private static ExcelColumnsProperties columnsProperties = new ExcelColumnsProperties();
    private static DataFormatter formatter = new DataFormatter();

    private String value;

    public CellValue(Row row, String columnProperty) {
        int cellIndex = columnsProperties.getPropertyAsInt(columnProperty);
        Cell cell = row.getCell(cellIndex);
        this.value = formatter.formatCellValue(cell).trim();
    }

    public CellValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        this.value = formatter.formatCellValue(cell).trim();
    }

    public String getAsString() {
        return value;
    }

    public int getAsInt() {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing value as integer: " + value);
            return -1;
        }
    }

    public char getAsChar() {
        return value.isEmpty() ? 'x' : value.charAt(0);
    }

    public Date getAsDate() {
        return DateUtils.fromString(value);
    }

    public double getAsDouble() {
        try {
            return Double.parseDouble(value.replaceAll(",", "\\."));
        } catch (NumberFormatException e) {
            System.out.println("Error parsing value as double: " + value);
            return -1;
        }
    }

    public boolean getAsBoolean() {
        return value.equals("1");
    }

}
