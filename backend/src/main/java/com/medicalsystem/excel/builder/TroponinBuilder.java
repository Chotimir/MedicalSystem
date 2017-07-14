package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Troponin;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TroponinBuilder {

    private final CellFormatter formatter;

    /**
     * W sumie nie wiem czemu tu jest lista ~MS
     */
    public List<Troponin> build(Row row, Admission admission) {
        List<Troponin> troponins = new ArrayList<>();

        /* Create troponin object */
        Troponin troponin = new Troponin();

        /* Admission */
        troponin.setAdmission(admission);

        /* Tnt */
        double tnt = formatter.init(row, "troponin.tnt.number").getAsDouble();
        troponin.setTnt(tnt);

        /* Tni ultra */
        double tniUltra = formatter.init(row, "troponin.tniUltra.number").getAsDouble();
        troponin.setTniUltra(tniUltra);

        /* Tni */
        double tni = formatter.init(row, "troponin.tni.number").getAsDouble();
        troponin.setTni(tni);

        /* Tnt day */
        double tntDay = formatter.init(row, "troponin.tntDay.number").getAsDouble();
        troponin.setTntDay(tntDay);

        /* Tni day */
        double tniDay = formatter.init(row, "troponin.tniDay.number").getAsDouble();
        troponin.setTniDay(tniDay);

        /* Add troponin object to list */
        troponins.add(troponin);

        return troponins;
    }
}
