package com.medicalsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.model.Patient;
import com.medicalsystem.json.serializer.SelectField;
import com.medicalsystem.json.serializer.SelectFieldBuilder;
import com.medicalsystem.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComorbidityController {

    private final PatientService patientService;
    private final SelectFieldBuilder selectFieldBuilder;

    // TODO: do przepisania
    @GetMapping("api/patients/{id}/comorbidities")
    @ResponseBody
    public String getComorbidities(@PathVariable int id) throws JsonProcessingException {
        Patient patient = patientService.getById(id);

        if (patient == null)
            return "NOT FOUND";

        List<DiseaseDescription> diseases = patient.getDiseaseDescriptions();
        List<SelectField> selectFields = selectFieldBuilder.build(diseases);

        return new ObjectMapper().writeValueAsString(selectFields);
    }

}
