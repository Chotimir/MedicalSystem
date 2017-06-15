package com.medicalsystem.repository;

import com.medicalsystem.domain.Reoperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReoperationRepository extends JpaRepository<Reoperation, Integer> {
}
