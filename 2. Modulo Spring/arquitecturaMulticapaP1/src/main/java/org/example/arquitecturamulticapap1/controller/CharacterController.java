package org.example.arquitecturamulticapap1.controller;
import org.example.arquitecturamulticapap1.dto.CharacterDto;
import org.example.arquitecturamulticapap1.service.CharacterService;
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

    @GetMapping("/getCharacter/{name}")
    public ResponseEntity<List<CharacterDto>> getCharacter(@PathVariable String name){
        return new ResponseEntity<>(characterService.getCharacter(name), HttpStatus.OK);
    }
}
