package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.OperationType;
import com.medicalsystem.service.OperationTypeService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationTypeBuilder {

    private final CellFormatter formatter;

    private final OperationTypeService operationTypeService;

    /**
     * Creates a list of OperationType based on excel input.
     * Input can be e.g. "13", "16", "2", hence the list.
     */
    public List<OperationType> build(Row row) {
        List<OperationType> operationTypes = new ArrayList<>();

        /* Operation type */
        String value = formatter.init(row, "operationType.number").getAsString();

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
