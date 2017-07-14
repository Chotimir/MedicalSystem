package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellFormatter;
import com.medicalsystem.model.*;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdmissionBuilder {

    private final CellFormatter formatter;

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
        Date admissionDate = formatter.init(row, "admissionDate.number").getAsDate();
        admission.setAdmissionDate(admissionDate);

        /* Operation date */
        Date operationDate = formatter.init(row, "operationDate.number").getAsDate();
        admission.setOperationDate(operationDate);

        /* AA symptoms */
        int aaSymptoms = formatter.init(row, "aaSymptoms.number").getAsInt();
        admission.setAaSymptoms(aaSymptoms);

        /* AA size */
        int aaSize = formatter.init(row, "aaSize.number").getAsInt();
        admission.setAaSize(aaSize);

        /* Max aneurysm size */
        int maxAneurysmSize = formatter.init(row, "maxAneurysmSize.number").getAsInt();
        admission.setMaxAneurysmSize(maxAneurysmSize);

        /* Image examination */
        int imageExamination = formatter.init(row, "imageExamination.number").getAsInt();
        admission.setImageExamination(imageExamination);

        /* Aneurysm location */
        int aneurysmLocation = formatter.init(row, "aneurysmLocation.number").getAsInt();
        admission.setAneurysmLocation(aneurysmLocation);

        /* Smoking */
        Smoking smoking = smokingBuilder.build(row);
        admission.setSmoking(smoking);

        /* ASA scale */
        int asaScale = formatter.init(row, "asaScale.number").getAsInt();
        admission.setAsaScale(asaScale);

        /* Lee RCRI */
        int leeRcri = formatter.init(row, "leeRcri.number").getAsInt();
        admission.setLeeRcri(leeRcri);

        /* P-POSSUM */
        double pPossum = formatter.init(row, "pPossum.number").getAsDouble();
        admission.setPPossum(pPossum);

        /* Faint */
        int faint = formatter.init(row, "faint.number").getAsInt();
        admission.setFaint(faint);

        /* Reoperations */
        List<Reoperation> reoperations = reoperationBuilder.build(row);
        admission.setReoperations(reoperations);

        /* Comments */
        String comments = formatter.init(row, "comments.number").getAsString();
        admission.setComments(comments);

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
