package com.medicalsystem.service;

import com.medicalsystem.model.Operation;

public interface OperationService extends CRUDService<Operation> {
    boolean exists(int id);
}
