package com.medicalsystem.service.impl;

import com.medicalsystem.model.Patient;
import com.medicalsystem.repository.PatientRepository;
import com.medicalsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> listAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(Integer id) {
        return patientRepository.findOne(id);
    }

    @Override
    public Patient saveOrUpdate(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Integer id) {
        patientRepository.delete(id);
    }
}
