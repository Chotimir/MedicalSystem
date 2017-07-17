package com.medicalsystem.service;

import com.medicalsystem.model.ExaminationDescription;

public interface ExaminationDescriptionService extends CRUDService<ExaminationDescription> {

    ExaminationDescription getByName(String name);

}
