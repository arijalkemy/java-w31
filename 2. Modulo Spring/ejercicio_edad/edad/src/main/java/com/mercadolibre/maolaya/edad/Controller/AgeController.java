package com.mercadolibre.maolaya.edad.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.maolaya.edad.Model.Age;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AgeController {
    @GetMapping("/{day}/{month}/{year}")
    public String getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return Age.getAge(day, month, year);
    }

}
