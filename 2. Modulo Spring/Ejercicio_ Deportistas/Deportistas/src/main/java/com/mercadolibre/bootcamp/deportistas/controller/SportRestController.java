package com.mercadolibre.bootcamp.deportistas.controller;

import com.mercadolibre.bootcamp.deportistas.dto.AthleteDto;
import com.mercadolibre.bootcamp.deportistas.model.Sport;
import com.mercadolibre.bootcamp.deportistas.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportRestController {

    private SportService sportService;

    @Autowired
    public SportRestController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findAllSports() {
        List<Sport> sports = sportService.getSports();
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> findSportByName(@PathVariable String name) {
        Sport sport = sportService.getSportByName(name);
        return new ResponseEntity<>(sport, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<AthleteDto>> findAllSportsPersons() {
        List<AthleteDto> athleteDtos = sportService.getAthletes();
        return new ResponseEntity<>(athleteDtos, HttpStatus.OK);
    }

}
