package com.medicalsystem.controller;

import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Operation;
import com.medicalsystem.service.AdmissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationController {

    private AdmissionService admissionService;


    @GetMapping("api/admission/{id}/operation")
    public ResponseEntity<Operation> getOperation(@PathVariable int id) {
        Admission admission = admissionService.getById(id);

        if (admission == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(admission.getOperation(), HttpStatus.OK);
    }

    @PutMapping("api/admission/{id}/operation")
    public ResponseEntity<Operation> updateOperation(@RequestBody Operation operation, @PathVariable int id) {
        Admission admission = admissionService.getById(id);

        if (admission == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        admission.setOperation(operation);

        admissionService.saveOrUpdate(admission);

        return new ResponseEntity<>(operation, HttpStatus.OK);
    }
}
