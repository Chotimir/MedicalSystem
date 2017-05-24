package com.medicalsystem.service.impl;

import com.medicalsystem.model.Examination;
import com.medicalsystem.repository.ExaminationRepository;
import com.medicalsystem.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExaminationServiceImpl implements ExaminationService {

    private final ExaminationRepository examinationRepository;

    @Autowired
    public ExaminationServiceImpl(ExaminationRepository examinationRepository) {
        this.examinationRepository = examinationRepository;
    }

    @Override
    public List<Examination> listAll() {
        return examinationRepository.findAll();
    }

    @Override
    public Examination getById(Integer id) {
        return examinationRepository.findOne(id);
    }

    @Override
    public Examination saveOrUpdate(Examination examination) {
        return examinationRepository.save(examination);
    }

    @Override
    public void delete(Integer id) {
        examinationRepository.delete(id);
    }
}
