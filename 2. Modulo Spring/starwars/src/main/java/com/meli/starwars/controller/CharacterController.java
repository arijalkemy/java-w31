package com.meli.starwars.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.meli.starwars.dto.CharacterResponseDTO;
import com.meli.starwars.service.CharacterService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CharacterResponseDTO>> getCharacterByName(@PathVariable String name) {
        return ResponseEntity.ok(characterService.getCharacterByName(name));
    }

}