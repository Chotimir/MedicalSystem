package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.*;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationBuilder {

    private final CellFormatter formatter;

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
        int duration = formatter.init(row, "operation.duration.number").getAsInt();
        operation.setDuration(duration);

        /* Aorta clotting time */
        int aortaClottingTime = formatter.init(row, "operation.aortaClottingTime.number").getAsInt();
        operation.setAortaClottingTime(aortaClottingTime);

        /* Noradrenaline */
        boolean noradrenaline = formatter.init(row, "operation.noradrenaline.number").getAsBoolean();
        operation.setNoradrenaline(noradrenaline);

        /* Adrenaline*/
        boolean adrenaline = formatter.init(row, "operation.adrenaline.number").getAsBoolean();
        operation.setAdrenaline(adrenaline);

        /* Dopamine */
        boolean dopamine = formatter.init(row, "operation.dopamine.number").getAsBoolean();
        operation.setDopamine(dopamine);

        /* Dobutamine */
        boolean dobutamine = formatter.init(row, "operation.dobutamine.number").getAsBoolean();
        operation.setDobutamine(dobutamine);

        /* Ephedrine */
        boolean ephedrine = formatter.init(row, "operation.ephedrine.number").getAsBoolean();
        operation.setEphedrine(ephedrine);

        /* Blood lost */
        int bloodLost = formatter.init(row, "operation.bloodLost.number").getAsInt();
        operation.setBloodLost(bloodLost);

        /* Urine expelled */
        int urineExpelled = formatter.init(row, "operation.urineExpelled.number").getAsInt();
        operation.setUrineExpelled(urineExpelled);

        /* Packed cells transfused */
        int packedCellsTransfused = formatter.init(row, "operation.packedCellsTransfused.number").getAsInt();
        operation.setPackedCellsTransfused(packedCellsTransfused);

        /* ICU time */
        int icuTime = formatter.init(row, "operation.icuTime.number").getAsInt();
        operation.setIcuTime(icuTime);

        /* Hospital time */
        int hospitalTime = formatter.init(row, "operation.hospitalTime.number").getAsInt();
        operation.setHospitalTime(hospitalTime);

        /* Extended ventilation */
        boolean extendedVentilation = formatter.init(row, "operation.extendedVentilation.number").getAsBoolean();
        operation.setExtendedVentilation(extendedVentilation);

        /* Ventilator days */
        int ventilatorDays = formatter.init(row, "operation.ventilatorDays.number").getAsInt();
        operation.setVentilatorDays(ventilatorDays);

        /* Complications */
        List<Complication> complications = complicationBuilder.build(row);
        operation.setComplications(complications);

        return operation;
    }

}
