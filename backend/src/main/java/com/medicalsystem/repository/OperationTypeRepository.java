package com.medicalsystem.repository;

import com.medicalsystem.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Integer> {
}
