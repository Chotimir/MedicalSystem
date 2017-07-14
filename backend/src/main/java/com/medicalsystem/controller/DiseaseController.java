package com.medicalsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicalsystem.json.SelectField;
import com.medicalsystem.json.SelectFieldBuilder;
import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.model.Patient;
import com.medicalsystem.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DiseaseController {

    private final PatientService patientService;
    private final SelectFieldBuilder builder;
    private final ObjectMapper objectMapper;

    @GetMapping("api/patients/{id}/comorbidities")
    public ResponseEntity<?> getComorbidities(@PathVariable int id) throws JsonProcessingException {
        Patient patient = patientService.getById(id);

        if (patient == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        /* Extract diseases */
        List<DiseaseDescription> diseases = patient.getDiseaseDescriptions();

        /* Map diseases to SelectFields */
        List<SelectField> selectFields = builder.fromDiseases(diseases);

        /* Create json string */
        String json = objectMapper.writeValueAsString(selectFields);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
