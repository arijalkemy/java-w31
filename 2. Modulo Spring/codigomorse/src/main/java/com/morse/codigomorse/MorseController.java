package com.morse.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {
    @GetMapping("morse/{palabra}")
    public String morseAFrase(@PathVariable String palabra){
        return CodigoMorse.traductorMorse(palabra);
    }
}
