package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(personajeService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No se encontró ningun personaje en el sistema.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/personajes/{name}")
    public ResponseEntity<?> getPersonaje(@PathVariable String name) {
        try {
            return new ResponseEntity<>(personajeService.findByName(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No se encontró ningún personaje con ese nombre.", HttpStatus.NOT_FOUND);
        }
    }
}
