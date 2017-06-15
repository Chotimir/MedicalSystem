package com.medicalsystem.repository;

import com.medicalsystem.domain.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission, Integer> {
}
