package com.medicalsystem.repository;

import com.medicalsystem.domain.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {
}
