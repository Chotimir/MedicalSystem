package com.medicalsystem.service;

import com.medicalsystem.model.Patient;

public interface PatientService extends CRUDService<Patient> {

    boolean exists(int id);

    boolean exists(Patient patient);

}
