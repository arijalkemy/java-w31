package com.bootcamp.morsecode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MorseCodeController {
    @GetMapping("/decode/{morseCode}")
    public String decodeMorseCode(@PathVariable String morseCode) {
        return MorseCodeConverter.decode(morseCode);
    }

    @GetMapping("/encode/{sentence}")
    public String encodeMorseCode(@PathVariable String sentence) {
        return MorseCodeConverter.encode(sentence);
    }
}
