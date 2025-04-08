package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.StarWarsCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    private StarWarsCharacterService service;


    @GetMapping("/findCharacter/{name}")
    public List<CharacterDTO> getCharacterByName(@PathVariable String name){
        return this.service.getCharactersByName(name);
    }
}
