package org.mercadolibre.ejercicio_starwars.controller;

import org.mercadolibre.ejercicio_starwars.service.IPersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {
    IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    public ResponseEntity<?> getPersonajes(){
        return new ResponseEntity<>(personajeService.listarPersonajes(), HttpStatus.OK);
    }

    @GetMapping("/personajes/{name}")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name) {
        return new ResponseEntity<>(personajeService.listarPersonajesPorNombre(name), HttpStatus.OK);
    }
}
