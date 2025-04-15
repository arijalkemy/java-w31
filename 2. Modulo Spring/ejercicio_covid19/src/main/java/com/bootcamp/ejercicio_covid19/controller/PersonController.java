package com.bootcamp.ejercicio_covid19.controller;

import com.bootcamp.ejercicio_covid19.dto.PersonDto;
import com.bootcamp.ejercicio_covid19.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDto>> getRiskPersons(){
        return new ResponseEntity<>(personService.getRiskPersons(), HttpStatus.OK);
    }
}
