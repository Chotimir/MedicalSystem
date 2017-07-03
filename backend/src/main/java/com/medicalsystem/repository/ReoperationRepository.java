package com.medicalsystem.repository;

import com.medicalsystem.model.Reoperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReoperationRepository extends JpaRepository<Reoperation, Integer> {
}
