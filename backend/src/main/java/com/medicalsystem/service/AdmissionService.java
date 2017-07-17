package com.medicalsystem.service;

import com.medicalsystem.model.Admission;

public interface AdmissionService extends CRUDService<Admission> {

    Admission getByPatientId(int id);

    long countEntities();
}
