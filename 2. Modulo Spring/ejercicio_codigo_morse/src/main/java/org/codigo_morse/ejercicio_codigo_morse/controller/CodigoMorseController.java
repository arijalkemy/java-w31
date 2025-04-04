package org.codigo_morse.ejercicio_codigo_morse.controller;

import org.codigo_morse.ejercicio_codigo_morse.service.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    CodigoMorseService codigoMorseService;

    @Autowired
    public CodigoMorseController(CodigoMorseService codigoMorseService) {
        this.codigoMorseService = codigoMorseService;
    }

    @GetMapping("{morse}")
    public String codeMorse(@PathVariable String morse) {
        return codigoMorseService.codeMorse(morse);
    }
}
