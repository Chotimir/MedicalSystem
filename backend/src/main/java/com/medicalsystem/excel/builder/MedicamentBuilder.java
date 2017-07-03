package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.excel.ExcelColumnsProperties;
import com.medicalsystem.model.Medicament;
import com.medicalsystem.service.MedicamentService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicamentBuilder {

    private final ExcelColumnsProperties columnsProperties;
    private final MedicamentService medicamentService;

    @Autowired
    public MedicamentBuilder(ExcelColumnsProperties columnsProperties, MedicamentService medicamentService) {
        this.columnsProperties = columnsProperties;
        this.medicamentService = medicamentService;
    }

    /**
     * TODO: Każdy lek w excelu może mieć wartość 0, 1 lub bd.
     * TODO: Obecnie wrzucamy do listy tylko te z wartością 1, nie mamy możliwości oznaczenia leku jako bd,
     * TODO: jedynie czy jest lub czy go nie ma (tak chyba nie może być) ~MS
     */
    public List<Medicament> build(Row row) {
        List<Medicament> medicaments = new ArrayList<>();

        /* Get index of the column of the first medicament */
        int firstMedIndex = columnsProperties.getPropertyAsInt("medicament.aspirin.number");

        /* Get index of the column of the last medicament */
        int lastMedIndex = columnsProperties.getPropertyAsInt("medicament.fibrate.number");

        /* Iterate over medicaments - assumes that medicament ids are in proper order */
        int medicamentId = 1;

        for (int i = firstMedIndex; i <= lastMedIndex; i++) {

            /* Check if given medicament was applied */
            CellValue value = new CellValue(row, i);
            if (value.getAsInt() != 1)
                continue;

            /* Get medicament from DB */
            Medicament medicament = medicamentService.getById(medicamentId++);

            /* Add medicament to the list */
            medicaments.add(medicament);
        }

        return medicaments;
    }

}
