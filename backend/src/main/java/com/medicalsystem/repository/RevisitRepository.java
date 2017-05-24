package com.medicalsystem.repository;

import com.medicalsystem.model.Revisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisitRepository extends JpaRepository<Revisit, Integer> {
}
