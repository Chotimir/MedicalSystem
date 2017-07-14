package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.RevisitCause;
import com.medicalsystem.service.RevisitCauseService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RevisitCauseBuilder {

    private final CellFormatter formatter;

    private final RevisitCauseService revisitCauseService;

    public RevisitCause build(Row row) {
        int revisitCauseId = formatter.init(row, "revisit.cause.number").getAsInt();
        return revisitCauseService.getById(revisitCauseId);
    }

}
