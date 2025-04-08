package com.bootcamp.ejercicio_starwars.controller;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDto;
import com.bootcamp.ejercicio_starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    private IPersonajeService characterService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDto>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(characterService.findByName(name));
    }
}
