package com.spring.ejerciciodeportistas.controller;

import com.spring.ejerciciodeportistas.model.Sport;
import com.spring.ejerciciodeportistas.model.SportPersonDTO;
import com.spring.ejerciciodeportistas.service.PersonService;
import com.spring.ejerciciodeportistas.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private final SportService sportService;
    private final PersonService personService;

    @Autowired
    public Controller(SportService sportService, PersonService personService) {
        this.sportService = sportService;
        this.personService = personService;
    }

    @GetMapping("/findSports")
    public List<Sport> findSports() {
        return sportService.getSports();
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Sport> findSportByName(@PathVariable("name") String name) {
        return sportService.findSportByName(name);
    }

    @GetMapping("/findSportsPerson")
    public List<SportPersonDTO> findSportsPerson() {
        return personService.getSportsPerson();
    }
}
