package com.medicalsystem.repository;

import com.medicalsystem.model.Troponin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TroponinRepository extends JpaRepository<Troponin, Integer> {

    @Query("SELECT t FROM Troponin t WHERE t.admission.id = (SELECT a.id FROM Admission a WHERE a.patient.id = :id)")
    Troponin findByPatientId(@Param("id") int id);

}
