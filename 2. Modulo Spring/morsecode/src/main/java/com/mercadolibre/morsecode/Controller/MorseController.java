package com.mercadolibre.morsecode.Controller;

import com.mercadolibre.morsecode.Service.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/morse")
public class MorseController {

    private final MorseService morseService;

    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }


    @GetMapping("/decode")
    public String decode(@RequestParam String codigo) {
        return morseService.decode(codigo);
    }
}

