package com.starwarscharacter.starwars.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwarscharacter.starwars.dto.CharacterDto;
import com.starwarscharacter.starwars.service.IStarService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class StarController {
    private final IStarService starService;

    @GetMapping("/getallcharacters")
    public ResponseEntity<List<CharacterDto>> getallcharacter() {
        return new ResponseEntity<>(starService.getallcharacters(), HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<CharacterDto>> getByName(@PathVariable String name) {
        return new ResponseEntity<>(starService.getByNameList(name), HttpStatus.OK);
    }

}
