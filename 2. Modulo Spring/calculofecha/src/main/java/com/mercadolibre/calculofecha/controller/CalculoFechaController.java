package com.mercadolibre.calculofecha.controller;

import com.mercadolibre.calculofecha.service.CalculoFechaService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculoFechaController {

    private CalculoFechaService servicio = new CalculoFechaService();
    public CalculoFechaController(CalculoFechaService servicio){
        this.servicio = servicio;
    }

    @GetMapping("/calcular/{dia}/{mes}/{anio}")
    public Integer getAniosCalculados(@PathVariable("dia") Integer dia, @PathVariable("mes") Integer mes,
                                      @PathVariable("anio") Integer anio){
    return this.servicio.calcularFecha(dia, mes, anio);
    }

}
