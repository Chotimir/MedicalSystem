package com.medicalsystem.service;

import com.medicalsystem.model.Troponin;

public interface TroponinService extends CRUDService<Troponin> {

    Troponin getByPatientId(int id);

}
