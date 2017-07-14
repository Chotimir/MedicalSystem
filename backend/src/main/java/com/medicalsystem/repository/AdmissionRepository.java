package com.medicalsystem.repository;

import com.medicalsystem.model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission, Integer> {

    Admission findAdmissionByPatientId(int id);

}
