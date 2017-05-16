package com.medicalsystem.repositories;

import com.medicalsystem.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kamil Komenda
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
