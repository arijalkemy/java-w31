package com.edad.fechaedad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class edadController {

    @GetMapping(path = "/edad/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia, @PathVariable int mes,@PathVariable int anio){
        try{
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaHoy = LocalDate.now();
            int edad = Period.between(fechaNacimiento, fechaHoy).getYears();

            return "{\"edad\": " + edad + "}";
        }
        catch (Exception e){
            return "{\"Fecha inválida\"}";
        }
    }
}
