package com.example.NumerosRomanos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.NumerosRomanos.Service.NumerosRomanosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class NumerosRomanosController {

    @Autowired
    private NumerosRomanosService numerosRomanosService;

    @GetMapping("/{decimal}")
    public String convertirARomano(@PathVariable Integer decimal) {
        return numerosRomanosService.integerARomano(decimal).toString();
    }
}
