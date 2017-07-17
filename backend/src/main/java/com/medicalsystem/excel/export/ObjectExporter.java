package com.medicalsystem.excel.export;


import com.medicalsystem.excel.ExcelColumnsProperties;
import com.medicalsystem.model.*;
import com.medicalsystem.service.*;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectExporter {

    private AdmissionService admissionService;
    private SmokingService smokingService;
    private ReoperationService reoperationService;
    private MedicamentService medicamentService;
    private OperationModeService operationModeService;
    private ExcelColumnsProperties prop;
    private CellBuilder cellBuilder;

    private Row row;

    public ObjectExporter(AdmissionService admissionService, SmokingService smokingService,
                          ReoperationService reoperationService, MedicamentService medicamentService,
                          ExcelColumnsProperties prop, CellBuilder cellBuilder, OperationModeService operationModeService) {
        this.admissionService = admissionService;
        this.smokingService = smokingService;
        this.reoperationService = reoperationService;
        this.medicamentService = medicamentService;
        this.prop = prop;
        this.cellBuilder = cellBuilder;
        this.operationModeService = operationModeService;
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
        saveReoperations(admission.getReoperations());
        cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("comments.number"), admission.getComments());
        saveExaminations(admission.getExaminations());
        saveRevisits(admission.getRevisits());
        saveTroponins(admission.getTroponins());
        saveMedicament(admission.getMedicaments());
        saveOperationType(admission.getOperationTypes());
    }

    private void saveOperationType(List<OperationType> operationTypes) {
        String operationTypeNumbers = "";
        for (int i = 0; i < operationTypes.size(); i++) {
            operationTypeNumbers += operationTypes.get(i).getId();
        }
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operationType.number"),
                Integer.valueOf(operationTypeNumbers));
    }

    private void saveMedicament(List<Medicament> medicaments) {
        Set<Medicament> medicamentsSet = medicaments.stream().collect(Collectors.toSet());
        int firstExamIndex = prop.getColumnPropertyAsInt("medicament.aspirin.number");
        int lastExamIndex =  prop.getColumnPropertyAsInt("medicament.fibrate.number");
        for(int index = firstExamIndex, examinationId = 1; index <= lastExamIndex; index++, examinationId++) {
            Medicament byId = medicamentService.getById(examinationId);
            if (medicamentsSet.contains(byId)) {
                cellBuilder.saveIntInRow(row, index, 1);
            } else {
                //TODO: lista powinna zawierac wszystkie elementy, nie tylko te z wartosci 1
                cellBuilder.saveStringInRow(row, index, "bd");
            }
        }
    }

    private void saveTroponins(List<Troponin> troponins) {
        if (troponins.isEmpty()) {
            return;
        }
        Troponin troponin = troponins.get(0);
        saveTroponin(row, prop.getColumnPropertyAsInt("troponin.tnt.number"), troponin.getTnt());
        saveTroponin(row, prop.getColumnPropertyAsInt("troponin.tniUltra.number"), troponin.getTniUltra());
        saveTroponin(row, prop.getColumnPropertyAsInt("troponin.tni.number"), troponin.getTni());
        saveTroponin(row, prop.getColumnPropertyAsInt("troponin.tntDay.number"), troponin.getTntDay());
        saveTroponin(row, prop.getColumnPropertyAsInt("troponin.tniDay.number"), troponin.getTniDay());
    }

    private void saveTroponin(Row row, int index, double result) {
        if (result != -1.0) {
            cellBuilder.saveDoubleInRow(row, index, result);
        } else {
            cellBuilder.saveStringInRow(row, index, "x");
        }
    }

    private void saveRevisits(List<Revisit> revisits) {
        if (revisits.isEmpty()) {
            cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("revisit.number"), "x");
            cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("controlVisit.number"), "x");
            cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("revisit.date.number"), "x");
            cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("revisit.cause.number"), "x");
            return;
        }
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("revisit.number"), revisits.get(0).getControlVisit());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("controlVisit.number"), 1);
        cellBuilder.saveDateInRow(row, prop.getColumnPropertyAsInt("revisit.date.number"), revisits.get(0).getDate());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("revisit.cause.number"), revisits.get(0).getCause().getId());



    }

    private void saveExaminations(List<Examination> examinations) {
        int firstExamIndex = prop.getColumnPropertyAsInt("examination.pchn.number");
        int lastExamIndex =  prop.getColumnPropertyAsInt("examination.fibrinogen.number");
        for(int index = firstExamIndex, examinationId = 0; index <= lastExamIndex; index++, examinationId++) {
            double result = examinations.get(examinationId).getResult();
            if (result != -1.0) {
                cellBuilder.saveDoubleInRow(row, index, result);
            } else {
                cellBuilder.saveStringInRow(row, index, "bd");
            }
        }
    }

    private void saveReoperations(List<Reoperation> reoperations) {
        String reoperationNumbers = "";
        for (int i = 0; i < reoperations.size(); i++) {
            reoperationNumbers += reoperations.get(i).getId();
        }
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("reoperation.number"),
                Integer.valueOf(reoperationNumbers));
    }

    private void saveSmoking(Smoking smoking) {
        if (smoking == null) {
            cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("smoking.number"),"bd");
        } else {
            cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("smoking.number"), smoking.getId());
        }
    }

    private void saveOperation(Operation operation) {
        saveOperationMode(operation.getOperationMode());
        saveAnetshesia(operation.getAnesthesia());
        saveAnesthetic(operation.getAnesthetic());
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
        //TODO: fix an issue
    }

    private void saveAnesthetic(Anesthetic anesthetic) {
        if (anesthetic == null) {
            cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("anesthetic.number"), "bd");
        } else {
            cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("anesthetic.number"), anesthetic.getId());
        }
    }

    private void saveAnetshesia(Anesthesia anesthesia) {
        if (anesthesia == null) {
            cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("anesthesia.number"), "bd");
        } else {
            cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("anesthesia.number"), anesthesia.getId());
        }
    }

    private void saveOperationMode(OperationMode operationMode) {
        if (operationMode == null) {
            cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("operationMode.number"), "bd");
        } else {
            cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("operationMode.number"), operationMode.getId());
        }
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
        //TODO: fix an issue
    }


}
