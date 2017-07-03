package com.medicalsystem.service.impl;

import com.medicalsystem.model.Anesthesia;
import com.medicalsystem.repository.AnesthesiaRepository;
import com.medicalsystem.service.AnesthesiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnesthesiaServiceImpl implements AnesthesiaService {

    private final AnesthesiaRepository anesthesiaRepository;

    @Autowired
    public AnesthesiaServiceImpl(AnesthesiaRepository anesthesiaRepository) {
        this.anesthesiaRepository = anesthesiaRepository;
    }

    @Override
    public List<Anesthesia> listAll() {
        return anesthesiaRepository.findAll();
    }

    @Override
    public Anesthesia getById(Integer id) {
        return anesthesiaRepository.findOne(id);
    }

    @Override
    public Anesthesia saveOrUpdate(Anesthesia anesthesia) {
        return anesthesiaRepository.save(anesthesia);
    }

    @Override
    public void delete(Integer id) {
        anesthesiaRepository.delete(id);
    }
}
