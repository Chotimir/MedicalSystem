package com.medicalsystem.service.impl;

import com.medicalsystem.model.Admission;
import com.medicalsystem.repository.AdmissionRepository;
import com.medicalsystem.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    private final AdmissionRepository admissionRepository;

    @Autowired
    public AdmissionServiceImpl(AdmissionRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    @Override
    public List<Admission> listAll() {
        return admissionRepository.findAll();
    }

    @Override
    public Admission getById(Integer id) {
        return admissionRepository.findOne(id);
    }

    @Override
    public Admission saveOrUpdate(Admission admission) {
        return admissionRepository.save(admission);
    }

    @Override
    public void delete(Integer id) {
        admissionRepository.delete(id);
    }
}
