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
public class AdmissionBuilder {

    private final SmokingBuilder smokingBuilder;
    private final ReoperationBuilder reoperationBuilder;
    private final ExaminationBuilder examinationBuilder;
    private final RevisitBuilder revisitBuilder;
    private final TroponinBuilder troponinBuilder;
    private final MedicamentBuilder medicamentBuilder;
    private final OperationTypeBuilder operationTypeBuilder;

    public Admission build(Row row, Patient patient, Operation operation) {
        Admission admission = new Admission();

        /* Patient */
        admission.setPatient(patient);

        /* Operation */
        admission.setOperation(operation);

        /* Admission date */
        CellValue admissionDate = new CellValue(row, "admissionDate.number");
        admission.setAdmissionDate(admissionDate.getAsDate());

        /* Operation date */
        CellValue operationDate = new CellValue(row, "operationDate.number");
        admission.setOperationDate(operationDate.getAsDate());

        /* AA symptoms */
        CellValue aaSymptoms = new CellValue(row, "aaSymptoms.number");
        admission.setAaSymptoms(aaSymptoms.getAsInt());

        /* AA size */
        CellValue aaSize = new CellValue(row, "aaSize.number");
        admission.setAaSize(aaSize.getAsInt());

        /* Max aneurysm size */
        CellValue maxAneurysmSize = new CellValue(row, "maxAneurysmSize.number");
        admission.setMaxAneurysmSize(maxAneurysmSize.getAsInt());

        /* Image examination */
        CellValue imageExamination = new CellValue(row, "imageExamination.number");
        admission.setImageExamination(imageExamination.getAsInt());

        /* Aneurysm location */
        CellValue aneurysmLocation = new CellValue(row, "aneurysmLocation.number");
        admission.setAneurysmLocation(aneurysmLocation.getAsInt());

        /* Smoking */
        Smoking smoking = smokingBuilder.build(row);
        admission.setSmoking(smoking);

        /* ASA scale */
        CellValue asaScale = new CellValue(row, "asaScale.number");
        admission.setAsaScale(asaScale.getAsInt());

        /* Lee RCRI */
        CellValue leeRcri = new CellValue(row, "leeRcri.number");
        admission.setLeeRcri(leeRcri.getAsInt());

        /* P-POSSUM */
        CellValue pPossum = new CellValue(row, "pPossum.number");
        admission.setPPossum(pPossum.getAsDouble());

        /* Faint */
        CellValue faint = new CellValue(row, "faint.number");
        admission.setFaint(faint.getAsInt());

        /* Reoperations */
        List<Reoperation> reoperations = reoperationBuilder.build(row);
        admission.setReoperations(reoperations);

        /* Comments */
        CellValue comments = new CellValue(row, "comments.number");
        admission.setComments(comments.getAsString());

        /* Examinations */
        List<Examination> examinations = examinationBuilder.build(row, admission);
        admission.setExaminations(examinations);

        /* Revisits */
        List<Revisit> revisits = revisitBuilder.build(row, admission);
        admission.setRevisits(revisits);

        /* Troponins */
        List<Troponin> troponins = troponinBuilder.build(row, admission);
        admission.setTroponins(troponins);

        /* Medicaments */
        List<Medicament> medicaments = medicamentBuilder.build(row);
        admission.setMedicaments(medicaments);

        /* Operation types */
        List<OperationType> operationTypes = operationTypeBuilder.build(row);
        admission.setOperationTypes(operationTypes);

        return admission;
    }

}
