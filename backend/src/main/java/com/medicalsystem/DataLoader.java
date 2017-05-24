package com.medicalsystem;

import com.medicalsystem.model.*;
import com.medicalsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private final OperationTypeService operationTypeService;
    private final AnesthesiaService anesthesiaService;
    private final AnestheticService anestheticService;
    private final OperationModeService operationModeService;
    private final SmokingService smokingService;
    private final DiseaseService diseaseService;
    private final DiseaseDescriptionService diseaseDescriptionService;

    @Autowired
    public DataLoader(OperationTypeService operationTypeService, AnesthesiaService anesthesiaService, AnestheticService anestheticService, OperationModeService operationModeService, SmokingService smokingService, DiseaseService diseaseService, DiseaseDescriptionService diseaseDescriptionService) {
        this.operationTypeService = operationTypeService;
        this.anesthesiaService = anesthesiaService;
        this.anestheticService = anestheticService;
        this.operationModeService = operationModeService;
        this.smokingService = smokingService;
        this.diseaseService = diseaseService;
        this.diseaseDescriptionService = diseaseDescriptionService;
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
        Disease[] diseases = {
                new Disease(1, "HT"),
                new Disease(2, "CAD"),
                new Disease(3, "CAD wysokiego ryzyka"),
                new Disease(4, "MI/ACS przebyty"),
                new Disease(5, "Stenoza aortalna"),
                new Disease(6, "CVE przebyty"),
                new Disease(7, "CHF"),
                new Disease(8, "DM"),
                new Disease(9, "COPD"),
                new Disease(10, "EKG przymęciowe")
        };

        for (Disease disease : diseases) {
            diseaseService.saveOrUpdate(disease);
        }

        // opis_choroby_s
        // HT
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(1, diseases[0], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(2, diseases[0], "tak"));
        // CAD
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(3, diseases[1], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(4, diseases[1], "tak"));
        // CAD wysokiego ryzyka
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(5, diseases[2], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(6, diseases[2], "tak"));
        // MI/ACS
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(7, diseases[3], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(8, diseases[3], "tak"));
        // Stenoza aortalna
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(9, diseases[4], "brak"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(10, diseases[4], "łagodna"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(11, diseases[4], "umiarkowana"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(12, diseases[4], "ciężka"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(13, diseases[4], "sztuczna zastawka"));
        // CVE przebyty
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(14, diseases[5], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(15, diseases[5], "tak"));
        // CHF
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(16, diseases[6], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(17, diseases[6], "tak"));
        // DM
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(18, diseases[7], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(19, diseases[7], "tak"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(20, diseases[7], "w trakcie insulinoterapii"));
        // COPD
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(21, diseases[8], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(22, diseases[8], "tak"));
        // EKG
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(23, diseases[9], "rytm zatokowy"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(24, diseases[9], "AF"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(25, diseases[9], "rytm zatokowy + obecność VE"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(26, diseases[9], "AF + obecność VE"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(27, diseases[9], "rytm z rozrusznika"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(28, diseases[9], "AF + rytm z rozrusznika"));
    }
}
