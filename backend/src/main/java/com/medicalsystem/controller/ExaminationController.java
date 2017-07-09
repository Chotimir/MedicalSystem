package com.medicalsystem.controller;

import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Examination;
import com.medicalsystem.service.AdmissionService;
import com.medicalsystem.service.ExaminationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExaminationController {

    private AdmissionService admissionService;

    @GetMapping("/admission/{admissionId}/examinations")
    public ResponseEntity<List<Examination>> getExaminations(@PathVariable("admissionId") int id) {
        if (!admissionService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Examination> examinations = admissionService.getById(id).getExaminations();
        return new ResponseEntity<>(examinations, HttpStatus.OK);
    }


    @PutMapping("/admission/{admissionId}/examinations")
    public ResponseEntity<String> updateExaminations(@RequestBody Examination examination, @PathVariable("admissionId") int id) {
        Admission admission = admissionService.getById(id);
        List<Examination> examinations = admission.getExaminations();
        examinations.add(examination);
        admission.setExaminations(examinations);

        admissionService.saveOrUpdate(admission);

        return new ResponseEntity<>("Examination successfully added", HttpStatus.OK);
    }




}
