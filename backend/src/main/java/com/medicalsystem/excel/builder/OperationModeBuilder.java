package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.OperationMode;
import com.medicalsystem.service.OperationModeService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationModeBuilder {

    private final OperationModeService operationModeService;

    @Autowired
    public OperationModeBuilder(OperationModeService operationModeService) {
        this.operationModeService = operationModeService;
    }

    public OperationMode build(Row row) {
        CellValue operationModeCell = new CellValue(row, "operationMode.number");
        int operationModeId = operationModeCell.getAsInt();
        return operationModeService.getById(operationModeId);
    }

}
