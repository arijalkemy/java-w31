package com.mercadolibre.morse.controller;

import com.mercadolibre.morse.service.MorseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @PostMapping("traducir")
    public String traducir (@RequestParam String morse){
        MorseService morseService = new MorseService();
        return morseService.traducir(morse);
    }
}
