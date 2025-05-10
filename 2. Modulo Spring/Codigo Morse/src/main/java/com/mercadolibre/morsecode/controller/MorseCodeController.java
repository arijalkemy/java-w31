package com.mercadolibre.morsecode.controller;

import com.mercadolibre.morsecode.service.MorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morseCode")
public class MorseCodeController {

    @Autowired
    MorseCodeService morseCodeService;

    @PostMapping("/translate")
    public String translateMorseToText(@RequestBody String morseCode) {
        return morseCodeService.translateMorseToText(morseCode);
    }
}
