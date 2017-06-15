package com.medicalsystem.service.impl;

import com.medicalsystem.domain.Medicament;
import com.medicalsystem.repository.MedicamentRepository;
import com.medicalsystem.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    private final MedicamentRepository medicamentRepository;

    @Autowired
    public MedicamentServiceImpl(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    @Override
    public List<Medicament> listAll() {
        return medicamentRepository.findAll();
    }

    @Override
    public Medicament getById(Integer id) {
        return medicamentRepository.findOne(id);
    }

    @Override
    public Medicament saveOrUpdate(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    @Override
    public void delete(Integer id) {
        medicamentRepository.delete(id);
    }
}
