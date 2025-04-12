package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.PersonajeDto;
import com.mercadolibre.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/personajes")
    public List<PersonajeDto> getPersonajes(@RequestParam String name) {
        return personajeService.searchByName(name);
    }
}
