package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.model.Patient;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientBuilder {

    private final CellFormatter formatter;

    private final DiseaseBuilder diseaseBuilder;

    public Patient build(Row row) {
        Patient patient = new Patient();

        /* ID */
        int id = formatter.init(row, "id.number").getAsInt();
        patient.setId(id);

        /* Last name */
        String lastName = formatter.init(row, "lastName.number").getAsString();
        patient.setLastName(lastName);

        /* First name */
        String firstName = formatter.init(row, "firstName.number").getAsString();
        patient.setFirstName(firstName);

        /* Sex */
        String sex = formatter.init(row, "sex.number").getAsString();
        sex = validateSexValue(sex);
        patient.setSex(sex);

        /* Age */
        int age = formatter.init(row, "age.number").getAsInt();
        patient.setAge(age);

        /* Diseases */
        List<DiseaseDescription> diseaseDescriptions = diseaseBuilder.build(row);
        patient.setDiseaseDescriptions(diseaseDescriptions);

        return patient;
    }

    private String validateSexValue(String sex) {
        if (sex.startsWith("M"))
            return "M";
        else if (sex.startsWith("K"))
            return "K";
        else
            return "-";
    }

}
