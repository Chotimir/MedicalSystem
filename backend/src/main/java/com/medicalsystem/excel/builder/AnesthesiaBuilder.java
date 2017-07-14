package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.Anesthesia;
import com.medicalsystem.service.AnesthesiaService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnesthesiaBuilder {

    private final CellFormatter formatter;

    private final AnesthesiaService anesthesiaService;

    public Anesthesia build(Row row) {
        int anesthesiaId = formatter.init(row, "anesthesia.number").getAsInt();
        return anesthesiaService.getById(anesthesiaId);
    }

}
