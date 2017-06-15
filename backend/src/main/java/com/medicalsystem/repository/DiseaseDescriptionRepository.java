package com.medicalsystem.repository;

import com.medicalsystem.domain.DiseaseDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseDescriptionRepository extends JpaRepository<DiseaseDescription, Integer> {
}
