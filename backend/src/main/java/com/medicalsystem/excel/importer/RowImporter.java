package com.medicalsystem.excel.importer;

import com.medicalsystem.excel.builder.AdmissionBuilder;
import com.medicalsystem.excel.builder.OperationBuilder;
import com.medicalsystem.excel.builder.PatientBuilder;
import com.medicalsystem.model.*;
import com.medicalsystem.service.Services;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RowImporter {

    private final Services services;

    private final PatientBuilder patientBuilder;
    private final AdmissionBuilder admissionBuilder;
    private final OperationBuilder operationBuilder;

    @Autowired
    public RowImporter(Services services, PatientBuilder patientBuilder, AdmissionBuilder admissionBuilder, OperationBuilder operationBuilder) {
        this.services = services;
        this.patientBuilder = patientBuilder;
        this.admissionBuilder = admissionBuilder;
        this.operationBuilder = operationBuilder;
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
        services.patientService.saveOrUpdate(patient);
        services.operationService.saveOrUpdate(operation);
        services.admissionService.saveOrUpdate(admission);

        System.out.println("ROW PERSISTED");
    }



}
