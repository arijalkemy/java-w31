package com.mercadolibre.obteneredad.controller;

import com.mercadolibre.obteneredad.services.ConvertAge;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AgesController {
    private final ConvertAge age;

    @GetMapping("/edad/{day}/{month}/{year}")
    public int getAge(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        return age.convertAge(day, month, year);
    }
}
