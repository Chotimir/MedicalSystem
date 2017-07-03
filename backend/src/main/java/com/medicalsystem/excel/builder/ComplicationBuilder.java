package com.medicalsystem.excel.builder;

import com.medicalsystem.model.Complication;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComplicationBuilder {

    // TODO: taki sam problem jak z Disease i DiseaseDescription ~MS
    public List<Complication> build(Row row) {
        List<Complication> complications = new ArrayList<>();

        return complications;
    }

}
