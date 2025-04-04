package com.bootcamp.numerosRomanos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRomano {

    @GetMapping("/convertir/{numero}")
    public ResponseEntity<String> convertirDecimalARomano(@PathVariable int numero) {
        if (numero <= 0) {
            return ResponseEntity.badRequest().body("Número debe ser mayor que 0");
        }

        StringBuilder romano = new StringBuilder();
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                romano.append(simbolos[i]);
                numero -= valores[i];
            }
        }

        return ResponseEntity.ok(romano.toString());
    }
}