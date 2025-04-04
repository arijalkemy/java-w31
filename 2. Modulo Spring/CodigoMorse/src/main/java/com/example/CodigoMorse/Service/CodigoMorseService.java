package com.example.CodigoMorse.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CodigoMorseService {

    private final Map<String, String> morseCodeMap;

    public CodigoMorseService() {
        morseCodeMap = new HashMap<>();
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.","F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");
        morseCodeMap.put("-----", "0");
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put("..--..", "?");
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");
        morseCodeMap.put("-.-.--", "!");
    }

    public String decodificar(String codigo) {
        StringBuilder resultado = new StringBuilder();
        
        String[] palabrasMorse = codigo.split("   ");

        for (String palabra : palabrasMorse) {
            String[] letras = palabra.split(" ");
            for (String letra : letras) {
                String letraActual = morseCodeMap.get(letra);
                if (letraActual != null) {
                    resultado.append(letraActual);
                } else {
                    resultado.append("(Unknown)");
                }
            }
            resultado.append(" ");
        }
        return resultado.toString();
    }
}