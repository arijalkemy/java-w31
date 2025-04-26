package com.bootcamp.star_wars_pj.controller;

import com.bootcamp.star_wars_pj.dtos.ConsultaPersonajeDTO;
import com.bootcamp.star_wars_pj.services.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    IStarWarsService starWarsService;

    @GetMapping("/{query}")
    public ResponseEntity<List<ConsultaPersonajeDTO>> getPersonajes(@PathVariable String query) {
        return ResponseEntity.ok(starWarsService.searchPersonajes(query));
    }
}
