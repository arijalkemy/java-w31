package com.alkemy.wave31.Models;

import org.springframework.stereotype.Service;

@Service
public class ConvertirRomanos {

    public int convertirNumero(String romanos) {
        int numero = 0;
        if (romanos == null || romanos.isEmpty())
            throw new IllegalArgumentException("El número romano no puede ser nulo o vacio. ");

        for (int i = 0; i < romanos.length(); i++) {
            numero += convertirRomanos(String.valueOf(romanos.charAt(i)));
        }

        return numero;
    }

    private int convertirRomanos(String romanos) {
        return switch (romanos) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            default -> throw new IllegalArgumentException("Número romano no válido" + romanos);
        };
    }
}
