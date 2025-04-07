package com.mercadolibre.obteneredad.services;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;


@Service
public class ConvertAge {
    public int convertAge(String day, String month, String year) {
        try {
            int dayInt = Integer.parseInt(day);
            int monthInt = Integer.parseInt(month);
            int yearInt = Integer.parseInt(year);

            // Validar que la fecha sea correcta
            LocalDate date = LocalDate.of(yearInt, monthInt, dayInt);
            LocalDate now = LocalDate.now();

            return Period.between(date, now).getYears();

        } catch (DateTimeException ex) {
            throw new IllegalArgumentException("Error converting age: Fecha no válida.");
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Error converting age: Formato de fecha incorrecto.");
        }

    }

}