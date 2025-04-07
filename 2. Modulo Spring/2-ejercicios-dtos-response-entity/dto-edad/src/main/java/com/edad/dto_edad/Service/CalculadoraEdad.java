package com.edad.dto_edad.Service;

import java.time.LocalDate;
import java.time.Period;

public class CalculadoraEdad {

    public static Integer calcularEdad(Integer dia, Integer mes, Integer year) {
        LocalDate fechaDeNacimiento = LocalDate.of(year, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaDeNacimiento, fechaActual).getYears();
    }
}
