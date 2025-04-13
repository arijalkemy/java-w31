package com.example.deportistas.controller;

import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.service.DeportistasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class DeportistasController {

    @GetMapping("findSports")
    public String findSports() {
        return DeportistasService.findSports();
    }

    @GetMapping("findSports/{sport}")
    public ResponseEntity findSpecificSport(@PathVariable String sport) {
        return DeportistasService.findSpecificSport(sport);
    }

    @GetMapping("findSportsPersons")
    public Stream<DeportistaDto> findSportsPersons() {
        return DeportistasService.findSportsPersons();
    }
}
