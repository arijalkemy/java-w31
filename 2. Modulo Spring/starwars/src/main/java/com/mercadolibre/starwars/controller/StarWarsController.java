package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.StarWarsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarWarsController {
    private StarWarsService service;

    public StarWarsController(StarWarsService servicio){
        this.service = servicio;
    }

    @GetMapping("/findCharacter/{name}")
    public List<CharacterDTO> getCharacterByName(@PathVariable String name){
        return this.service.getCharactersByName(name);
    }
}
