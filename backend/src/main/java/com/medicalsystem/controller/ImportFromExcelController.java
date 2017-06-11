package com.medicalsystem.controller;

import com.medicalsystem.excel.SaveDataFromExcelToDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportFromExcelController {

    @Autowired
    SaveDataFromExcelToDB saveDataFromExcelToDB;

    @RequestMapping(value = "/importExcelFile", method = RequestMethod.GET)
     public void saveDataFromExcel() {
        saveDataFromExcelToDB.configureRows();
    }

}
