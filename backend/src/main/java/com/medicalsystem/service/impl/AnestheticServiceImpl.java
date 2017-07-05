package com.medicalsystem.service.impl;

import com.medicalsystem.model.Anesthetic;
import com.medicalsystem.repository.AnestheticRepository;
import com.medicalsystem.service.AnestheticService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnestheticServiceImpl implements AnestheticService {

    private final AnestheticRepository anestheticRepository;

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
