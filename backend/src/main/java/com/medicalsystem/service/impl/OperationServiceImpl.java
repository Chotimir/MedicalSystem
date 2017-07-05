package com.medicalsystem.service.impl;

import com.medicalsystem.model.Operation;
import com.medicalsystem.repository.OperationRepository;
import com.medicalsystem.service.OperationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    @Override
    public List<Operation> listAll() {
        return operationRepository.findAll();
    }

    @Override
    public Operation getById(Integer id) {
        return operationRepository.findOne(id);
    }

    @Override
    public Operation saveOrUpdate(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public void delete(Integer id) {
        operationRepository.delete(id);
    }
}
