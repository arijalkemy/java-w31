package com.mercadolibre.bootcamp.starwars.controller;

import com.mercadolibre.bootcamp.starwars.dto.CharacterDto;
import com.mercadolibre.bootcamp.starwars.model.MovieCharacter;
import com.mercadolibre.bootcamp.starwars.service.CharacterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/starwars")
public class CharacterRestController {

    private CharacterServiceImpl characterService;

    public CharacterRestController(CharacterServiceImpl characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    public ResponseEntity<List<CharacterDto>> findAllCharacters() {
        return new ResponseEntity<>(characterService.searchAllCharacters(), HttpStatus.OK);
    }

    @GetMapping("/characters/{name}")
    public ResponseEntity<List<CharacterDto>> findCharacters(@PathVariable String name) {
        return new ResponseEntity<>(characterService.searchCharactesrByName(name), HttpStatus.OK);
    }


}
