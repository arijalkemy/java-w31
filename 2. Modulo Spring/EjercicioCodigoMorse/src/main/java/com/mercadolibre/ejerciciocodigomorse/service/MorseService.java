package com.mercadolibre.ejerciciocodigomorse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {
    private final Map<String, Character> mapaMorse;

    public MorseService() {
        this.mapaMorse = cargarMapa();
    }

    public String decifrarMorse(String morseText) {
        StringBuilder resultado = new StringBuilder();
        String[] palabras = morseText.split("   ");

        for (String palabra : palabras) {
            String[] letrasMorse = palabra.split(" ");
            for (String letra : letrasMorse) {
                Character caracter = this.mapaMorse.get(letra);
                if (caracter != null) {
                    resultado.append(caracter);
                }
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();
    }

    private Map<String, Character> cargarMapa() {
        HashMap<String, Character> morseCodeMap = new HashMap<>();

        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("..-", 'U');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');

        // Numbers
        morseCodeMap.put(".----", '1');
        morseCodeMap.put("..---", '2');
        morseCodeMap.put("...--", '3');
        morseCodeMap.put("....-", '4');
        morseCodeMap.put(".....", '5');
        morseCodeMap.put("-....", '6');
        morseCodeMap.put("--...", '7');
        morseCodeMap.put("---..", '8');
        morseCodeMap.put("----.", '9');
        morseCodeMap.put("-----", '0');

        // Punctuation
        morseCodeMap.put("..--..", '?');
        morseCodeMap.put("-.-.--", '!');
        morseCodeMap.put("-.-.-.", ';');
        morseCodeMap.put("--..--", ',');

        return morseCodeMap;
    }
}
