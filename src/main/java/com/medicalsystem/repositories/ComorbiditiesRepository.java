package com.medicalsystem.repositories;

import com.medicalsystem.domain.Comorbidities;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kamil Komenda
 */
public interface ComorbiditiesRepository extends JpaRepository<Comorbidities, Long> {
}
