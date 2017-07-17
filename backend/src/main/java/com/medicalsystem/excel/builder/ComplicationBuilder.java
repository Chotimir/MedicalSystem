package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.excel.ExcelColumnsProperties;
import com.medicalsystem.model.Complication;
import com.medicalsystem.service.ComplicationService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComplicationBuilder {
    private ExcelColumnsProperties properties;
    private CellFormatter formatter;
    private ComplicationService complicationService;
    // TODO: taki sam problem jak z Disease i DiseaseDescription ~MS
    public List<Complication> build(Row row) {
        List<Complication> complications = new ArrayList<>();

        for (int i = 3; i <= 30; i++) {
            addComplication(row, complications, "complication." + i + ".number", i);
        }
        addComplication(row, complications, "complication.mins.number", 1);
        addComplication(row, complications, "complication.mi.number", 2);

        return complications;
    }

    private void addComplication(Row row, List<Complication> complications, String prop, int complicationsId) {
        int value = 0;
        try {
            value = formatter.init(row, properties.getColumnPropertyAsInt(prop)).getAsInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (value == 1) {
            complications.add(complicationService.getById(complicationsId));
        }
    }

}
