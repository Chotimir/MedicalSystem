package com.medicalsystem.json;

import com.medicalsystem.model.Complication;
import com.medicalsystem.model.ComplicationDescription;
import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.model.OperationType;
import com.medicalsystem.service.ComplicationService;
import com.medicalsystem.service.OperationTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SelectFieldBuilder {

    private final OperationTypeService operationTypeService;
    private final ComplicationService complicationService;

    public SelectField fromOperationType(OperationType operationType) {
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
        return diseases.stream()
                .map(this::fromDisease)
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

    private SelectField fromDisease(DiseaseDescription disease) {
        SelectField selectField = new SelectField();

        /* Name */
        selectField.setName(disease.getDisease().getName());

        /* Values */
        selectField.setValues(disease.getDisease().getDescriptions().stream().map(DiseaseDescription::getDescription).collect(Collectors.toList()));

        /* Selected */
        selectField.setSelected(disease.getDescription());

        return selectField;
    }

    public SelectField fromAASymptoms(int aaSymptoms) {
        SelectField selectField = new SelectField();
        selectField.setName("AA Symptoms");

        // TODO: zamienić na cywilizowaną tabelę w bazie danych
        Map<Integer, String> dictionary = new HashMap<>();
        dictionary.put(-1, "nie dotyczy");
        dictionary.put(0, "bezobjawowy");
        dictionary.put(1, "objawowy");
        dictionary.put(2, "pęknięty");
        selectField.setValues(new ArrayList<>(dictionary.values()));

        selectField.setSelected(dictionary.get(aaSymptoms));

        return selectField;
    }

    public SelectField fromImageExamination(int imageExamination) {
        SelectField selectField = new SelectField();
        selectField.setName("Image examination");
        // TODO: skonsultować i poprawić
        selectField.setValues(Arrays.asList("-1", "0", "1", "2", "3"));
        selectField.setSelected(String.valueOf(imageExamination));
        return selectField;
    }

}
