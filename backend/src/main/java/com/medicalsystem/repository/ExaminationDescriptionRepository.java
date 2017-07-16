package com.medicalsystem.repository;

import com.medicalsystem.model.ExaminationDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationDescriptionRepository extends JpaRepository<ExaminationDescription, Integer> {

    ExaminationDescription findByName(String name);

}
