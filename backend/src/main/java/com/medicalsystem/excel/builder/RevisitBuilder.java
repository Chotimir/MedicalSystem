package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Revisit;
import com.medicalsystem.model.RevisitCause;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RevisitBuilder {

    private final CellFormatter formatter;

    private final RevisitCauseBuilder revisitCauseBuilder;

    /**
     * W sumie nie wiem czemu tu jest lista ~MS
     */
    public List<Revisit> build(Row row, Admission admission) {
        List<Revisit> revisits = new ArrayList<>();

        /* Check if there was a revisit */
        int revisitValue = formatter.init(row, "revisit.number").getAsInt();
        if (revisitValue != 1)
            return revisits;

        /* Create revisit object */
        Revisit revisit = new Revisit();

        /* Admission */
        revisit.setAdmission(admission);

        /* Control visit */
        int controlVisit = formatter.init(row, "controlVisit.number").getAsInt();
        revisit.setControlVisit(controlVisit);

        /* Revisit date */
        Date revisitDate = formatter.init(row, "revisit.date.number").getAsDate();
        revisit.setDate(revisitDate);

        /* Revisit cause */
        RevisitCause revisitCause = revisitCauseBuilder.build(row);
        revisit.setCause(revisitCause);

        /* Add revisit to list */
        revisits.add(revisit);

        return revisits;
    }

}
