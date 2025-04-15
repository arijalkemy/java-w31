package com.bootcamp.ejercicio_deportistas.controller;

import com.bootcamp.ejercicio_deportistas.dto.PersonSportDto;
import com.bootcamp.ejercicio_deportistas.dto.SportDto;
import com.bootcamp.ejercicio_deportistas.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sports")
public class SportController {
    @Autowired
    private ISportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> getAllSports(){
        return new ResponseEntity<>(sportService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<SportDto> getSportByName(@PathVariable String name){
        return new ResponseEntity<>(sportService.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonSportDto>> getPersonSport(){
        return new ResponseEntity<>(sportService.getSportPersons(), HttpStatus.OK);
    }
}
