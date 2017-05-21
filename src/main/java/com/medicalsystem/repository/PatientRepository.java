package com.medicalsystem.repository;

import com.medicalsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kamil Komenda
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
