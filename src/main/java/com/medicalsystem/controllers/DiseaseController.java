package com.medicalsystem.controllers;

import com.medicalsystem.domain.Disease;
import com.medicalsystem.services.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kamil Komenda
 */
@RestController
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @RequestMapping(value = "/disease", method = RequestMethod.GET)
    public List<?> getDiseases() {
        return diseaseService.listAll();
    }

    @RequestMapping(value = "/addDisease", method = RequestMethod.POST)
    public Disease saveDisease(@RequestBody Disease disease) {
        return diseaseService.saveOrUpdate(disease);
    }
}
