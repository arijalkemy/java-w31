package com.mercadolibre.edad.controller;

import com.mercadolibre.edad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @GetMapping("get-edad/{day}/{month}/{year}")
    public String getAge(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        return EdadService.getAge(day, month, year);
    }

}
