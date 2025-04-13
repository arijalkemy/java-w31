package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDto;
import com.mercadolibre.starwars.repository.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.CharacterServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    CharacterServiceImpl characterService;

    public CharacterController(CharacterServiceImpl characterService){
        this.characterService = characterService;
    }

    @GetMapping("characters/{name}")
    public List<CharacterDto> getCharactersWithName(@PathVariable String name) throws Exception {
        return characterService.getCharactersWithName(name);
    }
}
