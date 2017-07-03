package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.*;
import com.medicalsystem.service.Services;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationBuilder {

    private final Services services;

    @Autowired
    public OperationBuilder(Services services) {
        this.services = services;
    }

    public Operation build(Row row) {
        Operation operation = new Operation();

        /* Operation mode */
        CellValue operationModeCell = new CellValue(row, "operationMode.number");
        int operationModeId = operationModeCell.getAsInt();
        OperationMode operationMode = services.operationModeService.getById(operationModeId);
        operation.setOperationMode(operationMode);

        /* Anesthesia */
        CellValue anesthesiaCell = new CellValue(row, "anesthesia.number");
        int anesthesiaId = anesthesiaCell.getAsInt();
        Anesthesia anesthesia = services.anesthesiaService.getById(anesthesiaId);
        operation.setAnesthesia(anesthesia);

        /* Anesthetic */
        CellValue anestheticCell = new CellValue(row, "anesthetic.number");
        int anestheticId = anestheticCell.getAsInt();
        Anesthetic anesthetic = services.anestheticService.getById(anestheticId);
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
        List<Complication> complications = getComplications(row);
        operation.setComplications(complications);

        return operation;
    }

    // TODO: taki sam problem jak z Disease i DiseaseDescription ~MS
    private List<Complication> getComplications(Row row) {
        List<Complication> complications = new ArrayList<>();
        return complications;
    }

}
