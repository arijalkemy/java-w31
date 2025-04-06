package com.codigomorse.demo.controller;

import com.codigomorse.demo.model.conversorRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("decimalAromano/{numeroRomano}")
    public String getMorsePorFrase(@PathVariable String numeroRomano){
        String cadena = conversorRomano.convertirDecimalARomanos(numeroRomano);
        return cadena;
    }

}
