package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.OperationType;
import com.medicalsystem.service.OperationTypeService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationTypeBuilder {

    private final OperationTypeService operationTypeService;

    @Autowired
    public OperationTypeBuilder(OperationTypeService operationTypeService) {
        this.operationTypeService = operationTypeService;
    }

    /**
     * Creates a list of OperationType based on excel input.
     * Input can be e.g. "13", "16", "2", hence the list.
     */
    public List<OperationType> build(Row row) {
        List<OperationType> operationTypes = new ArrayList<>();

        /* Operation type */
        CellValue operationTypeCell = new CellValue(row, "operationType.number");
        String value = operationTypeCell.getAsString();

        for (char c : value.toCharArray()) {
            int id = Character.getNumericValue(c);
            OperationType operationType = operationTypeService.getById(id);

            if (operationType == null) {
                System.out.println("Operation type not found: " + id);
                continue;
            }

            operationTypes.add(operationType);
        }

        return operationTypes;
    }

}
