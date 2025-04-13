package com.mercadolibre.covid.controller;

import com.mercadolibre.covid.dto.PersonaEnRiesgoDto;
import com.mercadolibre.covid.service.CovidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class CovidController {

    @GetMapping("findSymptom")
    public String findSymptom() {
        return CovidService.findSymptom();
    }

    @GetMapping("findSymptom/{symptom}")
    public ResponseEntity findSpecificSymptom(@PathVariable String symptom) {
        return CovidService.findSpecificSymptom(symptom);
    }

    @GetMapping("findRiskPerson")
    public Stream<PersonaEnRiesgoDto> findRiskPerson() {
        return CovidService.findRiskPerson();
    }
}
