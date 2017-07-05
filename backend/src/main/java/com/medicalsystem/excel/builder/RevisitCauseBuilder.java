package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.RevisitCause;
import com.medicalsystem.service.RevisitCauseService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RevisitCauseBuilder {

    private final RevisitCauseService revisitCauseService;

    public RevisitCause build(Row row) {
        CellValue revisitCauseCell = new CellValue(row, "revisit.cause.number");
        int revisitCauseId = revisitCauseCell.getAsInt();
        return revisitCauseService.getById(revisitCauseId);
    }

}
