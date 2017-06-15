package com.medicalsystem.service.impl;

import com.medicalsystem.domain.Troponin;
import com.medicalsystem.repository.TroponinRepository;
import com.medicalsystem.service.TroponinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TroponinServiceImpl implements TroponinService {

    private final TroponinRepository troponinRepository;

    @Autowired
    public TroponinServiceImpl(TroponinRepository troponinRepository) {
        this.troponinRepository = troponinRepository;
    }

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
