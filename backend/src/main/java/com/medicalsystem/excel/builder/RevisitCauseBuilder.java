package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.RevisitCause;
import com.medicalsystem.service.RevisitCauseService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RevisitCauseBuilder {

    private final RevisitCauseService revisitCauseService;

    @Autowired
    public RevisitCauseBuilder(RevisitCauseService revisitCauseService) {
        this.revisitCauseService = revisitCauseService;
    }

    public RevisitCause build(Row row) {
        CellValue revisitCauseCell = new CellValue(row, "revisit.cause.number");
        int revisitCauseId = revisitCauseCell.getAsInt();
        return revisitCauseService.getById(revisitCauseId);
    }

}
