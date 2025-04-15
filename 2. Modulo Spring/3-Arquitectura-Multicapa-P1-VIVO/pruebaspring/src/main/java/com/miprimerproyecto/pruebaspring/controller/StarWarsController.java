package com.miprimerproyecto.pruebaspring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.miprimerproyecto.pruebaspring.dto.CharacterDto;
import com.miprimerproyecto.pruebaspring.service.StarWarsService;

@RestController
public class StarWarsController {
    
    StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService){
        this.starWarsService = starWarsService;
    }

    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDto>> getCharactersByName(
        @PathVariable String name
    ){
        return ResponseEntity.ok(starWarsService.getCharactersByName(name));
    }
}
