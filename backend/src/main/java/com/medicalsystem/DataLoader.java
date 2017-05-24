package com.medicalsystem;

import com.medicalsystem.model.*;
import com.medicalsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final OperationTypeService operationTypeService;
    private final AnesthesiaService anesthesiaService;
    private final AnestheticService anestheticService;
    private final OperationModeService operationModeService;
    private final SmokingService smokingService;
    private final DiseaseService diseaseService;

    @Autowired
    public DataLoader(OperationTypeService operationTypeService, AnesthesiaService anesthesiaService, AnestheticService anestheticService, OperationModeService operationModeService, SmokingService smokingService, DiseaseService diseaseService) {
        this.operationTypeService = operationTypeService;
        this.anesthesiaService = anesthesiaService;
        this.anestheticService = anestheticService;
        this.operationModeService = operationModeService;
        this.smokingService = smokingService;
        this.diseaseService = diseaseService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        // rodzaj_zabiegu_s
        operationTypeService.saveOrUpdate(new OperationType(1, "Otwarta operacja wycięcia tętniaka aorty brzusznej"));
        operationTypeService.saveOrUpdate(new OperationType(2, "Endowaskularne zaopatrzenie tętniaka aorty (EVAR)"));
        operationTypeService.saveOrUpdate(new OperationType(3, "Przęsło aortalno dwuudowe (ABF)"));
        operationTypeService.saveOrUpdate(new OperationType(4, "Przęsło aortalno-udowe"));
        operationTypeService.saveOrUpdate(new OperationType(5, "Przęsło aortalno-biodrowe"));
        operationTypeService.saveOrUpdate(new OperationType(6, "Przęsło aortalno-dwubiodrowe"));
        operationTypeService.saveOrUpdate(new OperationType(7, "Plastyka aorty"));

        // znieczulenie_s
        anesthesiaService.saveOrUpdate(new Anesthesia(1, "Ogólne"));
        anesthesiaService.saveOrUpdate(new Anesthesia(2, "Miejscowe"));
        anesthesiaService.saveOrUpdate(new Anesthesia(3, "Podpajęczynówkowe"));
        anesthesiaService.saveOrUpdate(new Anesthesia(4, "Ogólne plus zewnątrzoponowe"));
        anesthesiaService.saveOrUpdate(new Anesthesia(5, "Ogólne plus podpajęczynówkowe"));

        // lek_znieczulajacy_s
        anestheticService.saveOrUpdate(new Anesthetic(1, "Propofol"));
        anestheticService.saveOrUpdate(new Anesthetic(2, "Etomidat"));
        anestheticService.saveOrUpdate(new Anesthetic(3, "Tiopental"));
        anestheticService.saveOrUpdate(new Anesthetic(4, "Ketamina"));
        anestheticService.saveOrUpdate(new Anesthetic(5, "brak danych/nic"));

        // tryb_zabiegu_s
        operationModeService.saveOrUpdate(new OperationMode(1, "Planowy"));
        operationModeService.saveOrUpdate(new OperationMode(2, "Pilny/Naglący"));

        // palenie_tytoniu_s
        smokingService.saveOrUpdate(new Smoking(0, "nie palący"));
        smokingService.saveOrUpdate(new Smoking(1, "palący"));
        smokingService.saveOrUpdate(new Smoking(2, "palący w przeszłości"));

        // choroby_s
        diseaseService.saveOrUpdate(new Disease(1, "HT"));
        diseaseService.saveOrUpdate(new Disease(2, "CAD"));
        diseaseService.saveOrUpdate(new Disease(3, "CAD wysokiego ryzyka"));
        diseaseService.saveOrUpdate(new Disease(4, "MI/ACS przebyty"));
        diseaseService.saveOrUpdate(new Disease(5, "Stenoza aortalna"));
        diseaseService.saveOrUpdate(new Disease(6, "CVE przebyty"));
        diseaseService.saveOrUpdate(new Disease(7, "CHF"));
        diseaseService.saveOrUpdate(new Disease(8, "DM"));
        diseaseService.saveOrUpdate(new Disease(9, "COPD"));
        diseaseService.saveOrUpdate(new Disease(10, "EKG przymęciowe"));
    }
}
