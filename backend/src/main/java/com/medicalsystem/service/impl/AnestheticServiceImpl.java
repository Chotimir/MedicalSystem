package com.medicalsystem.service.impl;

import com.medicalsystem.domain.Anesthetic;
import com.medicalsystem.repository.AnestheticRepository;
import com.medicalsystem.service.AnestheticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnestheticServiceImpl implements AnestheticService {

    private final AnestheticRepository anestheticRepository;

    @Autowired
    public AnestheticServiceImpl(AnestheticRepository anestheticRepository) {
        this.anestheticRepository = anestheticRepository;
    }

    @Override
    public List<Anesthetic> listAll() {
        return anestheticRepository.findAll();
    }

    @Override
    public Anesthetic getById(Integer id) {
        return anestheticRepository.findOne(id);
    }

    @Override
    public Anesthetic saveOrUpdate(Anesthetic anesthetic) {
        return anestheticRepository.save(anesthetic);
    }

    @Override
    public void delete(Integer id) {
        anestheticRepository.delete(id);
    }
}
