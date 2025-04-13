package com.mercadolibre.edad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class EdadService {

    public static String getAge(String day, String month, String year) {

        String formatted_string = year + "-" + month + "-" + day;

        LocalDate birth_date = parseDate(formatted_string);

        String age = calculateAge(birth_date);

        return age;
    }

    public static LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha invlaida: " + e.getMessage());
            return null;
        }
    }

    public static String calculateAge(LocalDate birthDate) {
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
            return "La fecha ingresada es invalida.";
        }

        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);

        return String.valueOf(age.getYears());
    }

}
