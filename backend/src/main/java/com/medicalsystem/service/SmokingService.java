package com.medicalsystem.service;

import com.medicalsystem.model.Smoking;

public interface SmokingService extends CRUDService<Smoking> {
    int getSmokingIdByText(String text);
}
