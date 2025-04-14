package com.bootcamp.ej_star_wars.controller;

import com.bootcamp.ej_star_wars.dto.PersonajeDTO;
import com.bootcamp.ej_star_wars.service.PersonajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {

    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PersonajeDTO>> buscarPersonajes(@RequestParam String nombre) {
        List<PersonajeDTO> personajes = personajeService.buscarPersonajes(nombre);
        return ResponseEntity.ok(personajes);
    }
}