package com.mercadolibre.ejerciciocovid.controller;

import com.mercadolibre.ejerciciocovid.entity.PersonDTO;
import com.mercadolibre.ejerciciocovid.entity.Symptom;
import com.mercadolibre.ejerciciocovid.service.CovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    private CovidService service = new CovidService();
    public CovidController(CovidService service){
        this.service = service;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> getSymptoms (){
        return new ResponseEntity<>(this.service.getSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getLevelOfGravityOfSymptomByName(@PathVariable String name){
        return new ResponseEntity<>(this.service.getGravityOfSymptomByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDTO>> getRiskPerson(){
        return new ResponseEntity<>(this.service.getRiskPerson(), HttpStatus.OK);
    }
}
