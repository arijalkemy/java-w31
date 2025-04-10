package com.numerosRomanos.apiNumRomanos.controller;

import com.numerosRomanos.apiNumRomanos.service.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosController {

    private NumeroRomano romano = new NumeroRomano();

    @GetMapping("/{numeroDecimal}")
    public String getNumRomano(@PathVariable Integer numeroDecimal){
        return romano.convertirARomano(numeroDecimal);
    }
}
