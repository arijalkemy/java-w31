package com.bootcamp.ejerciciosdtoresponseentity.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

@Service
public class AgeService {
    public Integer actualAge(Integer d, Integer m, Integer y) {
        try{
            LocalDate now = LocalDate.now();
            Integer date = Math.abs(LocalDate.of(y, m, d).compareTo(now));
            return date;
        }
        catch (Exception e){
            throw new IllegalArgumentException("Formato incorrecto de fecha");
        }
    }
}
