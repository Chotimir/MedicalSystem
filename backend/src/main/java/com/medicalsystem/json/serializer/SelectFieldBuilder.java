package com.medicalsystem.json.serializer;

import com.medicalsystem.model.Complication;
import com.medicalsystem.model.ComplicationDescription;
import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.model.OperationType;
import com.medicalsystem.service.ComplicationService;
import com.medicalsystem.service.OperationTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SelectFieldBuilder {

    private final OperationTypeService operationTypeService;
    private final ComplicationService complicationService;

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

    public List<SelectField> fromDiseases(List<DiseaseDescription> diseases) {
        // TODO: pisane godzinę przed spotkaniem, oczywiście do przepisania
        return diseases.stream()
                .map(disease -> {
                    SelectField selectField = new SelectField();
                    selectField.setName(disease.getDisease().getName());
                    selectField.setValues(disease.getDisease().getDescriptions().stream().map(DiseaseDescription::getDescription).collect(Collectors.toList()));
                    selectField.setSelected(disease.getDescription());
                    return selectField;
                })
                .collect(Collectors.toList());
    }

    public List<SelectField> fromComplications(List<Complication> complications) {
        // TODO: mock
        complications = complicationService.listAll();
        Collections.shuffle(complications);
        List<SelectField> selectFields = new ArrayList<>();

        for (int i = 0; i < new Random().nextInt(complications.size() / 6); i++) {
            SelectField selectField = new SelectField();
            selectField.setName(complications.get(i).getName());
            selectField.setValues(complications.get(i).getDescription().stream().map(ComplicationDescription::getDescription).collect(Collectors.toList()));
            selectField.setSelected(selectField.getValues().get(1));
            selectFields.add(selectField);
        }

        return selectFields;
    }

}
