package com.spring.morsecode.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MorseRepository {
    private final Map<String, String> letterToMorse = new HashMap<>();
    private final Map<String, String> morseToLetter = new HashMap<>();

    public MorseRepository() {
        initializeMorseMap();
    }

    private void initializeMorseMap() {
        letterToMorse.put("A", ".-");
        morseToLetter.put(".-", "A");
        letterToMorse.put("B", "-...");
        morseToLetter.put("-...", "B");
        letterToMorse.put("C", "-.-.");
        morseToLetter.put("-.-.", "C");
        letterToMorse.put("D", "-..");
        morseToLetter.put("-..", "D");
        letterToMorse.put("E", ".");
        morseToLetter.put(".", "E");
        letterToMorse.put("F", "..-.");
        morseToLetter.put("..-.", "F");
        letterToMorse.put("G", "--.");
        morseToLetter.put("--.", "G");
        letterToMorse.put("H", "....");
        morseToLetter.put("....", "H");
        letterToMorse.put("I", "..");
        morseToLetter.put("..", "I");
        letterToMorse.put("J", ".---");
        morseToLetter.put(".---", "J");
        letterToMorse.put("K", "-.-");
        morseToLetter.put("-.-", "K");
        letterToMorse.put("L", ".-..");
        morseToLetter.put(".-..", "L");
        letterToMorse.put("M", "--");
        morseToLetter.put("--", "M");
        letterToMorse.put("N", "-.");
        morseToLetter.put("-.", "N");
        letterToMorse.put("O", "---");
        morseToLetter.put("---", "O");
        letterToMorse.put("P", ".--.");
        morseToLetter.put(".--.", "P");
        letterToMorse.put("Q", "--.-");
        morseToLetter.put("--.-", "Q");
        letterToMorse.put("R", ".-.");
        morseToLetter.put(".-.", "R");
        letterToMorse.put("S", "...");
        morseToLetter.put("...", "S");
        letterToMorse.put("T", "-");
        morseToLetter.put("-", "T");
        letterToMorse.put("U", "..-");
        morseToLetter.put("..-", "U");
        letterToMorse.put("V", "...-");
        morseToLetter.put("...-", "V");
        letterToMorse.put("W", ".--");
        morseToLetter.put(".--", "W");
        letterToMorse.put("X", "-..-");
        morseToLetter.put("-..-", "X");
        letterToMorse.put("Y", "-.--");
        morseToLetter.put("-.--", "Y");
        letterToMorse.put("Z", "--..");
        morseToLetter.put("--..", "Z");
        letterToMorse.put("1", ".----");
        morseToLetter.put(".----", "1");
        letterToMorse.put("2", "..---");
        morseToLetter.put("..---", "2");
        letterToMorse.put("3", "...--");
        morseToLetter.put("...--", "3");
        letterToMorse.put("4", "....-");
        morseToLetter.put("....-", "4");
        letterToMorse.put("5", ".....");
        morseToLetter.put(".....", "5");
        letterToMorse.put("6", "-....");
        morseToLetter.put("-....", "6");
        letterToMorse.put("7", "--...");
        morseToLetter.put("--...", "7");
        letterToMorse.put("8", "---..");
        morseToLetter.put("---..", "8");
        letterToMorse.put("9", "----.");
        morseToLetter.put("----.", "9");
        letterToMorse.put("0", "-----");
        morseToLetter.put("-----", "0");
    }

    public String convertToMorse(String letter) {
        return letterToMorse.getOrDefault(letter.toUpperCase(), "?");
    }

    public String convertToLetter(String morse) {
        return morseToLetter.getOrDefault(morse, "?");
    }
}
