package com.medicalsystem.service.impl;

import com.medicalsystem.model.Patient;
import com.medicalsystem.service.PatientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void savePatientTest() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setFirstName("Kamil");
        patient.setLastName("Komenda");
        patient.setSex('M');
        patient.setAge(24);

        patientService.saveOrUpdate(patient);

        Patient p = patientService.getById(1);

        Assert.assertNotNull(p);
    }
}
