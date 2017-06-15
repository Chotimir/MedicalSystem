package com.medicalsystem.repository;

import com.medicalsystem.domain.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {
}
