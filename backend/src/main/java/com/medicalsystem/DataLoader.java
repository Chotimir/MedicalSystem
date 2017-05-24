package com.medicalsystem;

import com.medicalsystem.model.OperationType;
import com.medicalsystem.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final OperationTypeService operationTypeService;

    @Autowired
    public DataLoader(OperationTypeService operationTypeService) {
        this.operationTypeService = operationTypeService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        operationTypeService.saveOrUpdate(new OperationType(1, "Otwarta operacja wycięcia tętniaka aorty brzusznej"));
        operationTypeService.saveOrUpdate(new OperationType(2, "Endowaskularne zaopatrzenie tętniaka aorty (EVAR)"));
        operationTypeService.saveOrUpdate(new OperationType(3, "Przęsło aortalno dwuudowe (ABF)"));
        operationTypeService.saveOrUpdate(new OperationType(4, "Przęsło aortalno-udowe"));
        operationTypeService.saveOrUpdate(new OperationType(5, "Przęsło aortalno-biodrowe"));
        operationTypeService.saveOrUpdate(new OperationType(6, "Przęsło aortalno-dwubiodrowe"));
        operationTypeService.saveOrUpdate(new OperationType(7, "Plastyka aorty"));
    }
}
