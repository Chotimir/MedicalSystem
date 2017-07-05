package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.Disease;
import com.medicalsystem.model.Patient;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientBuilder {

    private final DiseaseBuilder diseaseBuilder;

    public Patient build(Row row) {
        Patient patient = new Patient();

        /* ID */
        CellValue id = new CellValue(row, "id.number");
        patient.setId(id.getAsInt());

        /* Last name */
        CellValue lastName = new CellValue(row, "lastName.number");
        patient.setLastName(lastName.getAsString());

        /* First name */
        CellValue firstName = new CellValue(row, "firstName.number");
        patient.setFirstName(firstName.getAsString());

        /* Sex */
        CellValue sex = new CellValue(row, "sex.number");
        patient.setSex(sex.getAsSexString());

        /* Age */
        CellValue age = new CellValue(row, "age.number");
        patient.setAge(age.getAsInt());

        /* Diseases */
        List<Disease> diseases = diseaseBuilder.build(row);
        patient.setDiseases(diseases);

        return patient;
    }

}
