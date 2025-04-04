package com.ejercicios.numerosromanos.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IntegerToRomanService {
    private static final Map<String, Integer> romanNumeralMap = new LinkedHashMap<>();

    static {
        romanNumeralMap.put("M", 1000);
        romanNumeralMap.put("CM", 900);
        romanNumeralMap.put("D", 500);
        romanNumeralMap.put("CD", 400);
        romanNumeralMap.put("C", 100);
        romanNumeralMap.put("XC", 90);
        romanNumeralMap.put("L", 50);
        romanNumeralMap.put("XL", 40);
        romanNumeralMap.put("X", 10);
        romanNumeralMap.put("IX", 9);
        romanNumeralMap.put("V", 5);
        romanNumeralMap.put("IV", 4);
        romanNumeralMap.put("I", 1);
    }

    public String integerToRoman(int number) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : romanNumeralMap.entrySet()) {
            while (number >= entry.getValue()) {
                result.append(entry.getKey());
                number -= entry.getValue();
            }
        }
        return result.toString();
    }
}
