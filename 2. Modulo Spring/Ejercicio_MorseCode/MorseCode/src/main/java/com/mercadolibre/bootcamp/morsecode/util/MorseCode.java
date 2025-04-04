package com.mercadolibre.bootcamp.morsecode.util;

import java.util.HashMap;
import java.util.Map;


/**
 * Utility class for Morse code translation.
 * This class provides a mapping from Morse code strings to their
 * corresponding alphabetical characters.
 */
public class MorseCode {
    private static final Map<String, Character> morseToLetter = new HashMap<>();

    static {
        morseToLetter.put(".-", 'A');
        morseToLetter.put("-...", 'B');
        morseToLetter.put("-.-.", 'C');
        morseToLetter.put("-..", 'D');
        morseToLetter.put(".", 'E');
        morseToLetter.put("..-.", 'F');
        morseToLetter.put("--.", 'G');
        morseToLetter.put("....", 'H');
        morseToLetter.put("..", 'I');
        morseToLetter.put(".---", 'J');
        morseToLetter.put("-.-", 'K');
        morseToLetter.put(".-..", 'L');
        morseToLetter.put("--", 'M');
        morseToLetter.put("-.", 'N');
        morseToLetter.put("---", 'O');
        morseToLetter.put(".--.", 'P');
        morseToLetter.put("--.-", 'Q');
        morseToLetter.put(".-.", 'R');
        morseToLetter.put("...", 'S');
        morseToLetter.put("-", 'T');
        morseToLetter.put("..-", 'U');
        morseToLetter.put("...-", 'V');
        morseToLetter.put(".--", 'W');
        morseToLetter.put("-..-", 'X');
        morseToLetter.put("-.--", 'Y');
        morseToLetter.put("--..", 'Z');
        morseToLetter.put("-----", '0');
        morseToLetter.put(".----", '1');
        morseToLetter.put("..---", '2');
        morseToLetter.put("...--", '3');
        morseToLetter.put("....-", '4');
        morseToLetter.put(".....", '5');
        morseToLetter.put("-....", '6');
        morseToLetter.put("--...", '7');
        morseToLetter.put("---..", '8');
        morseToLetter.put("----.", '9');

    }

    public static Character getLetter(String morseCode) {
        return morseToLetter.get(morseCode);
    }
}
