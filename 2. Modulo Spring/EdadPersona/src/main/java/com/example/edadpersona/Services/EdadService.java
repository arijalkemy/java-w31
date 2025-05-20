package com.example.edadpersona.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService {

    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();

        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
