package com.bootcamp.springp2pg.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RomanService {
    Map<Integer, String> values;
    public RomanService() {
        values = new HashMap<>();
        values.put(1, "I");
        values.put(5, "V");
        values.put(10, "X");
        values.put(50, "L");
        values.put(100, "C");
        values.put(500, "D");
        values.put(1000, "M");
    }

    public String toRomanRecursivo(Integer n, String romano) {
        if (Math.abs(n - obtenerMayorSiguiente(n)) == 1 || Math.abs(n - obtenerMayorSiguiente(n)) == 10 ||
                Math.abs(n - obtenerMayorSiguiente(n)) == 100) {
            String valorResto = values.get(Math.abs(n - obtenerMayorSiguiente(n)));
            romano = valorResto + toRomanRecursivo(n + Math.abs(n - obtenerMayorSiguiente(n)), romano);
        } else if (Math.abs(n - obtenerMayorSiguiente(n)) != 1 && Math.abs(n - obtenerMayorSiguiente(n)) != 10 &&
                Math.abs(n - obtenerMayorSiguiente(n)) != 100 && Math.abs(n - obtenerMayorSiguiente(n)) != 0) {
            romano += values.get(obtenerMenorSiguiente(n)) + toRomanRecursivo(n - obtenerMenorSiguiente(n), romano);
        }
        else {
            romano += values.get(n);
        }
        return romano;
    }

    private Integer obtenerMayorSiguiente(Integer n) {
        return values.keySet().stream().filter(p -> p >= n).min(Comparator.comparing(Integer::intValue)).orElse(1000);
    }

    private Integer obtenerMenorSiguiente(Integer n) {
        return values.keySet().stream().filter(p -> p <= n).max(Comparator.comparing(Integer::intValue)).get();
    }

}
