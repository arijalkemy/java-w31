package co.com.mercadolibre.morsecode.morsecode.service;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeService {

    private static Map<String, String> map = new HashMap<>();

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

    public static String translateToText(String morse) {
        StringBuilder translatedMorse = new StringBuilder();
        String[] morseWords = morse.split("   ");

        for (String morseWord : morseWords) {
            for (String character : morseWord.split(" ")) {
                String letter = map.getOrDefault(character, "");
                translatedMorse.append(letter);
            }
            translatedMorse.append(" ");
        }
        return translatedMorse.toString();
    }

}
