package com.medicalsystem.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.sql.Date;

public class CellValue {

    // Autowiring not possible - CellValue is created using 'new' keyword in builders
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

    // TODO: Zmienić na sprawdzanie czy value jest intem zamiast łapania wyjątku
    public int getAsInt() {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing value as integer: " + value);
            return -1;
        }
    }

    // TODO: Zmienić na sprawdzanie czy value jest doublem zamiast łapania wyjątku
    public double getAsDouble() {
        try {
            return Double.parseDouble(value.replaceAll(",", "\\."));
        } catch (NumberFormatException e) {
            System.out.println("Error parsing value as double: " + value);
            return -1;
        }
    }

    public char getAsChar() {
        return value.isEmpty() ? 'x' : value.charAt(0);
    }

    public Date getAsDate() {
        return DateUtils.fromString(value);
    }

    public boolean getAsBoolean() {
        return value.equals("1");
    }

    public String getAsSexString() {
        if (value.startsWith("M"))
            return "M";
        else if (value.startsWith("K"))
            return "K";
        else
            return "-";
    }

}
