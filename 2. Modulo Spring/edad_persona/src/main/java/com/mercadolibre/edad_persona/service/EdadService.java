package com.mercadolibre.edad_persona.service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class EdadService {
    public Integer calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaNacimiento = null;
        try {
            fechaNacimiento = LocalDate.of(anio, mes, dia);
        }
        catch (DateTimeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
