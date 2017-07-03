package com.medicalsystem.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Wraps all services into one class to keep brevity
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Services {

    public final AdmissionService admissionService;
    public final AnesthesiaService anesthesiaService;
    public final AnestheticService anestheticService;
    public final ComplicationDescriptionService complicationDescriptionService;
    public final ComplicationService complicationService;
    public final DiseaseDescriptionService diseaseDescriptionService;
    public final DiseaseService diseaseService;
    public final ExaminationDescriptionService examinationDescriptionService;
    public final ExaminationService examinationService;
    public final MedicamentService medicamentService;
    public final OperationModeService operationModeService;
    public final OperationService operationService;
    public final OperationTypeService operationTypeService;
    public final PatientService patientService;
    public final ReoperationService reoperationService;
    public final RevisitCauseService revisitCauseService;
    public final RevisitService revisitService;
    public final SmokingService smokingService;
    public final TroponinService troponinService;

}
