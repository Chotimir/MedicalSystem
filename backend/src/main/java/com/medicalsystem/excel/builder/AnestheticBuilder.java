package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.Anesthetic;
import com.medicalsystem.service.AnestheticService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnestheticBuilder {

    private final AnestheticService anestheticService;

    @Autowired
    public AnestheticBuilder(AnestheticService anestheticService) {
        this.anestheticService = anestheticService;
    }

    public Anesthetic build(Row row) {
        CellValue anestheticCell = new CellValue(row, "anesthetic.number");
        int anestheticId = anestheticCell.getAsInt();
        return anestheticService.getById(anestheticId);
    }

}
