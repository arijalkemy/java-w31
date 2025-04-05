package com.mercadolibre.morsecode.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class MorseService {
    private final Map<String, String> morseMap = new HashMap<>();

    public MorseService() {
        // Mapa de códigos Morse a caracteres
        morseMap.put(".-", "A");     morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");   morseMap.put("-..", "D");
        morseMap.put(".", "E");      morseMap.put("..-.", "F");
        morseMap.put("--.", "G");    morseMap.put("....", "H");
        morseMap.put("..", "I");     morseMap.put(".---", "J");
        morseMap.put("-.-", "K");    morseMap.put(".-..", "L");
        morseMap.put("--", "M");     morseMap.put("-.", "N");
        morseMap.put("---", "O");    morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");   morseMap.put(".-.", "R");
        morseMap.put("...", "S");    morseMap.put("-", "T");
        morseMap.put("..-", "U");    morseMap.put("...-", "V");
        morseMap.put(".--", "W");    morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");   morseMap.put("--..", "Z");

        morseMap.put(".----", "1");  morseMap.put("..---", "2");
        morseMap.put("...--", "3");  morseMap.put("....-", "4");
        morseMap.put(".....", "5");  morseMap.put("-....", "6");
        morseMap.put("--...", "7");  morseMap.put("---..", "8");
        morseMap.put("----.", "9");  morseMap.put("-----", "0");

        morseMap.put(".-.-.-", "."); morseMap.put("-.-.--", "!");
        morseMap.put("...---...", "SOS"); // SOS en código Morse
    }

    public String decode(String morseCode) {
        String[] words = morseCode.trim().split("   ");     StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String[] letters = words[i].split(" ");
            for (String letter : letters) {
                result.append(morseMap.getOrDefault(letter, "?"));
            }
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
