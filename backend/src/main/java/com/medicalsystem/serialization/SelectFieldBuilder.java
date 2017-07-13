package com.medicalsystem.serialization;

import com.medicalsystem.model.OperationType;
import com.medicalsystem.service.OperationTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SelectFieldBuilder {

    private final OperationTypeService operationTypeService;

    public SelectField build(OperationType operationType) {
        SelectField selectField = new SelectField();

        /* Name */
        selectField.setName(operationType.getName());

        /* Values */
        List<OperationType> operationTypes = operationTypeService.listAll();
        List<String> operationTypeNames = operationTypes.stream().map(OperationType::getName).collect(Collectors.toList());
        selectField.setValues(operationTypeNames);

        /* Selected */
        selectField.setSelected(operationType.getName());

        return selectField;
    }

}
