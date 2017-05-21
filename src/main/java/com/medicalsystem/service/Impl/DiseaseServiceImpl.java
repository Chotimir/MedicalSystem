package com.medicalsystem.service.Impl;

import com.medicalsystem.model.Disease;
import com.medicalsystem.repository.DiseaseRepository;
import com.medicalsystem.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kamil Komenda
 */

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public List<?> listAll() {
        List<Disease> comorbidities = new ArrayList<>();
        diseaseRepository.findAll().forEach(comorbidities::add);
        return comorbidities;
    }

    @Override
    public Disease getById(Integer id) {
        return null;
    }

    @Override
    public Disease saveOrUpdate(Disease disease) {
        return diseaseRepository.save(disease);
    }

    @Override
    public void delete(Integer id) {

    }
}
