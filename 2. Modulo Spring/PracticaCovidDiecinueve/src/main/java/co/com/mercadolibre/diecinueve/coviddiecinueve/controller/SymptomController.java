package co.com.mercadolibre.diecinueve.coviddiecinueve.controller;

import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.diecinueve.coviddiecinueve.dto.SymptomDto;
import co.com.mercadolibre.diecinueve.coviddiecinueve.services.SymptomService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SymptomController {

    private final SymptomService symptomService;

    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> findAll() {
        return ResponseEntity.ok().body(symptomService.findAllSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(symptomService.findSypmtomSeverityByName(name));
    }
    
    
}
