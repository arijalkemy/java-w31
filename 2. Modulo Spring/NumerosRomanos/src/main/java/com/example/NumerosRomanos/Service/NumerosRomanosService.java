package com.example.NumerosRomanos.Service;

import org.springframework.stereotype.Service;

@Service
public class NumerosRomanosService {
    public NumerosRomanosService() {
    }

    public String integerARomano(Integer decimal) {
        if (decimal < 1 || decimal > 3999) {
            return "Número fuera de rango";
        }
        
        StringBuilder romano = new StringBuilder();

        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < valores.length; i++) {
            while (decimal >= valores[i]) {
                romano.append(romanos[i]);
                decimal -= valores[i];
            }
        }

        return romano.toString();
    }
}
