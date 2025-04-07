package com.ejercicios.apiEdad.controller;

import com.ejercicios.apiEdad.service.AgeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AgeController {

    private final AgeService ageService;

    public AgeController(AgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<String> calcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        int age = ageService.calcularEdad(day, month, year);
        return ResponseEntity.ok("Age is: " + age);
    }
}
