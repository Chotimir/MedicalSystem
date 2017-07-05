package com.medicalsystem.service.impl;

import com.medicalsystem.model.Medicament;
import com.medicalsystem.repository.MedicamentRepository;
import com.medicalsystem.service.MedicamentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MedicamentServiceImpl implements MedicamentService {

    private final MedicamentRepository medicamentRepository;

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
