package com.medicalsystem.controller;


import com.medicalsystem.model.Admission;
import com.medicalsystem.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @GetMapping("/admission")
    @ResponseBody
    public ResponseEntity<Admission> getAdmission(@RequestParam int id) {
        if (!admissionService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Admission admission = admissionService.getById(id);
        return new ResponseEntity<>(admission, HttpStatus.OK);

    }

    @PutMapping("/admission")
    public ResponseEntity<String> updateAdmission(@RequestParam int id, @RequestBody Admission admission) {
        admission.setId(id);
        admissionService.saveOrUpdate(admission);
        return new ResponseEntity<>("Admission successfully added", HttpStatus.OK);
    }
}
