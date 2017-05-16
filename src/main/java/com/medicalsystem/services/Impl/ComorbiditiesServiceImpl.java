package com.medicalsystem.services.Impl;

import com.medicalsystem.domain.Comorbidities;
import com.medicalsystem.repositories.ComorbiditiesRepository;
import com.medicalsystem.services.ComorbiditiesService;
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
