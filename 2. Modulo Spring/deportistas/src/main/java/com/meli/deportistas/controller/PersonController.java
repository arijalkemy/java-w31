package com.meli.deportistas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.meli.deportistas.dto.PersonDTO;
import com.meli.deportistas.service.PersonService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> getPersons() {
        return ResponseEntity.ok(personService.getPersonsAndSports());
    }

}
