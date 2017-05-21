package com.medicalsystem.repository;

import com.medicalsystem.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kamil Komenda
 */
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
