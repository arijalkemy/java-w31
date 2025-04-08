package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.CharacterDto;
import com.bootcamp.starwars.service.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character/")
public class CharactersController {

    @Autowired
    CharacterServiceImpl characterService;

    @GetMapping("{name}")
    public ResponseEntity<List<CharacterDto>> listCharactersByName(@PathVariable String name) {
        List<CharacterDto> characters = characterService.getCharactersByName(name);
        if (characters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
