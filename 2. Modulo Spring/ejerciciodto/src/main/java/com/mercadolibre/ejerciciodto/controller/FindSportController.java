package com.mercadolibre.ejerciciodto.controller;

import com.mercadolibre.ejerciciodto.entidades.Sport;
import com.mercadolibre.ejerciciodto.service.FindSportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FindSportController {
    private FindSportService service;
    public FindSportController(FindSportService service){
        this.service = service;
    }

    @GetMapping("/findSports")
    public List<Sport> getSports() {
        return this.service.getSports();
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getSportByName(@PathVariable String name){
       return new ResponseEntity<>(this.service.getSportLevel(name), HttpStatus.OK) ;
    }

    @GetMapping("/findSportsPersons")
    public List<String> getSportyPeople(){
      return this.service.getSportyPeople();
    }

    @PostMapping("/createSport")
    public ResponseEntity<String> createSport(@RequestBody Sport sport) {
        service.save(sport);
        return new ResponseEntity<>("Deporte creado", HttpStatus.CREATED);
    }

}
