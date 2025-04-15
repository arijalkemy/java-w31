package co.com.mercadolibre.diecinueve.coviddiecinueve.controller;

import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.diecinueve.coviddiecinueve.dto.PersonDto;
import co.com.mercadolibre.diecinueve.coviddiecinueve.services.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDto>> findCommonSymptomsOnPersonOverSixtyYears( ) {
        return ResponseEntity.ok().body(personService.findCommonSymptomsOnPersonOverSixtyYears())
    }
}
