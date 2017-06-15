package com.medicalsystem.repository;

import com.medicalsystem.domain.RevisitCause;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisitCauseRepository extends JpaRepository<RevisitCause, Integer> {
}
