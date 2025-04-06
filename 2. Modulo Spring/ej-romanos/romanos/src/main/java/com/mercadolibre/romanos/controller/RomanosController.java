package com.mercadolibre.romanos.controller;

import com.mercadolibre.romanos.service.RomanosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    @GetMapping("convertir/{numero}")
    public String convertir(@PathVariable Integer numero, @RequestParam String nombre) {
        RomanosService romanosService = new RomanosService();
        return romanosService.convertir(numero, nombre);
    };
}
