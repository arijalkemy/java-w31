package com.example.edad_de_una_persona.controller;

import com.example.edad_de_una_persona.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcularEdad")
public class AgeController {
    @Autowired
    AgeService ageService;
    @GetMapping("/{dia}/{mes}/{año}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int año) throws IllegalAccessException {
        return ageService.calcularEdad(dia, mes, año);
    }
}
