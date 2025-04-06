package com.codigomorse.demo.controller;

import com.codigomorse.demo.model.ConversorMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    ConversorMorse decodificadoMorse = new ConversorMorse();

    @GetMapping("morsePorFrase/{frase}")
    public String getMorsePorFrase(@PathVariable String frase){
        String cadena = decodificadoMorse.getMorsePorFrase(frase);
        return cadena;
    }

    @GetMapping("morsePorPalabra/{palabra}")
    public String getMorsePorPalabra(@PathVariable String palabra){
        String cadena = decodificadoMorse.getMorsePorFrase(palabra);
        return cadena;
    }

    @GetMapping("morsePorLetra/{letra}")
    public String getMorsePorLetra(@PathVariable String letra){
        String cadena = decodificadoMorse.getMorsePorFrase(letra);
        return cadena;
    }



}
