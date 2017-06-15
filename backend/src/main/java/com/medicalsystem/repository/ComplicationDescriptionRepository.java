package com.medicalsystem.repository;

import com.medicalsystem.domain.ComplicationDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplicationDescriptionRepository extends JpaRepository<ComplicationDescription, Integer> {
}
