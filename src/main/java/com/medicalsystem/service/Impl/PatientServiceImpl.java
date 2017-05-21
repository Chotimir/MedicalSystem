package com.medicalsystem.service.Impl;

import com.medicalsystem.model.Patient;
import com.medicalsystem.repository.PatientRepository;
import com.medicalsystem.service.PatientService;
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
