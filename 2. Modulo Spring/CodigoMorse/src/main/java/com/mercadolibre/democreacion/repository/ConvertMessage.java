package com.mercadolibre.democreacion.repository;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConvertMessage {
    private static final Map<String, Character> morseCodeMap = new HashMap<>();

    static {
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
        morseCodeMap.put("-----", '0');
        morseCodeMap.put(".----", '1');
        morseCodeMap.put("..---", '2');
        morseCodeMap.put("...--", '3');
        morseCodeMap.put("....-", '4');
        morseCodeMap.put(".....", '5');
        morseCodeMap.put("-....", '6');
        morseCodeMap.put("--...", '7');
        morseCodeMap.put("---..", '8');
        morseCodeMap.put("----.", '9');
        morseCodeMap.put(".-.-.-", '.');
        morseCodeMap.put("--..--", ',');
        morseCodeMap.put("..--..", '?');
        morseCodeMap.put("/", ' ');
    }


    public String convertToMessage(String message) {
        StringBuilder convertedMessage = new StringBuilder();
        StringBuilder wordAcum = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            if (!String.valueOf(message.charAt(i)).equals(" ")) {
                wordAcum.append(message.charAt(i));
                if ((i + 1) == message.length())
                    convertedMessage.append(convertFromMessage(String.valueOf(wordAcum)));
            } else {
                convertedMessage.append(convertFromMessage(String.valueOf(wordAcum)));
                wordAcum = new StringBuilder();
            }
        }
        return convertedMessage.toString();
    }

    private Character convertFromMessage(String message) {
        Character value = morseCodeMap.get(message);
        if (value != null) {
            return value;
        }

        throw new IllegalArgumentException("No se encontró el código");
    }

}
