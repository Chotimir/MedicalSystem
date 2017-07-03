package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.Disease;
import com.medicalsystem.model.Patient;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientBuilder {

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
        patient.setSex(sex.getAsChar());

        /* Age */
        CellValue age = new CellValue(row, "age.number");
        patient.setAge(age.getAsInt());

        /* Diseases */
        List<Disease> diseases = getDiseases();
        patient.setDiseases(diseases);

        return patient;
    }

    // TODO: problem z List<DiseaseDescription> w Disease
    // TODO: (powinna być jedna wartość DiseaseDescription zamiast listy) ~MS
    private List<Disease> getDiseases() {
        List<Disease> diseases = new ArrayList<>();

        return diseases;
    }

}
