package com.mercadolibre.covid.controller;

import com.mercadolibre.covid.dto.RiskPersonDTO;
import com.mercadolibre.covid.model.Symptom;
import com.mercadolibre.covid.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("/findSymptom")
    public List<Symptom> getAllSymptoms() {
        return healthService.getAllSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Symptom> getSymptomByName(@PathVariable String name) {
        Symptom symptom = healthService.getSymptomByName(name);
        if (symptom != null) {
            return ResponseEntity.ok(symptom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findRiskPerson")
    public List<RiskPersonDTO> getRiskPersons() {
        return healthService.getRiskPersons();
    }
}
