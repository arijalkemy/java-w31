package com.mercadolibre.bootcamp.ageapi.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

@Service
public class AgeService {

    public Integer calculateAge(String date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, fmt);
        LocalDate now = LocalDate.now();
        Period period = Period.between(localDate, now);
        return period.getYears();
    }

    public boolean isValidDate(String d) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(d, dtf);
        } catch(DateTimeParseException ex) {
            return false;
        }
        return true;
    }
}
