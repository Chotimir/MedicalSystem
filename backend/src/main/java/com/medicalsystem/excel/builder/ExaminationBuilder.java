package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.excel.ExcelColumnsProperties;
import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Examination;
import com.medicalsystem.model.ExaminationDescription;
import com.medicalsystem.service.ExaminationDescriptionService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExaminationBuilder {

    private final ExcelColumnsProperties columnsProperties;
    private final ExaminationDescriptionService examinationDescriptionService;

    public List<Examination> build(Row row, Admission admission) {
        List<Examination> examinations = new ArrayList<>();

        /* Get index of the column of the first examination */
        int firstExamIndex = columnsProperties.getPropertyAsInt("examination.pchn.number");

        /* Get index of the column of the last examination */
        int lastExamIndex = columnsProperties.getPropertyAsInt("examination.fibrinogen.number");

        /* Iterate over examinations - assumes that examination description ids are in proper order */
        int descriptionId = 1;

        for (int i = firstExamIndex; i <= lastExamIndex; i++) {

            /* Get examination result */
            CellValue resultCell = new CellValue(row, i);
            double result = resultCell.getAsDouble();

            /* Get corresponding examination description */
            ExaminationDescription description = examinationDescriptionService.getById(descriptionId++);

            /* Build examination object */
            Examination examination = new Examination();

            examination.setAdmission(admission);
            examination.setDescription(description);
            examination.setResult(result);

            examinations.add(examination);
        }

        return examinations;
    }

}
