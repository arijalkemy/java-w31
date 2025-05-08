package com.mercadolibre.edaddeunapersona.controller;

import com.mercadolibre.edaddeunapersona.service.CalcularEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcularEdad/")
public class CalcularEdadController {

    private final CalcularEdadService calcularEdadService;

    @Autowired
    public CalcularEdadController(CalcularEdadService calcularEdadService) {
        this.calcularEdadService = calcularEdadService;
    }

    @GetMapping("{dia}/{mes}/{año}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int año) {
        return calcularEdadService.calcularEdad(dia, mes, año);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleInvalidDate() {
        return "Error: La fecha ingresada no es válida";
    }
}



