package com.bootcamp.ejerciciocovid19.controller;

import com.bootcamp.ejerciciocovid19.dto.SymptomDto;
import com.bootcamp.ejerciciocovid19.exception.NotFoundException;
import com.bootcamp.ejerciciocovid19.service.ISymptomService;
import com.bootcamp.ejerciciocovid19.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {
    @Autowired
    ISymptomService symptomService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> allSymptoms(){
        return new ResponseEntity<>(symptomService.allSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> findSymptom(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<>(symptomService.findSymptom(name), HttpStatus.OK);
    }
}
