package com.bootcamp.ejerciciodeportistas.controller;

import com.bootcamp.ejerciciodeportistas.dto.PersonDto;
import com.bootcamp.ejerciciodeportistas.dto.SportDto;
import com.bootcamp.ejerciciodeportistas.entity.Sport;
import com.bootcamp.ejerciciodeportistas.service.IPersonService;
import com.bootcamp.ejerciciodeportistas.service.ISportService;
import com.bootcamp.ejerciciodeportistas.service.PersonService;
import com.bootcamp.ejerciciodeportistas.service.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SportController {
    IPersonService personaService;
    ISportService sportService;

    public SportController(PersonService personaService, SportService sportService){
        this.personaService = personaService;
        this.sportService = sportService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> getPersonas(){
        return new ResponseEntity<>(personaService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> getAllSports(){
        return new ResponseEntity<>(sportService.allSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport")
    public ResponseEntity<SportDto> findSport(@RequestParam String name){
        return new ResponseEntity<>(sportService.findSport(name), HttpStatus.OK);
    }


}
