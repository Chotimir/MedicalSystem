package com.medicalsystem.service.impl;

import com.medicalsystem.model.Admission;
import com.medicalsystem.repository.AdmissionRepository;
import com.medicalsystem.service.AdmissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdmissionServiceImpl implements AdmissionService {

    private final AdmissionRepository admissionRepository;

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

    @Override
    public Admission getByPatientId(int id) {
        return admissionRepository.findAdmissionByPatientId(id);
    }
}
