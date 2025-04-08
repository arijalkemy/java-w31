package com.starwars.starwars.controller;

import com.starwars.starwars.dto.CharacterDTO;
import com.starwars.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("character/search/{searchWord}")
    public ResponseEntity<List<CharacterDTO>> getCharacter(@PathVariable String searchWord) {
        try {
            return new ResponseEntity<>(characterService.characterSearch(searchWord), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
