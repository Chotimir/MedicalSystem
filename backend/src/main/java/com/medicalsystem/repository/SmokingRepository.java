package com.medicalsystem.repository;

import com.medicalsystem.domain.Smoking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmokingRepository extends JpaRepository<Smoking, Integer> {
}
