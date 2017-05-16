package com.medicalsystem.controllers;

import com.medicalsystem.domain.Comorbidities;
import com.medicalsystem.services.ComorbiditiesService;
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
public class ComorbiditiesController {

    @Autowired
    private ComorbiditiesService comorbiditiesService;

    @RequestMapping(value = "/comorbidities", method = RequestMethod.GET)
    public List<?> getComorbidities() {
        return comorbiditiesService.listAll();
    }

    @RequestMapping(value = "/addComorbidities", method = RequestMethod.POST)
    public Comorbidities saveComorbidities(@RequestBody Comorbidities comorbidities) {
        return comorbiditiesService.saveOrUpdate(comorbidities);
    }
}
