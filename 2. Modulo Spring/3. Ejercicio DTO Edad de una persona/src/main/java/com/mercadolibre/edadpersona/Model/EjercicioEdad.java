package com.mercadolibre.edadpersona.Model;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class EjercicioEdad {

    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);


        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}