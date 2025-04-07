package com.codigo_morse.codigo_morse.Service;

import java.util.Arrays;
import java.util.Map;

public class Traductor {

    private static final Map<String, String> DECODIFICADOR = Map.ofEntries(
            Map.entry(".-", "A"), Map.entry("-...", "B"), Map.entry("-.-.", "C"),
            Map.entry("-..", "D"), Map.entry(".", "E"), Map.entry("..-.", "F"),
            Map.entry("--.", "G"), Map.entry("....", "H"), Map.entry("..", "I"),
            Map.entry(".---", "J"), Map.entry("-.-", "K"), Map.entry(".-..", "L"),
            Map.entry("--", "M"), Map.entry("-.", "N"), Map.entry("---", "O"),
            Map.entry(".--.", "P"), Map.entry("--.-", "Q"), Map.entry(".-.", "R"),
            Map.entry("...", "S"), Map.entry("-", "T"), Map.entry("..-", "U"),
            Map.entry("...-", "V"), Map.entry(".--", "W"), Map.entry("-..-", "X"),
            Map.entry("-.--", "Y"), Map.entry("--..", "Z"), Map.entry(".----", "1"),
            Map.entry("..---", "2"), Map.entry("...--", "3"), Map.entry("....-", "4"),
            Map.entry(".....", "5"), Map.entry("-....", "6"), Map.entry("--...", "7"),
            Map.entry("---..", "8"), Map.entry("----.", "9"), Map.entry("-----", "0")
    );

    public static String traducir(String frase) {
        frase = frase.toLowerCase();

        // Ejemplo ".... --- .-.. .-   -- . .-.. .."
        // 1 SPLIT) [".... --- .-.. .-", "-- . .-.. .."]

        String[] palabras = frase.split("   ");

        // 2 SPLIT) [["....", "---", ".-..", ".-"], ["--", ".", ".-..", ".."]]
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            Arrays.stream(letras).forEach(letra -> {
                resultado.append(DECODIFICADOR.get(letra));
            });
            resultado.append(" ");
        }
        System.out.println("Resultado: " + String.valueOf(resultado));
        return String.valueOf(resultado).strip();
    }

}
