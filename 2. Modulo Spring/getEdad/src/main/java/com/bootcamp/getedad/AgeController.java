package com.bootcamp.getedad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeController {
    @GetMapping("/{day}/{month}/{year}")
    public Object getAge(@PathVariable("day") int day,
                         @PathVariable("month") int month,
                         @PathVariable("year") int year) {
        try {
            //validaciones
            if (month < 1 || month > 12) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El mes debe estar entre 1 y 12.");
            }
            if (day < 1 || day > 31) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El dia debe estar entre 1 y 31");
            }
            //validar fecha especifica de cada mes
            if ((month == 2 && day > 29) || (day == 29 && !esBisiesto(year))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Febrero solo tiene 29 días en años bisiestos.");
            }
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El mes " + month + " solo tiene 30 días.");
            }
            //crear fecha
            LocalDate birthDate = LocalDate.of(year, month, day);

            //fecha hoy
            LocalDate today = LocalDate.now();

            //calculo edad
            int age = calcateAge(birthDate, today);
            return ResponseEntity.ok(age);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Los parámetros deben ser enteros");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Fecha no válida");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado: " + e.getMessage());
        }

    }

    private int calcateAge(LocalDate birthDate, LocalDate today) {
        return Period.between(birthDate, today).getYears();
    }

    private boolean esBisiesto(int year) {
        //verificar si un año es bisiesto
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
