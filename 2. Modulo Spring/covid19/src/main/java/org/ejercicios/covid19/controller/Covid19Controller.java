package org.ejercicios.covid19.controller;

import org.ejercicios.covid19.dto.PersonaDTO;
import org.ejercicios.covid19.dto.SintomaDTO;
import org.ejercicios.covid19.service.Covid19Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Covid19Controller {

    private Covid19Service service;

    public Covid19Controller(Covid19Service service) {
        this.service = service;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getAllSymptoms() {
        return new ResponseEntity<>(service.getSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> getSymptomByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getSintomaByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getPeopleAtRisk() {
        return new ResponseEntity<>(service.getPersonasInRisk(), HttpStatus.OK);
    }
}
