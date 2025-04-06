package com.example.morse.Controller;

import com.example.morse.Services.MorseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MorseCode")
public class MorseController {

    private final MorseService morseService = new MorseService();

    @GetMapping
    public String decode(@RequestParam String code) {
        String[] words = code.trim().split(" {3}");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String[] letters = words[i].trim().split(" ");
            for (String letter : letters) {
                result.append(morseService.decodeLetter(letter));
            }
            if (i != words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
