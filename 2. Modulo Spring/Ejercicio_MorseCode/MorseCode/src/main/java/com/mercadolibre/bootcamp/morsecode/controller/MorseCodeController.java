package com.mercadolibre.bootcamp.morsecode.controller;

import com.mercadolibre.bootcamp.morsecode.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * REST Controller for Morse Code translation.
 * This controller provides an endpoint for translating Morse code into plain text.
 */
@RestController()
@RequestMapping("morse/translate")
public class MorseCodeController {

    private MorseService morseService;

    @Autowired
    public MorseCodeController(MorseService morseService) {
        this.morseService = morseService;
    }

    @GetMapping
    public String translate(@RequestParam String morseCode) {
        return morseService.decodeMorseCode(morseCode);
    }
}
