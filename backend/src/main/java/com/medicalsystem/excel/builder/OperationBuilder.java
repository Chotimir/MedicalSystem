package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.*;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationBuilder {

    private final OperationModeBuilder operationModeBuilder;
    private final AnesthesiaBuilder anesthesiaBuilder;
    private final AnestheticBuilder anestheticBuilder;
    private final ComplicationBuilder complicationBuilder;

    public Operation build(Row row) {
        Operation operation = new Operation();

        /* Operation mode */
        OperationMode operationMode = operationModeBuilder.build(row);
        operation.setOperationMode(operationMode);

        /* Anesthesia */
        Anesthesia anesthesia = anesthesiaBuilder.build(row);
        operation.setAnesthesia(anesthesia);

        /* Anesthetic */
        Anesthetic anesthetic = anestheticBuilder.build(row);
        operation.setAnesthetic(anesthetic);

        /* Duration */
        CellValue duration = new CellValue(row, "operation.duration.number");
        operation.setDuration(duration.getAsInt());

        /* Aorta clotting time */
        CellValue aortaClottingTime = new CellValue(row, "operation.aortaClottingTime.number");
        operation.setAortaClottingTime(aortaClottingTime.getAsInt());

        /* Noradrenaline */
        CellValue noradrenaline = new CellValue(row, "operation.noradrenaline.number");
        operation.setNoradrenaline(noradrenaline.getAsBoolean());

        /* Adrenaline*/
        CellValue adrenaline = new CellValue(row, "operation.adrenaline.number");
        operation.setAdrenaline(adrenaline.getAsBoolean());

        /* Dopamine */
        CellValue dopamine = new CellValue(row, "operation.dopamine.number");
        operation.setDopamine(dopamine.getAsBoolean());

        /* Dobutamine */
        CellValue dobutamine = new CellValue(row, "operation.dobutamine.number");
        operation.setDobutamine(dobutamine.getAsBoolean());

        /* Ephedrine */
        CellValue ephedrine = new CellValue(row, "operation.ephedrine.number");
        operation.setEphedrine(ephedrine.getAsBoolean());

        /* Blood lost */
        CellValue bloodLost = new CellValue(row, "operation.bloodLost.number");
        operation.setBloodLost(bloodLost.getAsInt());

        /* Urine expelled */
        CellValue urineExpelled = new CellValue(row, "operation.urineExpelled.number");
        operation.setUrineExpelled(urineExpelled.getAsInt());

        /* Packed cells transfused */
        CellValue packedCellsTransfused = new CellValue(row, "operation.packedCellsTransfused.number");
        operation.setPackedCellsTransfused(packedCellsTransfused.getAsInt());

        /* ICU time */
        CellValue icuTime = new CellValue(row, "operation.icuTime.number");
        operation.setIcuTime(icuTime.getAsInt());

        /* Hospital time */
        CellValue hospitalTime = new CellValue(row, "operation.hospitalTime.number");
        operation.setHospitalTime(hospitalTime.getAsInt());

        /* Extended ventilation */
        CellValue extendedVentilation = new CellValue(row, "operation.extendedVentilation.number");
        operation.setExtendedVentilation(extendedVentilation.getAsBoolean());

        /* Ventilator days */
        CellValue ventilatorDays = new CellValue(row, "operation.ventilatorDays.number");
        operation.setVentilatorDays(ventilatorDays.getAsInt());

        /* Complications */
        List<Complication> complications = complicationBuilder.build(row);
        operation.setComplications(complications);

        return operation;
    }

}
