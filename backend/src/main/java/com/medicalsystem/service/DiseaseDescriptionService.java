package com.medicalsystem.service;

import com.medicalsystem.model.Disease;
import com.medicalsystem.model.DiseaseDescription;

public interface DiseaseDescriptionService extends CRUDService<DiseaseDescription> {

    DiseaseDescription getByDiseaseAndExcelValue(Disease disease, Integer excelValue);

}
