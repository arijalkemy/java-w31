package com.mercadolibre.maolaya.edad.Model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class Age {
    public static String getAge(Integer day, Integer month, Integer year) {
        try {
            LocalDate birthDate = LocalDate.of(year, month, day);
            Integer age = Period.between(birthDate, LocalDate.now()).getYears();
            return age.toString();
        } catch (DateTimeException e) {
            return "Error: Fecha no valida";
        }
    }
}
