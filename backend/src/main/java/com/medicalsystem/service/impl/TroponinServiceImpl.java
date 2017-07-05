package com.medicalsystem.service.impl;

import com.medicalsystem.model.Troponin;
import com.medicalsystem.repository.TroponinRepository;
import com.medicalsystem.service.TroponinService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TroponinServiceImpl implements TroponinService {

    private final TroponinRepository troponinRepository;

    @Override
    public List<Troponin> listAll() {
        return troponinRepository.findAll();
    }

    @Override
    public Troponin getById(Integer id) {
        return troponinRepository.findOne(id);
    }

    @Override
    public Troponin saveOrUpdate(Troponin troponin) {
        return troponinRepository.save(troponin);
    }

    @Override
    public void delete(Integer id) {
        troponinRepository.delete(id);
    }
}
