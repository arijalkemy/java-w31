package com.example.AgePerson.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.AgePerson.Service.IAgeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/age")
public class AgeController {
    private IAgeService ageService;

    public AgeController(IAgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/month/{month}/day/{day}/year/{year}")
    public Integer getAge(@PathVariable Integer month, @PathVariable Integer day, @PathVariable Integer year) {
        return ageService.calculateAge(month, day, year);

    }

}
