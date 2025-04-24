package com.fernandotorres.dtoyresponseentity.model;

import java.time.LocalDate;
import java.time.Period;

public class ConversorEdad {

    public static Integer convertirFecha(Integer dia , Integer mes, Integer anio){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, fechaActual);
        return edad.getYears();
    }

}
