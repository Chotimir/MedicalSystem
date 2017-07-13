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

    @GetMapping("api/admission/{id}")
    public ResponseEntity<Admission> getAdmission(@PathVariable int id) {
        Admission admission = admissionService.getById(id);

        if (admission == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(admission, HttpStatus.OK) ;
    }


    @PutMapping("api/admission")
    public ResponseEntity<?> updateAdmission(@RequestBody Admission admission) {
        admission = admissionService.saveOrUpdate(admission);

        if (admission == null)
            return new ResponseEntity<>("Error saving admission", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(admission, HttpStatus.OK);
    }
}
