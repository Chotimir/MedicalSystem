package com.medicalsystem.service.impl;

import com.medicalsystem.model.OperationType;
import com.medicalsystem.repository.OperationTypeRepository;
import com.medicalsystem.service.OperationTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationTypeServiceImpl implements OperationTypeService {

    private final OperationTypeRepository operationTypeRepository;

    @Override
    public List<OperationType> listAll() {
        return operationTypeRepository.findAll();
    }

    @Override
    public OperationType getById(Integer id) {
        return operationTypeRepository.findOne(id);
    }

    @Override
    public OperationType saveOrUpdate(OperationType operationType) {
        return operationTypeRepository.save(operationType);
    }

    @Override
    public void delete(Integer id) {
        operationTypeRepository.delete(id);
    }
}
