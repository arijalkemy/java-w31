package com.example.codigo_morse.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CodeMorseService {
    private static final Map<String, String> morseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put(".-" , "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..","I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..","L");
        morseCodeMap.put("--" , "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-","U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-","X");
        morseCodeMap.put("-.--" , "Y");
        morseCodeMap.put("--..", "Z");

        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...","7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put("-----","0");

        morseCodeMap.put("..--..", "?");
        morseCodeMap.put("-.-.--","!");
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");
    }

    public String translateMorseToText(String morseCode){
        return Arrays.stream(morseCode.trim().split("\\s{3,}"))
                .map(w-> Arrays.stream(w.trim().split("\\s+"))
                        .map(ch-> morseCodeMap.getOrDefault(ch, "?"))
                        .collect(Collectors.joining("")))
                .collect(Collectors.joining(" "));
    }
}
