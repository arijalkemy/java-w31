package org.codigo_morse.ejercicio_codigo_morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorse {

    @GetMapping("{morse}")
    public String codigoMorse(@PathVariable String morse) {

        StringBuilder textoMorse = new StringBuilder();
        String[] morseWords = morse.split(" "); // Suponiendo que están separados por espacios

        String[] characters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "?", "!", ".",
                ","};

        String[] morseCodes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--..",
                "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "..--..", "-.-.--", ".-.-.-", "--..--"
        };


        for (String morseChar : morseWords) {
            for (int i = 0; i < morseCodes.length; i++) {
                if (morseChar.equals(morseCodes[i])) {
                    textoMorse.append(characters[i]);
                    break;
                }
            }
        }


        return  textoMorse.toString();
    }
}
