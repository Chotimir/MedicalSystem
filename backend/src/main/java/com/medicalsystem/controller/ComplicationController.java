package com.medicalsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Complication;
import com.medicalsystem.model.Operation;
import com.medicalsystem.json.serializer.SelectField;
import com.medicalsystem.json.serializer.SelectFieldBuilder;
import com.medicalsystem.service.AdmissionService;
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

    private final AdmissionService admissionService;
    private final OperationService operationService;

    private final SelectFieldBuilder selectFieldBuilder;

    // TODO: do przepisania metoda bo brzydko
    @GetMapping("api/patients/{id}/complications")
    public String getComplications(@PathVariable int id) throws JsonProcessingException {
        Admission admission = admissionService.getByPatientId(id);

        if (admission == null)
            return "NOT FOUND";

        List<Complication> complications = admission.getOperation().getComplications();
        List<SelectField> selectFields = selectFieldBuilder.fromComplications(complications);

        return new ObjectMapper().writeValueAsString(selectFields);
    }

    @PutMapping("api/patients/{id}/complications")
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
