package com.medicalsystem.service.impl;

import com.medicalsystem.domain.OperationMode;
import com.medicalsystem.repository.OperationModeRepository;
import com.medicalsystem.service.OperationModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationModeServiceImpl implements OperationModeService {

    private final OperationModeRepository operationModeRepository;

    @Autowired
    public OperationModeServiceImpl(OperationModeRepository operationModeRepository) {
        this.operationModeRepository = operationModeRepository;
    }

    @Override
    public List<OperationMode> listAll() {
        return operationModeRepository.findAll();
    }

    @Override
    public OperationMode getById(Integer id) {
        return operationModeRepository.findOne(id);
    }

    @Override
    public OperationMode saveOrUpdate(OperationMode operationMode) {
        return operationModeRepository.save(operationMode);
    }

    @Override
    public void delete(Integer id) {
        operationModeRepository.delete(id);
    }
}
