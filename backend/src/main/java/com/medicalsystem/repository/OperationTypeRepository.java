package com.medicalsystem.repository;

import com.medicalsystem.domain.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Integer> {
}
