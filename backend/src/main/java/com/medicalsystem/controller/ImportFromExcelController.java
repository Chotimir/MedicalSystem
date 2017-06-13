package com.medicalsystem.controller;

import com.medicalsystem.excel.SaveDataFromExcelToDB;
import com.medicalsystem.excel.XlsxExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportFromExcelController {

    @Autowired
    SaveDataFromExcelToDB saveDataFromExcelToDB;

    @Autowired
    XlsxExport export;

    @RequestMapping(value = "/importExcelFile", method = RequestMethod.GET)
     public void saveDataFromExcel() {
        saveDataFromExcelToDB.configureRows();
        export.exportToExcel();
    }

}
