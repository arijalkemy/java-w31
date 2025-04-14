package com.miprimerproyecto.pruebaspring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.miprimerproyecto.pruebaspring.dto.PersonaSportDto;
import com.miprimerproyecto.pruebaspring.dto.SportDto;
import com.miprimerproyecto.pruebaspring.service.SportService;

@RestController
public class SportController {

    SportService sportService;

    public SportController(SportService sportService){
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> getSports(){
        return ResponseEntity.ok(sportService.getSports());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Boolean> sportInList(
        @PathVariable String name
    ){
        return ResponseEntity.ok(sportService.sportInList(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaSportDto>> getPersons(){
        return ResponseEntity.ok(sportService.getPersons());
    }


}
