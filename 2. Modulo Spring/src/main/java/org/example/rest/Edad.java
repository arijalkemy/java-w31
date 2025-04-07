package org.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;

@RestController
public class Edad {

    @GetMapping(path = "/{day}/{month}/{year}")
    public String hello(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        if (month < 1 || month > 12) {
            return "Mes no válido";
        }
        if(!Year.isLeap(year)) {
            if(month == 2 && day >= 29) {
                return "Febrero no tiene más de 29 días en el año " + year;
            }
        }

        LocalDate birthDate = LocalDate.of(year, Month.of(month), day);
        LocalDate today = LocalDate.now();

        try {

            if (birthDate.isAfter(today)) {
                return "Fecha no válida";
            }
            if (birthDate.getDayOfMonth() == today.getDayOfMonth() && birthDate.getMonth() == today.getMonth()) {
                return "Feliz cumpleaños!!! Hoy tienes " + (today.getYear() - birthDate.getYear()) + " años";
            }
            int age = Period.between(birthDate, today).getYears();

            if (age <= 0) {
                return "Eres un bebé!!!";
            }
            if (age >= 100) {
                return "Eres muy viejo!!!";
            }
            return "Tu edad es: " + age + " años";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
