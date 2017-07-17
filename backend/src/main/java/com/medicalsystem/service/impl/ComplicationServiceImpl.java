package com.medicalsystem.service.impl;

import com.medicalsystem.model.Complication;
import com.medicalsystem.repository.ComplicationRepository;
import com.medicalsystem.service.ComplicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComplicationServiceImpl implements ComplicationService {

    private final ComplicationRepository complicationRepository;

    @Override
    public List<Complication> listAll() {
        return complicationRepository.findAll();
    }

    @Override
    public Complication getById(Integer id) {
        return complicationRepository.findOne(id);
    }

    @Override
    public Complication saveOrUpdate(Complication complication) {
        return complicationRepository.save(complication);
    }

    @Override
    public void delete(Integer id) {
        complicationRepository.delete(id);
    }

}
