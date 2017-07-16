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

    /**
     * Checks if entity exists.
     * @param  id id of the entity
     * @return    true if exists, false otherwise
     */
    @GetMapping("api/patients/{id}")
    public boolean patientExists(@PathVariable int id) {
        return patientService.exists(id);
    }

    /**
     * Creates an empty Patient entity, setting only its id.
     * @param  id id of the entity
     * @return    true if success, false otherwise
     */
    @PostMapping("api/patients/{id}")
    public boolean createPatient(@PathVariable int id) {

        /* Check if there's a patient with the given id */
        if (patientService.exists(id))
            return false;

        /* Create new patient with given id */
        Patient patient = new Patient();
        patient.setId(id);

        /* Persist patient */
        patient = patientService.saveOrUpdate(patient);

        if (patient == null)
            return false;

        /* Return response */
        return true;
    }

    @GetMapping("api/patients/{id}/personalData")
    public ResponseEntity<Patient> getPatient(@PathVariable int id) {
        Patient patient = patientService.getById(id);

        if (patient == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PutMapping("api/patients/{id}/personalData")
    public ResponseEntity<?> updatePatient(@PathVariable int id, @RequestBody Patient patient) {

        patient.setId(id);

        patient = patientService.saveOrUpdate(patient);

        if (patient == null)
            return new ResponseEntity<>("Error saving patient: " + id, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

}
