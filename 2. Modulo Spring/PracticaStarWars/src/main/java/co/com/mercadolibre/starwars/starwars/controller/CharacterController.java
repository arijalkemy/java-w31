package co.com.mercadolibre.starwars.starwars.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.starwars.starwars.service.CharacterService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getCharactersByName(@PathVariable String name) {
        return ResponseEntity.ok().body(characterService.findCharactersByName(name));
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(characterService.findAll());
    }
}
