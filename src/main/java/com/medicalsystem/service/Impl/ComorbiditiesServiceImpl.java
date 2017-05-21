package com.medicalsystem.service.Impl;

import com.medicalsystem.model.Comorbidities;
import com.medicalsystem.repository.ComorbiditiesRepository;
import com.medicalsystem.service.ComorbiditiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kamil Komenda
 */

@Service
public class ComorbiditiesServiceImpl implements ComorbiditiesService {

    @Autowired
    private ComorbiditiesRepository comorbiditiesRepository;

    @Override
    public List<?> listAll() {
        List<Comorbidities> comorbidities = new ArrayList<>();
        comorbiditiesRepository.findAll().forEach(comorbidities::add);
        return comorbidities;
    }

    @Override
    public Comorbidities getById(Integer id) {
        return null;
    }

    @Override
    public Comorbidities saveOrUpdate(Comorbidities comorbidities) {
        return comorbiditiesRepository.save(comorbidities);
    }

    @Override
    public void delete(Integer id) {

    }
}
