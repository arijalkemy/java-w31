package com.bootcamp.morsecode;

import java.util.List;

public class MorseCodeConverter {
    private static final List<String> ALPHABET = List.of("A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            "?", "!", ".", ",");
    private static final List<String> MORSE_CODE_ALPHABET = List.of(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
            "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
            "..--..", "-.-.--", ".-.-.-", "--..--");

    public static String decode(String morseCode) {
        String[] morseCodeWords = morseCode.trim().split(" {3}");
        if (morseCodeWords.length == 0) {
            return "";
        }
        StringBuilder sentence = new StringBuilder();
        for (String morseCodeWord : morseCodeWords) {
            String[] symbols = morseCodeWord.trim().split(" ");
            for (String symbol : symbols) {
                if (MORSE_CODE_ALPHABET.contains(symbol)) {
                    String letter = ALPHABET.get(MORSE_CODE_ALPHABET.indexOf(symbol));
                    sentence.append(letter);
                }
            }
            sentence.append(" ");
        }
        return sentence.toString().trim();
    }

    public static String encode(String sentence) {
        sentence = sentence.toUpperCase();
        String[] words = sentence.trim().split(" ");
        if (words.length == 0) {
            return "";
        }
        StringBuilder morseSentence = new StringBuilder();
        for (String word : words) {
            String[] characters = word.trim().split("");
            for (String character : characters) {
                if (ALPHABET.contains(character)) {
                    String symbol = MORSE_CODE_ALPHABET.get(ALPHABET.indexOf(character));
                    morseSentence.append(symbol);
                    morseSentence.append(" ");
                }
            }
            morseSentence.append("   ");
        }

        return morseSentence.toString().trim();
    }
}
