package com.ejercicios.apiEdad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeService {
    public int calcularEdad(int day, int month, int year) {
        try {
            LocalDate birthDate = LocalDate.of(year, month, day);
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthDate, currentDate).getYears();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date provided", e);
        }
    }
}
