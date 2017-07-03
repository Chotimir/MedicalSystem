package com.medicalsystem.controller;

import com.medicalsystem.excel.ExcelImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportController {

    private final ExcelImporter excelImporter;

    @Autowired
    public ImportController(ExcelImporter excelImporter) {
        this.excelImporter = excelImporter;
    }

    @GetMapping("/import")
    public ResponseEntity<?> importToDB() {
        excelImporter.importToDB();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
