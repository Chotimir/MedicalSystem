package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.Anesthetic;
import com.medicalsystem.service.AnestheticService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnestheticBuilder {

    private final CellFormatter formatter;

    private final AnestheticService anestheticService;

    public Anesthetic build(Row row) {
        int anestheticId = formatter.init(row, "anesthetic.number").getAsInt();
        return anestheticService.getById(anestheticId);
    }

}
