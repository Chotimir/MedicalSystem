package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.Smoking;
import com.medicalsystem.service.SmokingService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SmokingBuilder {

    private final SmokingService smokingService;

    public Smoking build(Row row) {
        CellValue smokingId = new CellValue(row, "smoking.number");
        return smokingService.getById(smokingId.getAsInt());
    }

}
