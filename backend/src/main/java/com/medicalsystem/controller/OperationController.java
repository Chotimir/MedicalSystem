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


    @GetMapping("/admission/{admissionId}/operation")
    public ResponseEntity<Operation> getOperation(@PathVariable("admissionId") int id) {
        if (!admissionService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Operation operation = admissionService.getById(id).getOperation();
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PutMapping("/admission/{admissionId}/operation")
    public ResponseEntity<String> updateOperation(@RequestBody Operation operation, @PathVariable("admissionId") int id) {
        if (!admissionService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Admission admission = admissionService.getById(id);
        admission.setOperation(operation);
        admissionService.saveOrUpdate(admission);

        return new ResponseEntity<>("Operation successfully added", HttpStatus.OK);
    }
}
