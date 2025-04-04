package com.mercadolibre.codigomorse.controller;

import com.mercadolibre.codigomorse.entidades.Codigo;
import com.mercadolibre.codigomorse.service.ConversorMorseService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConversorMorseController {
    public final ConversorMorseService servicio;
    public String codigoConvertido = " ";
    public ConversorMorseController(ConversorMorseService servicio){
        this.servicio = servicio;
    }

    @PostMapping("/codigomorse")
    public String traducirMorse(@RequestBody Codigo request) {
        String resultado = servicio.convertirMorseAPalabra(request.getCodigo());
        return "El código se tradujo a: " + resultado;
    }

}
