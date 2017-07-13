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

    @GetMapping("api/operation/{id}/complicatons")
    public ResponseEntity<List<Complication>> getComplications(@PathVariable int id) {
        Operation operation = operationService.getById(id);

        if (operation == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(operation.getComplications(), HttpStatus.OK);
    }

    @PutMapping("api/operation/{id}/complications")
    public ResponseEntity<List<Complication>> updateComplications(@RequestBody Complication complication, @PathVariable int id) {
        Operation operation = operationService.getById(id);

        if (operation == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Complication> complications = operation.getComplications();
        complications.add(complication);

        operationService.saveOrUpdate(operation);

        return new ResponseEntity<>(complications, HttpStatus.OK);
    }
}
