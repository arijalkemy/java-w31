package com.mercadolibre.codigomorse.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class ConversorMorseService {
    private final static TreeMap<String, String> map = new TreeMap<>();

    static {
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");
        map.put("-----", "0");
        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");
        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        map.put("..--..", "?");
        map.put("-.-.--", "!");
        map.put(".-.-.-", ".");
        map.put("--..--", ",");
    }

    public String convertirMorseAPalabra(String codigo) {
        return Arrays.stream(codigo.trim().split("\\s{3,}")) // palabras separadas por 3 o más espacios
                .map(palabraMorse ->
                        Arrays.stream(palabraMorse.trim().split("\\s+")) // letras separadas por espacios
                                .map(letra -> map.getOrDefault(letra, "?"))
                                .collect(Collectors.joining()) // junta las letras en una palabra
                )
                .collect(Collectors.joining(" ")); // junta las palabras con espacios
    }
}
