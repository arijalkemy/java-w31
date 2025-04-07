package com.mercadolibre.calculofecha.service;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculoFechaService {

    public Integer calcularFecha(Integer dia, Integer mes, Integer anio) {
        try {
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate hoy = LocalDate.now();

            return Period.between(fechaNacimiento, hoy).getYears();
        } catch (DateTimeException e) {
            System.out.println("Fecha inválida: " + e.getMessage());
            return 0;
        }

    }
}
