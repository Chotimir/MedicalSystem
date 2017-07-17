package com.medicalsystem.service;

import com.medicalsystem.model.Disease;

public interface DiseaseService extends CRUDService<Disease> {

    Disease getByName(String name);

}
