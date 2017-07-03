package com.medicalsystem.repository;

import com.medicalsystem.model.Patient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void savePatientTest() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setFirstName("Mikołaj");
        patient.setLastName("Sieniawski");
        patient.setSex('M');
        patient.setAge(22);

        patientRepository.save(patient);

        Patient p = patientRepository.findOne(1);

        Assert.assertNotNull(p);
    }
}
