package com.medicalsystem.excel;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ExcelColumnsProperties {

    private final String columnsFileName = "excelColumns.properties";
    private final String groupTitlesFileName = "columnGroupTitles.properties";
    private final Properties columnsProperties;
    private final Properties groupTitlesProperties;


    public ExcelColumnsProperties() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        this.columnsProperties = new Properties();
        this.groupTitlesProperties = new Properties();
        try (InputStream input = loader.getResourceAsStream(columnsFileName);
             InputStream input2 = loader.getResourceAsStream(groupTitlesFileName)) {
            this.columnsProperties.load(input);
            this.groupTitlesProperties.load(input2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getColumnProperty(String property) {
        return columnsProperties.getProperty(property);
    }
    public String getGroupTitleProperty(String property) {
        return groupTitlesProperties.getProperty(property);
    }

    public int getColumnPropertyAsInt(String property) {
        return Integer.parseInt(columnsProperties.getProperty(property));
    }

    public int getGroupTitlePropertyAsInt(String property) {
        return Integer.parseInt(groupTitlesProperties.getProperty(property));
    }


    public Set<String> getColumnPropertyNames() {
        return columnsProperties.stringPropertyNames();
    }

    public Set<String> getGroupTitlePropertyNames() {
        return groupTitlesProperties.stringPropertyNames();
    }

    public Map<String, Integer> getColumnProperties() {
        List<String> columnNames = getColumnPropertyNames().stream().collect(Collectors.toList());
        return columnNames.stream().filter(s -> !s.contains(".number")).
                collect(Collectors.toMap(s -> getColumnProperty(s),
                        s -> getColumnPropertyAsInt(s.replace(".name", ".number"))));
    }

    public Map<String, Integer> getgGroupTitleProperties() {
        List<String> columnNames = getGroupTitlePropertyNames().stream().collect(Collectors.toList());
        return columnNames.stream().filter(s -> !s.contains(".number")).
                collect(Collectors.toMap(s -> getGroupTitleProperty(s),
                        s -> getGroupTitlePropertyAsInt(s.replace(".name", ".number"))));
    }

}
