package com.miprimerproyecto.pruebaspring.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

@Service
public class DateService {
    
    public Integer getAge(
        final Integer day,
        final Integer month,
        final Integer year
    ){
        
        return calculatedAge(day, month, year);
    }

    public Integer calculatedAge(Integer day, Integer month, Integer year) {
        LocalDate fechaNacimiento = LocalDate.of(year, month, day);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}
