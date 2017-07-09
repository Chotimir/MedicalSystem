package com.medicalsystem.controller;


import com.medicalsystem.model.Admission;
import com.medicalsystem.service.AdmissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdmissionController {

    private AdmissionService admissionService;

    @GetMapping("/admission/{admissionId}")
    public ResponseEntity<Admission> getAdmission(@PathVariable("admissionId") int id) {
        if (!admissionService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Admission admission = admissionService.getById(id);
        return new ResponseEntity<>(admission, HttpStatus.OK);
    }


    @PutMapping("/admission")
    public ResponseEntity<String> updateAdmission(@RequestBody Admission admission) {
        admissionService.saveOrUpdate(admission);
        return new ResponseEntity<>("Admission successfully added", HttpStatus.OK);
    }
}
