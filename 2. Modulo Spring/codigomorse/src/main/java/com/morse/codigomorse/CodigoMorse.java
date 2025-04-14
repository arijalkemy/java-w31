package com.morse.codigomorse;

import java.util.HashMap;
import java.util.Map;

public class CodigoMorse {

    private static final Map<String, String> morseCodeDict = new HashMap<>();
    static {
        morseCodeDict.put(".-", "A");
        morseCodeDict.put("-...", "B");
        morseCodeDict.put("-.-.", "C");
        morseCodeDict.put("-..", "D");
        morseCodeDict.put(".", "E");
        morseCodeDict.put("..-.", "F");
        morseCodeDict.put("--.", "G");
        morseCodeDict.put("....", "H");
        morseCodeDict.put("..", "I");
        morseCodeDict.put(".---", "J");
        morseCodeDict.put("-.-", "K");
        morseCodeDict.put(".-..", "L");
        morseCodeDict.put("--", "M");
        morseCodeDict.put("-.", "N");
        morseCodeDict.put("---", "O");
        morseCodeDict.put(".--.", "P");
        morseCodeDict.put("--.-", "Q");
        morseCodeDict.put(".-.", "R");
        morseCodeDict.put("...", "S");
        morseCodeDict.put("-", "T");
        morseCodeDict.put("..-", "U");
        morseCodeDict.put("...-", "V");
        morseCodeDict.put(".--", "W");
        morseCodeDict.put("-..-", "X");
        morseCodeDict.put("-.--", "Y");
        morseCodeDict.put("--..", "Z");
        morseCodeDict.put(".----", "1");
        morseCodeDict.put("..---", "2");
        morseCodeDict.put("...--", "3");
        morseCodeDict.put("....-", "4");
        morseCodeDict.put(".....", "5");
        morseCodeDict.put("-....", "6");
        morseCodeDict.put("--...", "7");
        morseCodeDict.put("---..", "8");
        morseCodeDict.put("----.", "9");
        morseCodeDict.put("-----", "0");
    }

    public static String traductorMorse(String morse){
        StringBuilder traducido = new StringBuilder();
        String[] letrasMorse = morse.split(" ");

        for (String letra : letrasMorse) {
            String letraTraducida = morseCodeDict.get(letra);
            if (letraTraducida != null) {
                traducido.append(letraTraducida);
            } else {
                traducido.append('?');
            }
        }

        return traducido.toString();


    }
}
