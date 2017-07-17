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

    private final AdmissionService admissionService;
    private final ExaminationService examinationService;

    @GetMapping("api/patients/{id}/examinations")
    public ResponseEntity<List<Examination>> getExaminations(@PathVariable int id) {
        Admission admission = admissionService.getByPatientId(id);

        if (admission == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(admission.getExaminations(), HttpStatus.OK);
    }


    @PutMapping("api/patients/{id}/examinations")
    public ResponseEntity<?> updateExaminations(@PathVariable int id, @RequestBody List<Examination> examinations) {
        Admission admission = admissionService.getByPatientId(id);

        if (admission == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        /* Delete old examinations */
        admission.getExaminations().forEach(e -> {
            e.setAdmission(null);
            examinationService.delete(e.getId());
        });

        /* Set up new examinations */
        admission.setExaminations(examinations);
        examinations.forEach(e -> e.setAdmission(admission));

        /* Update admission */
        admissionService.saveOrUpdate(admission);

        return new ResponseEntity<>(examinations, HttpStatus.OK);
    }




}
