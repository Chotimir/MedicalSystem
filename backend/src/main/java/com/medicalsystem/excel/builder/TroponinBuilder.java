package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Troponin;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TroponinBuilder {

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
        CellValue tnt = new CellValue(row, "troponin.tnt.number");
        troponin.setTnt(tnt.getAsDouble());

        /* Tni ultra */
        CellValue tniUltra = new CellValue(row, "troponin.tniUltra.number");
        troponin.setTniUltra(tniUltra.getAsDouble());

        /* Tni */
        CellValue tni = new CellValue(row, "troponin.tni.number");
        troponin.setTni(tni.getAsDouble());

        /* Tnt day */
        CellValue tntDay = new CellValue(row, "troponin.tntDay.number");
        troponin.setTntDay(tntDay.getAsDouble());

        /* Tni day */
        CellValue tniDay = new CellValue(row, "troponin.tniDay.number");
        troponin.setTniDay(tniDay.getAsDouble());

        /* Add troponin object to list */
        troponins.add(troponin);

        return troponins;
    }
}
