package com.numromano.romano;

import org.springframework.web.bind.annotation.*;

@RestController
public class RomanoController {

    @GetMapping("/{number}")
    public String toRoman(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        Integer[] numeros = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numeros.length; i++)
            for (;number >= numeros[i]; number -= numeros[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }
}
