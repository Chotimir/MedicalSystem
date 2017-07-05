package com.medicalsystem.service.impl;

import com.medicalsystem.model.ComplicationDescription;
import com.medicalsystem.repository.ComplicationDescriptionRepository;
import com.medicalsystem.service.ComplicationDescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComplicationDescriptionServiceImpl implements ComplicationDescriptionService {

    private final ComplicationDescriptionRepository complicationDescriptionRepository;

    @Override
    public List<ComplicationDescription> listAll() {
        return complicationDescriptionRepository.findAll();
    }

    @Override
    public ComplicationDescription getById(Integer id) {
        return complicationDescriptionRepository.findOne(id);
    }

    @Override
    public ComplicationDescription saveOrUpdate(ComplicationDescription complicationDescription) {
        return complicationDescriptionRepository.save(complicationDescription);
    }

    @Override
    public void delete(Integer id) {
        complicationDescriptionRepository.delete(id);
    }
}
