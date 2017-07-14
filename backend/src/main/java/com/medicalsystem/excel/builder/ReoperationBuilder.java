package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.Reoperation;
import com.medicalsystem.service.ReoperationService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReoperationBuilder {

    private final CellFormatter formatter;
    private final ReoperationService reoperationService;

    /**
     * Creates a list of Reoperation based on excel input.
     * Input can be e.g. "456", "13", "6", hence the list.
     */
    public List<Reoperation> build(Row row) {
        List<Reoperation> reoperations = new ArrayList<>();

        /* Reoperation */
        String value = formatter.init(row, "reoperation.number").getAsString();

        for (char c : value.toCharArray()) {
            int id = Character.getNumericValue(c);
            Reoperation reoperation = reoperationService.getById(id);

            if (reoperation == null) {
                System.out.println("Reoperation not found: " + id);
                continue;
            }

            reoperations.add(reoperation);
        }

        return reoperations;
    }

}
