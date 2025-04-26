package com.bootcamp.morse.controlador;

import com.bootcamp.morse.services.MorseServices;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Setter
public class Morse {
    private final MorseServices morseService;

    @Autowired
    public Morse(MorseServices morseService) {
        this.morseService = morseService;
    }

    @GetMapping("/{morse}")
    public String morseToWords(@PathVariable String morse) {
        return morseService.morseToWords(morse);
    }
}
