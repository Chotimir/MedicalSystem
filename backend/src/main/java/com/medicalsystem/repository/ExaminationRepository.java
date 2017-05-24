package com.medicalsystem.repository;

import com.medicalsystem.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {
}
