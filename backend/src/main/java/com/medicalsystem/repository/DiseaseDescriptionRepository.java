package com.medicalsystem.repository;

import com.medicalsystem.model.Disease;
import com.medicalsystem.model.DiseaseDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseDescriptionRepository extends JpaRepository<DiseaseDescription, Integer> {

    DiseaseDescription findByDiseaseAndExcelValue(Disease disease, int excelValue);

}
