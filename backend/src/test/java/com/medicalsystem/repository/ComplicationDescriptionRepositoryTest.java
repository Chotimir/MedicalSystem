package com.medicalsystem.repository;

import com.medicalsystem.model.Complication;
import com.medicalsystem.model.ComplicationDescription;
import com.medicalsystem.service.ComplicationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplicationDescriptionRepositoryTest {

    @Autowired
    private ComplicationDescriptionRepository repository;

    @Autowired
    private ComplicationService complicationService;

    @Test
    public void findByComplicationAndExcelValueTest() {
        Complication complication = complicationService.getById(17);
        int excelValue = 1;

        ComplicationDescription complicationDescription = repository.findByComplicationAndExcelValue(complication, excelValue);

        Assert.assertNotNull(complicationDescription);
    }

}
