package com.medicalsystem.newexcel;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class ExcelColumnsProperties {

    private final String fileName = "excelColumns.properties";
    private final Properties properties;

    public ExcelColumnsProperties() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        this.properties = new Properties();
        try (InputStream input = loader.getResourceAsStream(fileName)) {
            this.properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }

    public int getPropertyAsInt(String property) {
        return Integer.parseInt(properties.getProperty(property));
    }

}
