package com.medicalsystem.service.impl;

import com.medicalsystem.domain.RevisitCause;
import com.medicalsystem.repository.RevisitCauseRepository;
import com.medicalsystem.service.RevisitCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevisitCauseServiceImpl implements RevisitCauseService {

    private final RevisitCauseRepository revisitCauseRepository;

    @Autowired
    public RevisitCauseServiceImpl(RevisitCauseRepository revisitCauseRepository) {
        this.revisitCauseRepository = revisitCauseRepository;
    }

    @Override
    public List<RevisitCause> listAll() {
        return revisitCauseRepository.findAll();
    }

    @Override
    public RevisitCause getById(Integer id) {
        return revisitCauseRepository.findOne(id);
    }

    @Override
    public RevisitCause saveOrUpdate(RevisitCause revisitCause) {
        return revisitCauseRepository.save(revisitCause);
    }

    @Override
    public void delete(Integer id) {
        revisitCauseRepository.delete(id);
    }
}
