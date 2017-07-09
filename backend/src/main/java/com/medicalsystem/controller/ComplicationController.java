package com.medicalsystem.controller;

import com.medicalsystem.model.Complication;
import com.medicalsystem.model.Operation;
import com.medicalsystem.service.ComplicationService;
import com.medicalsystem.service.OperationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComplicationController {

    private OperationService operationService;

    @GetMapping("/operation/{operationId}/complicatons")
    public ResponseEntity<List<Complication>> getComplications(@PathVariable("operationId") int id) {
        if (!operationService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Complication> complications = operationService.getById(id).getComplications();
        return new ResponseEntity<>(complications, HttpStatus.OK);
    }

    @PutMapping("/operation/{operationId}/complications")
    public ResponseEntity<String> updateComplications(@RequestBody Complication complication, @PathVariable("operationId") int id) {
        if (!operationService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Operation operation = operationService.getById(id);
        List<Complication> complications = operation.getComplications();
        complications.add(complication);
        operation.setComplications(complications);

        operationService.saveOrUpdate(operation);

        return new ResponseEntity<>("Complication successfully added", HttpStatus.OK);
    }
}
