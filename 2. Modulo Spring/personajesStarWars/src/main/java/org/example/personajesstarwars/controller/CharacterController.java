package org.example.personajesstarwars.controller;

import org.example.personajesstarwars.dto.CharacterDTO;
import org.example.personajesstarwars.entity.CharacterEntity;
import org.example.personajesstarwars.repository.ICharacterRepository;
import org.example.personajesstarwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private ICharacterService characterService;

    @GetMapping("/getAll")
    public List<CharacterEntity> getAllCharacters() throws IOException{
        return characterService.getAllCharacters();
    }

    @GetMapping("/search")
    public List<CharacterDTO> loadCharactersByName(@RequestParam String name) throws IOException {
        return characterService.loadCharactersByName(name);
    }
}
