package com.medicalsystem.repository;

import com.medicalsystem.domain.ExaminationDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationDescriptionRepository extends JpaRepository<ExaminationDescription, Integer> {
}
