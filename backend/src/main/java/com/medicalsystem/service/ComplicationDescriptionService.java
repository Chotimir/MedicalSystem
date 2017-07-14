package com.medicalsystem.service;

import com.medicalsystem.model.Complication;
import com.medicalsystem.model.ComplicationDescription;

public interface ComplicationDescriptionService extends CRUDService<ComplicationDescription> {

    ComplicationDescription getByComplicationAndExcelValue(Complication complication, int excelValue);

}
