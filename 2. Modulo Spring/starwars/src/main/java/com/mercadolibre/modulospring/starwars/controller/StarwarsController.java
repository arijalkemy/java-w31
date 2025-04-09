package com.mercadolibre.modulospring.starwars.controller;

import com.mercadolibre.modulospring.starwars.dto.CharacterDTO;
import com.mercadolibre.modulospring.starwars.service.StarwarsServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarwarsController {
    @Autowired
    private StarwarsServiceIMP starwarsServiceIMP;



    @GetMapping("{name}")
    public ResponseEntity<List<CharacterDTO>> index(@PathVariable String name) {

        return new ResponseEntity<>(starwarsServiceIMP.obtenerNombres(name), HttpStatus.OK);
    }
}
