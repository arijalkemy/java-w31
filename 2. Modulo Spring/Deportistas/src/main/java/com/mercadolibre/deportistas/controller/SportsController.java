package com.mercadolibre.deportistas.controller;

import com.mercadolibre.deportistas.Dto.PersonDTO;
import com.mercadolibre.deportistas.Dto.SportDTo;
import com.mercadolibre.deportistas.model.Sport;
import com.mercadolibre.deportistas.services.PersonSportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SportsController {
    private final PersonSportService personSportService;

    @GetMapping("/ObtenerDeportes")
    public ResponseEntity<List<Sport>> getSports() {
        return ResponseEntity.ok(personSportService.getAllSports());
    }

    @GetMapping("/ObtenerDeporte")
    public ResponseEntity<SportDTo> getSportById(@RequestParam String name) {
        return ResponseEntity.ok(personSportService.getSportByName(name));
    }

    @GetMapping("/ObtenerPersonasDeportes")
    public ResponseEntity<List<PersonDTO>> getPersonsBySport() {
        return ResponseEntity.ok(personSportService.getPersonSportByName());
    }
}
