package com.medicalsystem.controller;

import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.service.DiseaseDescriptionService;
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
public class DiseaseDescriptionController {

    @Autowired
    private DiseaseDescriptionService diseaseDescriptionService;

    @RequestMapping(value = "/diseasesDescription", method = RequestMethod.GET)
    public List<?> getDiseasesDescription() {
        return diseaseDescriptionService.listAll();
    }

    @RequestMapping(value = "/addDiseaseDescription", method = RequestMethod.POST)
    public DiseaseDescription saveDiseaseDescription(@RequestBody DiseaseDescription diseaseDescription) {
        return diseaseDescriptionService.saveOrUpdate(diseaseDescription);
    }
}
