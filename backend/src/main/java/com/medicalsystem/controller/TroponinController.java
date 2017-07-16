package com.medicalsystem.controller;

import com.medicalsystem.model.Troponin;
import com.medicalsystem.service.TroponinService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TroponinController {

    private final TroponinService troponinService;

    @GetMapping("api/patients/{id}/troponins")
    public ResponseEntity<?> getTroponins(@PathVariable int id) {
        Troponin troponin = troponinService.getByPatientId(id);

        if (troponin == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(troponin, HttpStatus.OK);
    }

    @PutMapping("api/patients/{id}/troponins")
    public ResponseEntity<?> updateTroponins(@PathVariable int id, @RequestBody Troponin troponin) {
        Troponin currentTroponin = troponinService.getByPatientId(id);

        if (currentTroponin == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        currentTroponin.setTnt(troponin.getTnt());
        currentTroponin.setTnlUltra(troponin.getTnlUltra());
        currentTroponin.setTnl(troponin.getTnl());
        currentTroponin.setTnlAfter24h(troponin.getTnlAfter24h());
        currentTroponin.setTntAfter24h(troponin.getTntAfter24h());

        currentTroponin = troponinService.saveOrUpdate(currentTroponin);

        return new ResponseEntity<>(currentTroponin, HttpStatus.OK);
    }

}
