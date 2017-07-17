package com.medicalsystem.controller;

import com.medicalsystem.excel.export.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class ExportController {

    /**
     * Temporary method
     * @return hard-coded excel file
     */
//    @GetMapping("api/export")
//    public ResponseEntity<?> exportToExcel() throws IOException {
//        File file = new File("baza2.xlsx");
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//
//        return ResponseEntity.ok()
//                .contentLength(file.length())
//                .contentType(MediaType.parseMediaType("application/octet-stream"))
//                .body(resource);
//    }

    @Autowired
    private ExcelExporter excelExporter;

    @GetMapping("/export")
    public ResponseEntity<?> exportToExcel() {
        excelExporter.exportToExcel();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
