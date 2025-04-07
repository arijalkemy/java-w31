package com.bootcamp.sports.controllers;

import com.bootcamp.sports.dtos.PersonDto;
import com.bootcamp.sports.dtos.PersonResponseDto;
import com.bootcamp.sports.models.Person;
import com.bootcamp.sports.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person/")
public class PersonsController {
    @GetMapping("findSportsPersons/")
    public ResponseEntity<List<PersonResponseDto>> findSportsPersons() {
        List<Person> persons = PersonService.getPersons();
        return new ResponseEntity<>(
                persons.stream().map(PersonResponseDto::buildFromPerson).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Person> createPerson(@RequestBody PersonDto personDto) {
        Person person = Person.buildFromDto(personDto);
        PersonService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
}
