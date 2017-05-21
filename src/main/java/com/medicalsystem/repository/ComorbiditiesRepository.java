package com.medicalsystem.repository;

import com.medicalsystem.model.Comorbidities;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kamil Komenda
 */
public interface ComorbiditiesRepository extends JpaRepository<Comorbidities, Long> {
}
