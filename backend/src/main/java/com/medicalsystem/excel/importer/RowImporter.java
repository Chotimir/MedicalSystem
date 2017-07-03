package com.medicalsystem.excel.importer;

import com.medicalsystem.excel.builder.AdmissionBuilder;
import com.medicalsystem.excel.builder.OperationBuilder;
import com.medicalsystem.excel.builder.PatientBuilder;
import com.medicalsystem.model.*;
import com.medicalsystem.service.AdmissionService;
import com.medicalsystem.service.OperationService;
import com.medicalsystem.service.PatientService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RowImporter {

    private final PatientBuilder patientBuilder;
    private final AdmissionBuilder admissionBuilder;
    private final OperationBuilder operationBuilder;

    private final PatientService patientService;
    private final OperationService operationService;
    private final AdmissionService admissionService;

    @Autowired
    public RowImporter(PatientBuilder patientBuilder, AdmissionBuilder admissionBuilder, OperationBuilder operationBuilder, PatientService patientService, OperationService operationService, AdmissionService admissionService) {
        this.patientBuilder = patientBuilder;
        this.admissionBuilder = admissionBuilder;
        this.operationBuilder = operationBuilder;
        this.patientService = patientService;
        this.operationService = operationService;
        this.admissionService = admissionService;
    }

    public void importToDB(Row row) {
        /* Patient */
        Patient patient = patientBuilder.build(row);

        /* Operation */
        Operation operation = operationBuilder.build(row);

        /* Admission */
        Admission admission = admissionBuilder.build(row);
        admission.setPatient(patient);
        admission.setOperation(operation);

        /* Persist entities */
        patientService.saveOrUpdate(patient);
        operationService.saveOrUpdate(operation);
        admissionService.saveOrUpdate(admission);

        System.out.println("ROW PERSISTED");
    }



}
