package com.mercadolibre.bootcamp.ageapi.controller;

import com.mercadolibre.bootcamp.ageapi.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeRestController {

    private AgeService ageService;

    @Autowired
    public AgeRestController(AgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public String age(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        String date = day + "/" + month + "/" + year;
        if(ageService.isValidDate(date)) {
            return ageService.calculateAge(date).toString();
        }
        return "Invalid date";
    }
}
