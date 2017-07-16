package com.medicalsystem.excel.export;


import com.medicalsystem.excel.ExcelColumnsProperties;
import com.medicalsystem.model.*;
import com.medicalsystem.service.AdmissionService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjectExporter {

    private AdmissionService admissionService;
    private ExcelColumnsProperties prop;
    private CellBuilder cellBuilder;
    private Row row;

    @Autowired
    public ObjectExporter(AdmissionService admissionService, ExcelColumnsProperties prop, CellBuilder cellBuilder) {
        this.admissionService = admissionService;
        this.prop = prop;
        this.cellBuilder = cellBuilder;
    }

    public void saveDataIntoRow(Row row, int admissionId) {
        this.row = row;
        saveAdmission(admissionService.getById(admissionId));
    }

    private void saveAdmission(Admission admission) {
        savePatient(admission.getPatient());
        saveOperation(admission.getOperation());
        cellBuilder.saveDateInRow(row, prop.getColumnPropertyAsInt("admissionDate.number"), admission.getAdmissionDate());
        cellBuilder.saveDateInRow(row, prop.getColumnPropertyAsInt("operationDate.number"), admission.getOperationDate());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("aaSymptoms.number"), admission.getAaSymptoms());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("aaSize.number"), admission.getAaSize());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("maxAneurysmSize.number"), admission.getMaxAneurysmSize());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("imageExamination.number"), admission.getImageExamination());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("aneurysmLocation.number"), admission.getAneurysmLocation());
        saveSmoking(admission.getSmoking());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("asaScale.number"), admission.getAsaScale());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("leeRcri.number"), admission.getLeeRcri());
        cellBuilder.saveDoubleInRow(row, prop.getColumnPropertyAsInt("pPossum.number"), admission.getPPossum());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("faint.number"), admission.getFaint());
        saveReoperation(admission.getReoperations());
        cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("comments.number"), admission.getComments());
        saveExamination(admission.getExaminations());
        saveRevisit(admission.getRevisits());
        saveTroponin(admission.getTroponins());
        saveMedicament(admission.getMedicaments());
        saveOperationType(admission.getOperationTypes());
    }

    private void saveOperationType(List<OperationType> operationTypes) {

    }

    private void saveMedicament(List<Medicament> medicaments) {

    }

    private void saveTroponin(List<Troponin> troponins) {

    }

    private void saveRevisit(List<Revisit> revisits) {

    }

    private void saveExamination(List<Examination> examinations) {
    }

    private void saveReoperation(List<Reoperation> reoperations) {

    }

    private void saveSmoking(Smoking smoking) {

    }

    private void saveOperation(Operation operation) {
        saveOperationMode(operation.getOperationMode());
        saveAnetshesia(operation.getAnesthesia());
        saveAnesthetic(operation.getAnesthesia());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operation.duration.number"), operation.getDuration());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operation.aortaClottingTime.number"),
                operation.getAortaClottingTime());
        cellBuilder.saveBooleanInRow(row, prop.getColumnPropertyAsInt("operation.noradrenaline.number"),
                operation.isNoradrenaline());
        cellBuilder.saveBooleanInRow(row, prop.getColumnPropertyAsInt("operation.adrenaline.number"),
                operation.isAdrenaline());
        cellBuilder.saveBooleanInRow(row, prop.getColumnPropertyAsInt("operation.dopamine.number"),
                operation.isDopamine());
        cellBuilder.saveBooleanInRow(row, prop.getColumnPropertyAsInt("operation.dobutamine.number"),
                operation.isDobutamine());
        cellBuilder.saveBooleanInRow(row, prop.getColumnPropertyAsInt("operation.ephedrine.number"),
                operation.isEphedrine());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operation.bloodLost.number"), operation.getBloodLost());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operation.urineExpelled.number"), operation.getUrineExpelled());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operation.packedCellsTransfused.number"),
                operation.getPackedCellsTransfused());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operation.icuTime.number"), operation.getIcuTime());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operation.hospitalTime.number"), operation.getHospitalTime());
        cellBuilder.saveBooleanInRow(row, prop.getColumnPropertyAsInt("operation.extendedVentilation.number"),
                operation.isExtendedVentilation());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operation.ventilatorDays.number"), operation.getVentilatorDays());
        saveComplication(operation.getComplications());

    }

    private void saveComplication(List<Complication> complications) {

    }

    private void saveAnesthetic(Anesthesia anesthesia) {

    }

    private void saveAnetshesia(Anesthesia anesthesia) {

    }

    private void saveOperationMode(OperationMode operationMode) {

    }

    private void savePatient(Patient patient) {
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("id.number"), patient.getId());
        cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("firstName.number"), patient.getFirstName());
        cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("lastName.number"), patient.getLastName());
        cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("sex.number"), patient.getSex());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("age.number"), patient.getAge());
        saveDiseaseDescription(patient.getDiseaseDescriptions());
    }

    private void saveDiseaseDescription(List<DiseaseDescription> diseaseDescriptions) {
        //TODO:
    }


}
