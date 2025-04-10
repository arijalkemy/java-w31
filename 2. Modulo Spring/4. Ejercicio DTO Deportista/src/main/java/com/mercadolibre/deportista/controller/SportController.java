package com.mercadolibre.deportista.controller;

import com.mercadolibre.deportista.dto.PersonDTO;
import com.mercadolibre.deportista.dto.SportDTO;
import com.mercadolibre.deportista.model.Sport;
import com.mercadolibre.deportista.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping("/findSports")
    public List<SportDTO> getAllSports() {
        return sportService.getAllSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> getSportByName(@PathVariable String name) {
        Sport sport = sportService.getSportByName(name);
        if (sport != null) {
            return ResponseEntity.ok(sport);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findSportsPersons")
    public List<PersonDTO> getAllSportPersons() {
        return sportService.getAllSportPersons();
    }
}
