package com.bootcamp.deportista_dto.controller;

import com.bootcamp.deportista_dto.dtos.DeportistasDto;
import com.bootcamp.deportista_dto.entity.Deporte;
import com.bootcamp.deportista_dto.services.DeportistasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {


    private final DeportistasService deportistasService;


    public DeportistasController(DeportistasService deportistasService) {
        this.deportistasService = deportistasService;
    }


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return new ResponseEntity<>(deportistasService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        String nivel = deportistasService.findSport(name);
        if (nivel == null) {
            return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deportistasService.findSport(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistasDto>> findSportsPersons() {
        return new ResponseEntity<>(deportistasService.findSportByPerson(), HttpStatus.OK);
    }
}
