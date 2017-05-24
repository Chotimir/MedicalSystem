package com.medicalsystem.service.impl;

import com.medicalsystem.model.Revisit;
import com.medicalsystem.repository.RevisitRepository;
import com.medicalsystem.service.RevisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevisitServiceImpl implements RevisitService {

    private final RevisitRepository revisitRepository;

    @Autowired
    public RevisitServiceImpl(RevisitRepository revisitRepository) {
        this.revisitRepository = revisitRepository;
    }

    @Override
    public List<Revisit> listAll() {
        return revisitRepository.findAll();
    }

    @Override
    public Revisit getById(Integer id) {
        return revisitRepository.findOne(id);
    }

    @Override
    public Revisit saveOrUpdate(Revisit revisit) {
        return revisitRepository.save(revisit);
    }

    @Override
    public void delete(Integer id) {
        revisitRepository.delete(id);
    }
}
