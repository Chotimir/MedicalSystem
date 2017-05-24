package com.medicalsystem.service.impl;

import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.repository.DiseaseDescriptionRepository;
import com.medicalsystem.service.DiseaseDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseDescriptionServiceImpl implements DiseaseDescriptionService {

    private final DiseaseDescriptionRepository diseaseDescriptionRepository;

    @Autowired
    public DiseaseDescriptionServiceImpl(DiseaseDescriptionRepository diseaseDescriptionRepository) {
        this.diseaseDescriptionRepository = diseaseDescriptionRepository;
    }

    @Override
    public List<DiseaseDescription> listAll() {
        return diseaseDescriptionRepository.findAll();
    }

    @Override
    public DiseaseDescription getById(Integer id) {
        return diseaseDescriptionRepository.findOne(id);
    }

    @Override
    public DiseaseDescription saveOrUpdate(DiseaseDescription diseaseDescription) {
        return diseaseDescriptionRepository.save(diseaseDescription);
    }

    @Override
    public void delete(Integer id) {
        diseaseDescriptionRepository.delete(id);
    }
}
