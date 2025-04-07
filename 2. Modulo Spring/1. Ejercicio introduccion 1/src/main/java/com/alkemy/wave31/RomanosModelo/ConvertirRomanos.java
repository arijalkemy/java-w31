package com.alkemy.wave31.RomanosModelo;


import org.springframework.stereotype.Service;

@Service
public class ConvertirRomanos {
    public int ConvertirRomanos(String numeroRomano) {
        int result = 0;
        if (numeroRomano == null || numeroRomano.isEmpty()) {
            throw new IllegalArgumentException("Entrada no puede ser nulo");
        }

        for (int i = 0; i < numeroRomano.length(); i++) {
            result += convertirNumero(String.valueOf(numeroRomano.charAt(i)));
        }
        return result;
    }

    private int convertirNumero(String numeroRomano) {
        return switch (numeroRomano) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            default -> throw new IllegalStateException("Unexpected value: " + numeroRomano);
        };
    }
}
