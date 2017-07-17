package com.medicalsystem.repository;

import com.medicalsystem.model.Smoking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmokingRepository extends JpaRepository<Smoking, Integer> {
    Smoking findByText(String text);

}
