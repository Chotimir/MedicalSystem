package com.medicalsystem.repository;

import com.medicalsystem.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {
}
