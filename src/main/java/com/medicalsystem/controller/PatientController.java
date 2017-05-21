package com.medicalsystem.controller;

import com.medicalsystem.model.Patient;
import com.medicalsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kamil Komenda
 */
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<?> getPatients() {
        return patientService.listAll();
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.saveOrUpdate(patient);
    }
}
