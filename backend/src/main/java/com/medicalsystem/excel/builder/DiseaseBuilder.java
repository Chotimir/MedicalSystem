package com.medicalsystem.excel.builder;

import com.medicalsystem.model.Disease;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiseaseBuilder {

    // TODO: problem z List<DiseaseDescription> w Disease
    // TODO: (powinna być jedna wartość DiseaseDescription zamiast listy) ~MS
    public List<Disease> build(Row row) {
        List<Disease> diseases = new ArrayList<>();

        return diseases;
    }

}
