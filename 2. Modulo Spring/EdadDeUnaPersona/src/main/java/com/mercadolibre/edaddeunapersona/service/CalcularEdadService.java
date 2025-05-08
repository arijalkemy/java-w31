package com.mercadolibre.edaddeunapersona.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.time.DateTimeException;

@Service
public class CalcularEdadService {

    public int calcularEdad(int dia, int mes, int año) {
        LocalDate fechaNacimiento;

        try {
            fechaNacimiento = LocalDate.of(año, mes, dia);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("La fecha ingresada no es válida");
        }

        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
