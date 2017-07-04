package com.medicalsystem.service.impl;

import com.medicalsystem.model.ExaminationDescription;
import com.medicalsystem.repository.ExaminationDescriptionRepository;
import com.medicalsystem.service.ExaminationDescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExaminationDescriptionServiceImpl implements ExaminationDescriptionService {

    private final ExaminationDescriptionRepository examinationDescriptionRepository;

    @Override
    public List<ExaminationDescription> listAll() {
        return examinationDescriptionRepository.findAll();
    }

    @Override
    public ExaminationDescription getById(Integer id) {
        return examinationDescriptionRepository.findOne(id);
    }

    @Override
    public ExaminationDescription saveOrUpdate(ExaminationDescription examinationDescription) {
        return examinationDescriptionRepository.save(examinationDescription);
    }

    @Override
    public void delete(Integer id) {
        examinationDescriptionRepository.delete(id);
    }
}
