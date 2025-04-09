package com.mercadolibre.ejerciciocodigomorse.controller;

import com.mercadolibre.ejerciciocodigomorse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/codigomorse")
public class MorseController {

    @Autowired
    private MorseService service;


    @GetMapping("/{codigo}")
    public String decifrarCodigo(@PathVariable String codigo) {
        return service.decifrarMorse(codigo);
    }


}