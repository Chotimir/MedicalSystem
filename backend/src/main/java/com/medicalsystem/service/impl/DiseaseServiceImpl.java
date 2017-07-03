package com.medicalsystem.service.impl;

import com.medicalsystem.model.Disease;
import com.medicalsystem.repository.DiseaseRepository;
import com.medicalsystem.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public List<Disease> listAll() {
        return diseaseRepository.findAll();
    }

    @Override
    public Disease getById(Integer id) {
        return diseaseRepository.findOne(id);
    }

    @Override
    public Disease saveOrUpdate(Disease disease) {
        return diseaseRepository.save(disease);
    }

    @Override
    public void delete(Integer id) {
        diseaseRepository.delete(id);
    }
}
