package com.medicalsystem.excel;

import com.medicalsystem.properties.Properties;
import com.medicalsystem.util.DateUtils;
import lombok.extern.java.Log;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Log
public class CellFormatter {

    private final Properties props;
    private final DataFormatter formatter;

    private String value;

    @Autowired
    public CellFormatter(Properties props, DataFormatter formatter) {
        this.props = props;
        this.formatter = formatter;
    }

    /**
     * Sets this.value, acts as a replacement for constructor, so we can use autowiring in this class
     */
    public CellFormatter init(Row row, String columnProperty) {
        int column = props.getAsInt(columnProperty);
        setValue(row, column);
        return this;
    }

    /**
     * Sets this.value, acts as a replacement for constructor, so we can use autowiring in this class
     */
    public CellFormatter init(Row row, int column) {
        setValue(row, column);
        return this;
    }

    private void setValue(Row row, int column) {
        Cell cell = row.getCell(column);
        value = formatter.formatCellValue(cell).trim();
    }

    public String getAsString() {
        return value;
    }

    // TODO: Zmienić na sprawdzanie czy value jest intem zamiast łapania wyjątku
    public int getAsInt() {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            log.info("Error parsing value as integer: " + value);
            return -1;
        }
    }

    // TODO: Zmienić na sprawdzanie czy value jest doublem zamiast łapania wyjątku
    public double getAsDouble() {
        try {
            return Double.parseDouble(value.replaceAll(",", "\\."));
        } catch (NumberFormatException e) {
            log.info("Error parsing value as double: " + value);
            return -1;
        }
    }

    public boolean getAsBoolean() {
        return value.equals("1");
    }

    public Date getAsDate() {
        return DateUtils.fromString(value);
    }

}

