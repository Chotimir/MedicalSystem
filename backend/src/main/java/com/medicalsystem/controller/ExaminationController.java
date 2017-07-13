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

    @GetMapping("api/admission/{id}/examinations")
    public ResponseEntity<List<Examination>> getExaminations(@PathVariable int id) {
        Admission admission = admissionService.getById(id);

        if (admission == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(admission.getExaminations(), HttpStatus.OK);
    }


    @PutMapping("api/admission/{id}/examinations")
    public ResponseEntity<List<Examination>> updateExaminations(@RequestBody Examination examination, @PathVariable int id) {
        Admission admission = admissionService.getById(id);

        if (admission == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Examination> examinations = admission.getExaminations();
        examinations.add(examination);

        admissionService.saveOrUpdate(admission);

        return new ResponseEntity<>(examinations, HttpStatus.OK);
    }




}
