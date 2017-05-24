package com.medicalsystem.repository;

import com.medicalsystem.model.Complication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplicationRepository extends JpaRepository<Complication, Integer> {
}
