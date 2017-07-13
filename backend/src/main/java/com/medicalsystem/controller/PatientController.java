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
     * Returns true if an entity with the given id exists in the database, false otherwise.
     *
     * @param  id id of the entity
     */
    @GetMapping("api/patients/{id}")
    public boolean patientExists(@PathVariable int id) {
        return patientService.exists(id);
    }

    /**
     * Creates an empty Patient entity, setting only its id.
     *
     * @param  id id of the entity
     * @return    200 OK          - if method successful
     *            400 Bad Request - if patient with the given id already exists in the database
     */
    @PostMapping("api/patients/{id}")
    public ResponseEntity<?> createPatient(@PathVariable int id) {

        /* Check if there's a patient with the given id */
        if (patientService.exists(id))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        /* Create new patient with given id */
        Patient patient = new Patient();
        patient.setId(id);

        /* Persist patient */
        patient = patientService.saveOrUpdate(patient);

        if (patient == null)
            return new ResponseEntity<>("Error saving patient", HttpStatus.INTERNAL_SERVER_ERROR);

        /* Return response */
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

}
