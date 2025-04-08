package com.romanos.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Romanos {
    
    String[] numerosRomanos = {"M", "D", "C", "L", "XIII", "X", "VII", "V", "IV", "III", "II", "I"};
    int[] numeroStrings = {1000, 500, 100, 50, 13, 10, 7, 5, 4, 3, 2, 1};

    @GetMapping("/numeros/{number}")
    public String romans(@PathVariable int number) {
        StringBuilder romanBuilder = new StringBuilder();
        for (int i = 0; i < numeroStrings.length; i++) {
            for(; number >= numeroStrings[i]; number -= numeroStrings[i]) {
                romanBuilder.append(numerosRomanos[i]);
            }
        }
        return romanBuilder.toString();
    }

}
