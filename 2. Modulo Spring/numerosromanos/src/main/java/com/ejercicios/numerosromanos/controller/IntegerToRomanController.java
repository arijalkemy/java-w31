package com.ejercicios.numerosromanos.controller;

import com.ejercicios.numerosromanos.service.IntegerToRomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/integerToRoman")
public class IntegerToRomanController {

    private final IntegerToRomanService service;

    @Autowired
    public IntegerToRomanController(IntegerToRomanService service) {
        this.service = service;
    }

    @GetMapping
    public String base() {
        return "Agregue un numero a la llamada con /{numero}";
    }

    @GetMapping("/{number}")
    public String integerToRoman(@PathVariable int number) {
        return service.integerToRoman(number);
    }

}
