package com.medicalsystem.controller;

import com.medicalsystem.model.Patient;
import com.medicalsystem.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {

    private final PatientService patientService;

    @PostMapping("api/patient/{id}")
    public ResponseEntity createPatient(@PathVariable int id) {

        /* Check if there's a patient with the given id */
        if (patientService.exists(id)) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Patient with given id already exists: " + id);
        }

        /* Create new patient with given id */
        Patient patient = new Patient();
        patient.setId(id);

        /* Persist patient */
        patientService.saveOrUpdate(patient);

        System.out.println("Created patient with id: " + id);

        /* Return response */
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("api/patient/{id}")
    @ResponseBody
    public boolean patientExists(@PathVariable int id) {
        return patientService.exists(id);
    }

}
