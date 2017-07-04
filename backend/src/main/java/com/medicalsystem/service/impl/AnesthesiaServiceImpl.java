package com.medicalsystem.service.impl;

import com.medicalsystem.model.Anesthesia;
import com.medicalsystem.repository.AnesthesiaRepository;
import com.medicalsystem.service.AnesthesiaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnesthesiaServiceImpl implements AnesthesiaService {

    private final AnesthesiaRepository anesthesiaRepository;

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
