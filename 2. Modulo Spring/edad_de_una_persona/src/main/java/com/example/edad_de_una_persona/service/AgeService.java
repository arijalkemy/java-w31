package com.example.edad_de_una_persona.service;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeService {

    public int calcularEdad(int dia, int mes, int año) throws IllegalAccessException {
        LocalDate fechaNacimiento;

        try {
            fechaNacimiento = LocalDate.of(año, mes, dia);
        }catch (DateTimeException e){
            throw new IllegalAccessException("La fecha ingresada no es válida.");
        }

        LocalDate fechaActual =  LocalDate.now();
        return Period.between(fechaNacimiento,fechaActual).getYears();
    }
}
