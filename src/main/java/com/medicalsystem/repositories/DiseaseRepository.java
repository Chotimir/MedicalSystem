package com.medicalsystem.repositories;

import com.medicalsystem.domain.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kamil Komenda
 */
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
