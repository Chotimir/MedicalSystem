package com.medicalsystem.controller;

import com.medicalsystem.model.Patient;
import com.medicalsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("api/patient")
    public ResponseEntity<Patient> createPatient(@RequestBody String id) {
        System.out.println("dupa");
        System.out.println(id);
        /* Create new patient object */
        Patient patient = new Patient();
        patient.setId(Integer.parseInt(id));

        /* Persist created patient object */
        patientService.saveOrUpdate(patient);

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

}
