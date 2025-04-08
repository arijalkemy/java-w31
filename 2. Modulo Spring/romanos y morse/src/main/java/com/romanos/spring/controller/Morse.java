package com.romanos.spring.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Morse {
    
    String[] letras = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "?", "!", ".", ","};
    String[] morse = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
        "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
        "-....", "--...", "---..", "----.", "-----", "..--..", "-.-.--", ".-.-.-", "--..--"
    };
    
    @GetMapping("/word/{word}")
    public String dots(@PathVariable String word) {
        String[] morseCodes = word.split(" ");

        String resultado = "";

        for (String code : morseCodes) {
            for (int i = 0; i < letras.length; i++) {
                if (code.equals(morse[i])) {
                    resultado += letras[i];
                }
            }
        }
        return resultado;

    }

}
