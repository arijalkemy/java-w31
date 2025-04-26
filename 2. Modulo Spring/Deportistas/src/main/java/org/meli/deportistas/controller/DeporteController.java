package org.meli.deportistas.controller;

import lombok.RequiredArgsConstructor;
import org.meli.deportistas.dto.PersonaDeportistaDTO;
import org.meli.deportistas.model.entity.Deporte;
import org.meli.deportistas.service.DeporteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeporteController {

    private final DeporteServiceImpl deporteServiceImpl;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllSports() {
        List<Deporte> deportes = deporteServiceImpl.getAllSports();
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getSportByName(@PathVariable String name) {
        return deporteServiceImpl.getSportByName(name)
                .map(deporte -> ResponseEntity.ok("Nivel del deporte: " + deporte.getNivel()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El deporte con nombre '" + name + "' no fue encontrado"));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> getAllSportsPersons() {
        List<PersonaDeportistaDTO> personaDeportistaDTOS = deporteServiceImpl.getPersonasDeportistas();
        return new ResponseEntity<>(personaDeportistaDTOS, HttpStatus.OK);
    }
}