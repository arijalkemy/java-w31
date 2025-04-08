package com.bootcamp.sports.controllers;

import com.bootcamp.sports.dtos.PersonDto;
import com.bootcamp.sports.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/")
public class PersonsController {
    @GetMapping("findSportsPersons/")
    public ResponseEntity<List<PersonDto>> findSportsPersons() {
        List<PersonDto> persons = PersonService.getPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        PersonDto result = PersonService.addPerson(personDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
