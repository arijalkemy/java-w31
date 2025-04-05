package com.mercadolibre.maolaya.morse.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.maolaya.morse.Model.Morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MorseApi {
    @GetMapping("/v1/morse/{morseCode}")
    public String getTranslationFromMorse(@PathVariable String morseCode) {
        return Morse.translateMorseCode(morseCode);
    }

}
