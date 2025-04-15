package co.com.mercadolibre.practicadeportistas.practicadeportistas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.practicadeportistas.practicadeportistas.dto.PersonDto;
import co.com.mercadolibre.practicadeportistas.practicadeportistas.service.PersonService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDto>> getMethodName() {
        return ResponseEntity.ok().body(personService.findSportsPersons());
    }
}
