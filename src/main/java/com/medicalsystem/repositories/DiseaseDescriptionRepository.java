package com.medicalsystem.repositories;

import com.medicalsystem.domain.DiseaseDescription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kamil Komenda
 */
public interface DiseaseDescriptionRepository extends JpaRepository<DiseaseDescription, Long> {
}
