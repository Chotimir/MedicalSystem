package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.Anesthesia;
import com.medicalsystem.service.AnesthesiaService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnesthesiaBuilder {

    private final AnesthesiaService anesthesiaService;

    @Autowired
    public AnesthesiaBuilder(AnesthesiaService anesthesiaService) {
        this.anesthesiaService = anesthesiaService;
    }

    public Anesthesia build(Row row) {
        CellValue anesthesiaCell = new CellValue(row, "anesthesia.number");
        int anesthesiaId = anesthesiaCell.getAsInt();
        return anesthesiaService.getById(anesthesiaId);
    }

}
