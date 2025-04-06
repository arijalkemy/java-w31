package com.example.romano.Services;

import org.springframework.stereotype.Service;

@Service
public class RomanoService {
    public String convertirARomano(int numero) {
        if (numero < 1 || numero > 3999) {
            return "Número fuera de rango (1-3999)";
        }

        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romano = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                numero -= valores[i];
                romano.append(simbolos[i]);
            }
        }
        return romano.toString();
    }
}
