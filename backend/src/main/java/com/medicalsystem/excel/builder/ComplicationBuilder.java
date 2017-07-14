package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.Complication;
import com.medicalsystem.model.ComplicationDescription;
import com.medicalsystem.properties.ComplicationProperties;
import com.medicalsystem.properties.ComplicationProperties.ComplicationPair;
import com.medicalsystem.service.ComplicationDescriptionService;
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

    private final CellFormatter formatter;
    private final ComplicationProperties complicationProps;

    private final ComplicationService complicationService;
    private final ComplicationDescriptionService complicationDescriptionService;

    public List<ComplicationDescription> build(Row row) {
        List<ComplicationDescription> complications = new ArrayList<>();

        int complicationId = 1;

        for (ComplicationPair pair : complicationProps.getComplications()) {
            String name = pair.getName();
            int column = Integer.parseInt(pair.getNumber());

            int excelValue = formatter.init(row, column).getAsInt();

            Complication complication = complicationService.getById(complicationId++);
            ComplicationDescription cd = complicationDescriptionService.getByComplicationAndExcelValue(complication, excelValue);

            if (cd != null)
                complications.add(cd);
        }

        return complications;
    }

}
