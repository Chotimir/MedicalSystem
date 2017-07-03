package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Revisit;
import com.medicalsystem.model.RevisitCause;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RevisitBuilder {

    private final RevisitCauseBuilder revisitCauseBuilder;

    @Autowired
    public RevisitBuilder(RevisitCauseBuilder revisitCauseBuilder) {
        this.revisitCauseBuilder = revisitCauseBuilder;
    }

    /**
     * W sumie nie wiem czemu tu jest lista ~MS
     */
    public List<Revisit> build(Row row, Admission admission) {
        List<Revisit> revisits = new ArrayList<>();

        /* Check if there was a revisit */
        CellValue revisitCell = new CellValue(row, "revisit.number");
        if (revisitCell.getAsInt() != 1)
            return revisits;

        /* Create revisit object */
        Revisit revisit = new Revisit();

        /* Admission */
        revisit.setAdmission(admission);

        /* Control visit */
        CellValue controlVisit = new CellValue(row, "controlVisit.number");
        revisit.setControlVisit(controlVisit.getAsInt());

        /* Revisit date */
        CellValue revisitDate = new CellValue(row, "revisit.date.number");
        revisit.setDate(revisitDate.getAsDate());

        /* Revisit cause */
        RevisitCause revisitCause = revisitCauseBuilder.build(row);
        revisit.setCause(revisitCause);

        /* Add revisit to list */
        revisits.add(revisit);

        return revisits;
    }

}
