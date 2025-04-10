package com.example.ejercicioObteniendoEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
public class FechaController {

    @GetMapping(path = "{day}/{month}/{year}")
    public String getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        try {
            LocalDate birth = LocalDate.of(year, month, day);
            LocalDate nowDate = LocalDate.now();

            int age = nowDate.getYear() - birth.getYear(); // calculo al edad

            if (nowDate.getDayOfYear() < birth.getDayOfYear()) {
                age--;
            }
            return "Tu edad es: " + age;
        }
        catch (DateTimeException e) {
            return  "Error al crear la fecha: " + e.getMessage();
        }

    }
}
