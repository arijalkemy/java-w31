package com.mercadolibreexample.edad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class Controller {
    @GetMapping("/{day}/{month}/{year}")
    public String mensaje(@PathVariable String day,
                                          @PathVariable String month,
                                          @PathVariable String year) {
        LocalDate date = LocalDate.parse(year + "-" + month + "-" + day);
        LocalDate now = LocalDate.now();
        Period period = Period.between(date, now);
        return String.valueOf(period.getYears());
    }
}
