package com.miprimerproyecto.pruebaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.miprimerproyecto.pruebaspring.service.DateService;


@RestController
public class DateController {

    DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public Integer getAge(
        @PathVariable Integer day,
        @PathVariable Integer month,
        @PathVariable Integer year
    ){
        return this.dateService.getAge(day, month, year);
    }


}
