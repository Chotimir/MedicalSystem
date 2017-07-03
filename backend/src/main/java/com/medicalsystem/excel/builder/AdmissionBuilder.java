package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.excel.ExcelColumnsProperties;
import com.medicalsystem.model.*;
import com.medicalsystem.service.Services;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdmissionBuilder {

    private final Services services;
    private final ExcelColumnsProperties columnsProperties;

    @Autowired
    public AdmissionBuilder(Services services, ExcelColumnsProperties columnsProperties) {
        this.services = services;
        this.columnsProperties = columnsProperties;
    }

    public Admission build(Row row) {
        Admission admission = new Admission();

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
        CellValue smokingId = new CellValue(row, "smoking.number");
        Smoking smoking = services.smokingService.getById(smokingId.getAsInt());
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
        List<Reoperation> reoperations = getReoperations(row);
        admission.setReoperations(reoperations);

        /* Comments */
        CellValue comments = new CellValue(row, "comments.number");
        admission.setComments(comments.getAsString());

        /* Examinations */
        List<Examination> examinations = getExaminations(row, admission);
        admission.setExaminations(examinations);

        /* Revisits */
        List<Revisit> revisits = getRevisits(row, admission);
        admission.setRevisits(revisits);

        /* Troponins */
        List<Troponin> troponins = getTroponins(row, admission);
        admission.setTroponins(troponins);

        /* Medicaments */
        List<Medicament> medicaments = getMedicaments(row);
        admission.setMedicaments(medicaments);

        /* Operation types */
        List<OperationType> operationTypes = getOperationTypes(row);
        admission.setOperationTypes(operationTypes);

        return admission;
    }

    /**
     * Creates a list of Reoperation based on excel input.
     * Input can be e.g. "456", "13", "6", hence the list.
     */
    private List<Reoperation> getReoperations(Row row) {
        List<Reoperation> reoperations = new ArrayList<>();

        /* Reoperation */
        CellValue reoperationCell = new CellValue(row, "reoperation.number");
        String value = reoperationCell.getAsString();

        for (char c : value.toCharArray()) {
            int id = Character.getNumericValue(c);
            Reoperation reoperation = services.reoperationService.getById(id);

            if (reoperation == null) {
                System.out.println("Reoperation not found: " + id);
                continue;
            }

            reoperations.add(reoperation);
        }

        return reoperations;
    }

    private List<Examination> getExaminations(Row row, Admission admission) {
        List<Examination> examinations = new ArrayList<>();

        /* Get index of the column of the first examination */
        int firstExamIndex = columnsProperties.getPropertyAsInt("examination.pchn.number");

        /* Get index of the column of the last examination */
        int lastExamIndex = columnsProperties.getPropertyAsInt("examination.fibrinogen.number");

        /* Iterate over examinations - assumes that examination description ids are in proper order */
        int descriptionId = 1;

        for (int i = firstExamIndex; i <= lastExamIndex; i++) {

            /* Get examination result */
            CellValue resultCell = new CellValue(row, i);
            double result = resultCell.getAsDouble();

            /* Get corresponding examination description */
            ExaminationDescription description = services.examinationDescriptionService.getById(descriptionId++);

            /* Build examination object */
            Examination examination = new Examination();

            examination.setAdmission(admission);
            examination.setDescription(description);
            examination.setResult(result);

            examinations.add(examination);
        }

        return examinations;
    }

    /**
     * W sumie nie wiem czemu tu jest lista ~MS
     */
    private List<Revisit> getRevisits(Row row, Admission admission) {
        List<Revisit> revisits = new ArrayList<>();

        /* Check if there was a revisit */
        CellValue revisitCell = new CellValue(row, "revisit.number");
        if (revisitCell.getAsInt() != 1)
            return revisits;

        /* Create revisit object */
        Revisit revisit = new Revisit();

        /* Admission */
        revisit.setAdmission(admission);

        /* Control visit */
        CellValue controlVisit = new CellValue(row, "controlVisit.number");
        revisit.setControlVisit(controlVisit.getAsInt());

        /* Revisit date */
        CellValue revisitDate = new CellValue(row, "revisit.date.number");
        revisit.setDate(revisitDate.getAsDate());

        /* Revisit cause */
        CellValue revisitCauseCell = new CellValue(row, "revisit.cause.number");
        int revisitCauseId = revisitCauseCell.getAsInt();
        RevisitCause revisitCause = services.revisitCauseService.getById(revisitCauseId);
        revisit.setCause(revisitCause);

        /* Add revisit to list */
        revisits.add(revisit);

        return revisits;
    }

    /**
     * W sumie nie wiem czemu tu jest lista ~MS
     */
    private List<Troponin> getTroponins(Row row, Admission admission) {
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

    /**
     * TODO: Każdy lek w excelu może mieć wartość 0, 1 lub bd.
     * TODO: Obecnie wrzucamy do listy tylko te z wartością 1, nie mamy możliwości oznaczenia leku jako bd,
     * TODO: jedynie czy jest lub czy go nie ma (tak chyba nie może być) ~MS
     */
    private List<Medicament> getMedicaments(Row row) {
        List<Medicament> medicaments = new ArrayList<>();

        /* Get index of the column of the first medicament */
        int firstMedIndex = columnsProperties.getPropertyAsInt("medicament.aspirin.number");

        /* Get index of the column of the last medicament */
        int lastMedIndex = columnsProperties.getPropertyAsInt("medicament.fibrate.number");

        /* Iterate over medicaments - assumes that medicament ids are in proper order */
        int medicamentId = 1;

        for (int i = firstMedIndex; i <= lastMedIndex; i++) {

            /* Check if given medicament was applied */
            CellValue value = new CellValue(row, i);
            if (value.getAsInt() != 1)
                continue;

            /* Get medicament from DB */
            Medicament medicament = services.medicamentService.getById(medicamentId++);

            /* Add medicament to the list */
            medicaments.add(medicament);
        }

        return medicaments;
    }

    /**
     * Creates a list of OperationType based on excel input.
     * Input can be e.g. "13", "16", "2", hence the list.
     */
    private List<OperationType> getOperationTypes(Row row) {
        List<OperationType> operationTypes = new ArrayList<>();

        /* Operation type */
        CellValue operationTypeCell = new CellValue(row, "operationType.number");
        String value = operationTypeCell.getAsString();

        for (char c : value.toCharArray()) {
            int id = Character.getNumericValue(c);
            OperationType operationType = services.operationTypeService.getById(id);

            if (operationType == null) {
                System.out.println("Operation type not found: " + id);
                continue;
            }

            operationTypes.add(operationType);
        }

        return operationTypes;
    }
}
