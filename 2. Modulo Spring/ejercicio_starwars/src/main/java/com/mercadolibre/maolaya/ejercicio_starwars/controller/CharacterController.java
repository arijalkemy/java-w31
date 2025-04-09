package com.mercadolibre.maolaya.ejercicio_starwars.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.maolaya.ejercicio_starwars.dto.CharacterDto;
import com.mercadolibre.maolaya.ejercicio_starwars.service.CharacterServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CharacterController {
    @Autowired
    private CharacterServiceImpl characterService = new CharacterServiceImpl();

    @GetMapping("/{name}")
    public List<CharacterDto> getCharacterByName(@PathVariable String name) {
        return characterService.getCharacterByName(name);
    }

}
