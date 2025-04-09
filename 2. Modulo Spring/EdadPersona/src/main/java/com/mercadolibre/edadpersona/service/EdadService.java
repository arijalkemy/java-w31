package com.mercadolibre.edadpersona.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService {
    public Integer calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaNacimiento;
        try{
             fechaNacimiento = LocalDate.of(anio, mes, dia);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
