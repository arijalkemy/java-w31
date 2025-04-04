package org.edad_persona.ejercicio_edad_persona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/edad")
public class CalcularEdad {

    @GetMapping("{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio) {
        try {
            LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
            LocalDate fechaActual = LocalDate.now();

            Period edad = Period.between(fechaNacimiento, fechaActual);

            return "El usuario tiene " + edad.getYears() + " años";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}
