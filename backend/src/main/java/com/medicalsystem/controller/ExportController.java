package com.medicalsystem.controller;

import com.medicalsystem.excel.export.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExportController {

    @Autowired
    private ExcelExporter excelExporter;

    @GetMapping("/export")
    public ResponseEntity<?> exportToExcel() {
        excelExporter.exportToExcel();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
