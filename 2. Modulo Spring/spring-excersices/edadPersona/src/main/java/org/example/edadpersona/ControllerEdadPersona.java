package org.example.edadpersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/edad")
public class ControllerEdadPersona {
    @GetMapping("{dia}/{mes}/{anio}")
    public String getEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        try {
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();
            Period edad = Period.between(fechaNacimiento, fechaActual);
            if(anio < 1900|| anio >= fechaActual.getYear()) {
                throw new IllegalArgumentException("El año debe estar entre 1900 y el año actual.");
            }
            return "La edad de la persona es " + edad.getYears() + " años.";
        } catch (DateTimeParseException e) {
            return "Error: Fecha inválida.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
