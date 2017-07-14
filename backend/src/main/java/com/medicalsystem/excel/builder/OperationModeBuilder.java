package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.OperationMode;
import com.medicalsystem.service.OperationModeService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationModeBuilder {

    private final CellFormatter formatter;

    private final OperationModeService operationModeService;

    public OperationMode build(Row row) {
        int operationModeId = formatter.init(row, "operationMode.number").getAsInt();
        return operationModeService.getById(operationModeId);
    }

}
