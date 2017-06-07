package com.medicalsystem.controller;

import com.medicalsystem.ObjectFromExcelFactory;
import com.medicalsystem.excel.ExcelParser;
import com.medicalsystem.model.*;
import com.medicalsystem.service.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        XSSFSheet sheet = ExcelParser.parseExcelFile("C:\\Users\\Kamil\\SkyDrive\\Studia Semestr 6\\7 inzynierka\\baza.xlsx");
        if (sheet == null) {
            return;
        }
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        rowIterator.next();
        int i = 0;
        while (rowIterator.hasNext() && i < 2){
            insertRow(rowIterator.next());
            i++;
        }
    }

    private void insertRow(Row row) {
        Operation operation1 = ObjectFromExcelFactory.createOperation(row);
        operation1.setOperationMode(operationModeService.getById(1));
        operation1.setAnesthesia(anesthesiaService.getById(1));
        operation1.setAnesthetic(anestheticService.getById(1));
        List<Complication> complications = new ArrayList<>();
        complications.add(complicationService.getById(1));
        operation1.setComplications(complications);
        operationService.saveOrUpdate(operation1);
        patientService.saveOrUpdate(ObjectFromExcelFactory.createPatient(row));

        Admission admission = ObjectFromExcelFactory.createAdmission(row);
        List<Medicament> medicaments = new ArrayList<>(2);
        medicaments.add(medicamentService.getById(1));
        medicaments.add(medicamentService.getById(2));
        admission.setMedicaments(medicaments);

        List<OperationType> operationTypes = new ArrayList<>(2);
        operationTypes.add(operationTypeService.getById(1));
        operationTypes.add(operationTypeService.getById(2));
        admission.setOperationTypes(operationTypes);

        List<Troponin> troponins = new ArrayList<>(2);
        troponins.add(troponinService.getById(1));
        troponins.add(troponinService.getById(2));
        admission.setTroponins(troponins);

        List<Revisit> revisits = new ArrayList<>(2);
        revisits.add(revisitService.getById(admission.getId()));
        revisits.add(revisitService.getById(admission.getId()));
        admission.setRevisits(revisits);

        List<Examination> examinations = new ArrayList<>(2);
        examinations.add(examinationService.getById(admission.getId()));
        admission.setExaminations(examinations);

        admission.setSmoking(smokingService.getById((int) row.getCell(14).getNumericCellValue()));

        Reoperation reoperation = reoperationService.getById(1);
        admission.setReopration(reoperation);

        Patient patient = patientService.getById(1);
        admission.setPatient(patient);

        Operation operation = operationService.getById(1);
        admission.setOperation(operation);

        admissionService.saveOrUpdate(admission);



        anesthesiaService.saveOrUpdate(anesthesiaService.getById((int) row.getCell(8).getNumericCellValue()));


        anestheticService.saveOrUpdate(anestheticService.getById((int) row.getCell(9).getNumericCellValue()));




//        complicationService.saveOrUpdate(ObjectFromExcelFactory.createComplication(row));
//        complicationDescriptionService.saveOrUpdate(ObjectFromExcelFactory.createComplicationDescription(row));
//        diseaseService.saveOrUpdate(ObjectFromExcelFactory.createDisease(row));
//        diseaseDescriptionService.saveOrUpdate(ObjectFromExcelFactory.createDiseaseDescription(row));




        Examination examination = ObjectFromExcelFactory.createExamination(row);
//        Admission admission3 = admissionService.getById(3);
        Admission admission3 = admissionService.getById(1);
        examination.setAdmission(admission3);
        ExaminationDescription examinationDescription = examinationDescriptionService.getById(3);
        examination.setDescription(examinationDescription);
        examinationService.saveOrUpdate(examination);

//        examinationDescriptionService.saveOrUpdate(ObjectFromExcelFactory.createExaminationDescription(row)); already exist
//        medicamentService.saveOrUpdate(ObjectFromExcelFactory.createMedicament(row)); already exist







        operationModeService.saveOrUpdate(operationModeService.getById((int) row.getCell(10).getNumericCellValue()));

//        operationTypeService.saveOrUpdate(ObjectFromExcelFactory.createOperationType(row));already exist
//        reoperationService.saveOrUpdate(ObjectFromExcelFactory.createReoperation(row));



        Revisit revisit = ObjectFromExcelFactory.createRevisit(row);
//        Admission admission1 = admissionService.getById(revisit.getId());
        Admission admission1 = admissionService.getById(1);
        revisit.setAdmission(admission1);
        revisitService.saveOrUpdate(revisit);

//        revisitCauseService.saveOrUpdate(ObjectFromExcelFactory.createRevisitCause(row));
//        smokingService.saveOrUpdate(ObjectFromExcelFactory.createSmoking(row));



        smokingService.saveOrUpdate(smokingService.getById((int) row.getCell(14).getNumericCellValue()));




        Troponin troponin = ObjectFromExcelFactory.createTroponin(row);
        Admission admission2 = admissionService.getById(1);
        troponin.setAdmission(admission2);
        troponinService.saveOrUpdate(troponin);
    }
}
