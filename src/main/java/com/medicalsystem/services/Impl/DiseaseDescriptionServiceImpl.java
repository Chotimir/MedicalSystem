package com.medicalsystem.services.Impl;

import com.medicalsystem.domain.DiseaseDescription;
import com.medicalsystem.repositories.DiseaseDescriptionRepository;
import com.medicalsystem.services.DiseaseDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kamil Komenda
 */

@Service
public class DiseaseDescriptionServiceImpl implements DiseaseDescriptionService {

    @Autowired
    private DiseaseDescriptionRepository diseaseDescriptionRepository;

    @Override
    public List<?> listAll() {
        List<DiseaseDescription> comorbidities = new ArrayList<>();
        diseaseDescriptionRepository.findAll().forEach(comorbidities::add);
        return comorbidities;
    }

    @Override
    public DiseaseDescription getById(Integer id) {
        return null;
    }

    @Override
    public DiseaseDescription saveOrUpdate(DiseaseDescription diseaseDescription) {
        return diseaseDescriptionRepository.save(diseaseDescription);
    }

    @Override
    public void delete(Integer id) {

    }
}