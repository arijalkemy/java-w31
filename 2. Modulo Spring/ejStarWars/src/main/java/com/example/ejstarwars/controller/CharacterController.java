package com.example.ejstarwars.controller;

import com.example.ejstarwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {
    @Autowired
    ICharacterService characterService;

    @GetMapping("/characters/{name}")
    ResponseEntity<?> getCharactersByName(@PathVariable String name){
        return new ResponseEntity<>(characterService.findByName(name), HttpStatus.OK);
    }
}
