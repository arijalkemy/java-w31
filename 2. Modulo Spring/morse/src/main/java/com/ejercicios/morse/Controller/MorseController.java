package com.ejercicios.morse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/translateMorse")
public class MorseController {
    private MorseService service;

    @Autowired
    public MorseController(MorseService service) {
        this.service = service;
    }

    @GetMapping("/{text}")
    public String morseToText(@PathVariable String text) {
        return this.service.morseToText(text);
    }


}
