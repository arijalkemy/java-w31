package com.mercadolibreexample.code_morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/code")
    public String hello(@RequestParam String text) {
        StringBuilder response = new StringBuilder();
        text = text.replace("%20", " ");

        Map<Character, String> morseMap = new HashMap<>();
        morseMap.put('a', ".-");
        morseMap.put('b', "-...");
        morseMap.put('c', "-.-.");
        morseMap.put('d', "-..");
        morseMap.put('e', ".");
        morseMap.put('f', "..-.");
        morseMap.put('g', "--.");
        morseMap.put('h', "....");
        morseMap.put('i', "..");
        morseMap.put('j', ".---");
        morseMap.put('k', "-.-");
        morseMap.put('l', ".-..");
        morseMap.put('m', "--");
        morseMap.put('n', "-.");
        morseMap.put('o', "---");
        morseMap.put('p', ".--.");
        morseMap.put('q', "--.-");
        morseMap.put('r', ".-.");
        morseMap.put('s', "...");
        morseMap.put('t', "-");
        morseMap.put('u', "..-");
        morseMap.put('v', "...-");
        morseMap.put('w', ".--");
        morseMap.put('x', "-..-");
        morseMap.put('y', "-.--");
        morseMap.put('z', "--..");

        morseMap.put('0', "-----");
        morseMap.put('1', ".----");
        morseMap.put('2', "..---");
        morseMap.put('3', "...--");
        morseMap.put('4', "....-");
        morseMap.put('5', ".....");
        morseMap.put('6', "-....");
        morseMap.put('7', "--...");
        morseMap.put('8', "---..");
        morseMap.put('9', "----.");

        morseMap.put('.', ".-.-.-");
        morseMap.put(',', "--..--");
        morseMap.put('!', "-.-.--");
        morseMap.put('?', "..--..");

        for (Character c : text.toCharArray()) {
            if (c == ' ') {
                response.append("   ");
            } else if (morseMap.containsKey(c)) {
                response.append(morseMap.get(c)).append(" ");
            }
        }
        return response.toString().trim();
    }
}