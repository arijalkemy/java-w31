package com.mercadolibre.romanos.controller;

import com.mercadolibre.romanos.service.ConversorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {
    public static ConversorService servicio;
    public ConversorController(ConversorService servicio){
        this.servicio = servicio;
    }

    @GetMapping("romano/{numero}")
    public String getNumeroConvertido(@PathVariable Integer numero){
       String numeroConvertido = this.servicio.convertirARomano(numero);

        return "El numero convertido en romando es: " + numeroConvertido;
    }


}
