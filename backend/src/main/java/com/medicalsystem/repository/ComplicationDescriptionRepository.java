package com.medicalsystem.repository;

import com.medicalsystem.model.ComplicationDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplicationDescriptionRepository extends JpaRepository<ComplicationDescription, Integer> {
}
