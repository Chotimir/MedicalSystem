package com.medicalsystem.services.Impl;

import com.medicalsystem.domain.Patient;
import com.medicalsystem.repositories.PatientRepository;
import com.medicalsystem.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kamil Komenda
 */

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<?> listAll() {
        List<Patient> products = new ArrayList<>();
        patientRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Patient getById(Integer id) {
        return null;
    }

    @Override
    public Patient saveOrUpdate(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Integer id) {

    }
}
