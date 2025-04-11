package org.example.starwarsnames.controller;

import lombok.RequiredArgsConstructor;
import org.example.starwarsnames.dto.CharacterDTO;
import org.example.starwarsnames.service.StarWarsNamesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StarWarsNamesController {
    private final StarWarsNamesService starWarsNamesService;

    @GetMapping("/find-character/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharacterByName(@PathVariable String name) {
        List<CharacterDTO> starWarsCharacter = starWarsNamesService.getStarWarsCharacter(name);
        return new ResponseEntity<>(starWarsCharacter, HttpStatus.OK);
    }
}
