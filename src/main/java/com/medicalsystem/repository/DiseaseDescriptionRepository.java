package com.medicalsystem.repository;

import com.medicalsystem.model.DiseaseDescription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kamil Komenda
 */
public interface DiseaseDescriptionRepository extends JpaRepository<DiseaseDescription, Long> {
}
