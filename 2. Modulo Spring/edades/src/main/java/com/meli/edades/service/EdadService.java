package com.meli.edades.service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EdadService {

    public String getEdad(String day, String month, String year) {
        int age = calculateAge(formatDate(day, month, year));
        return String.format("Tienes %s años", age);
    }

    private LocalDate formatDate(String day, String month, String year) {
        try {
            int d = Integer.parseInt(day);
            int m = Integer.parseInt(month);
            int y = Integer.parseInt(year);

            LocalDate date = LocalDate.of(y, m, d);

            if (date.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha no puede ser futura.");
            }

            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Los valores ingresados deben ser números enteros.");
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("La fecha ingresada no es válida.");
        }
    }

    private int calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }

}
