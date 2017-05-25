package com.medicalsystem.controller;

import com.medicalsystem.ObjectFromExcelFactory;
import com.medicalsystem.excel.ExcelParser;
import com.medicalsystem.service.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

//This is just a temporary controller for tests (I know, it looks awful)
@RestController
public class ImportFromExcelController {

    private AdmissionService admissionService;
    private final AnesthesiaService anesthesiaService;
    private final AnestheticService anestheticService;
    private final ComplicationDescriptionService complicationDescriptionService;
    private final ComplicationService complicationService;
    private final DiseaseDescriptionService diseaseDescriptionService;
    private final DiseaseService diseaseService;
    private final ExaminationDescriptionService examinationDescriptionService;
    private ExaminationService examinationService;
    private final MedicamentService medicamentService;
    private final OperationModeService operationModeService;
    private OperationService operationService;
    private final OperationTypeService operationTypeService;
    private PatientService patientService;
    private ReoperationService reoperationService;
    private final RevisitCauseService revisitCauseService;
    private RevisitService revisitService;
    private final SmokingService smokingService;
    private TroponinService troponinService;

    public ImportFromExcelController(AdmissionService admissionService, AnesthesiaService anesthesiaService,
                                     AnestheticService anestheticService, ComplicationDescriptionService
                                             complicationDescriptionService, ComplicationService complicationService,
                                     DiseaseDescriptionService diseaseDescriptionService, DiseaseService diseaseService,
                                     ExaminationDescriptionService examinationDescriptionService, ExaminationService examinationService,
                                     MedicamentService medicamentService, OperationModeService operationModeService,
                                     OperationService operationService, OperationTypeService operationTypeService,
                                     PatientService patientService, ReoperationService reoperationService,
                                     RevisitCauseService revisitCauseService, RevisitService revisitService,
                                     SmokingService smokingService, TroponinService troponinService) {
        this.admissionService = admissionService;
        this.anesthesiaService = anesthesiaService;
        this.anestheticService = anestheticService;
        this.complicationDescriptionService = complicationDescriptionService;
        this.complicationService = complicationService;
        this.diseaseDescriptionService = diseaseDescriptionService;
        this.diseaseService = diseaseService;
        this.examinationDescriptionService = examinationDescriptionService;
        this.examinationService = examinationService;
        this.medicamentService = medicamentService;
        this.operationModeService = operationModeService;
        this.operationService = operationService;
        this.operationTypeService = operationTypeService;
        this.patientService = patientService;
        this.reoperationService = reoperationService;
        this.revisitCauseService = revisitCauseService;
        this.revisitService = revisitService;
        this.smokingService = smokingService;
        this.troponinService = troponinService;
    }

    @RequestMapping(value = "/importExcelFile", method = RequestMethod.GET)
     public void saveDataFromExcel() {
        configureRows();
    }



    private void configureRows() {
        XSSFSheet sheet = ExcelParser.parseExcelFile("path");
        if (sheet == null) {
            return;
        }
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            insertRow(rowIterator.next());
        }
    }

    private void insertRow(Row row) {
        patientService.saveOrUpdate(ObjectFromExcelFactory.createPatient(row));
//        admissionService.saveOrUpdate(ObjectFromExcelFactory.createAdmission(row));
//        anesthesiaService.saveOrUpdate(ObjectFromExcelFactory.createAnesthesia(row));
//        anestheticService.saveOrUpdate(ObjectFromExcelFactory.createAnesthetic(row));
//        complicationService.saveOrUpdate(ObjectFromExcelFactory.createComplication(row));
//        complicationDescriptionService.saveOrUpdate(ObjectFromExcelFactory.createComplicationDescription(row));
//        diseaseService.saveOrUpdate(ObjectFromExcelFactory.createDisease(row));
//        diseaseDescriptionService.saveOrUpdate(ObjectFromExcelFactory.createDiseaseDescription(row));
//        examinationService.saveOrUpdate(ObjectFromExcelFactory.createExamination(row));
//        examinationDescriptionService.saveOrUpdate(ObjectFromExcelFactory.createExaminationDescription(row));
//        medicamentService.saveOrUpdate(ObjectFromExcelFactory.createMedicament(row));
//        operationService.saveOrUpdate(ObjectFromExcelFactory.createOperation(row));
//        operationModeService.saveOrUpdate(ObjectFromExcelFactory.createOperationMode(row));
//        operationTypeService.saveOrUpdate(ObjectFromExcelFactory.createOperationType(row));
//        reoperationService.saveOrUpdate(ObjectFromExcelFactory.createReoperation(row));
//        revisitService.saveOrUpdate(ObjectFromExcelFactory.createRevisit(row));
//        revisitCauseService.saveOrUpdate(ObjectFromExcelFactory.createRevisitCause(row));
//        smokingService.saveOrUpdate(ObjectFromExcelFactory.createSmoking(row));
//        troponinService.saveOrUpdate(ObjectFromExcelFactory.createTroponin(row));
    }
}
