package com.medicalsystem.repository;

import com.medicalsystem.domain.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {
}
