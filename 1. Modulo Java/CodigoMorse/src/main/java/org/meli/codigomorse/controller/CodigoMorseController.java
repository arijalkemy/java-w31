package org.meli.codigomorse.controller;

import lombok.RequiredArgsConstructor;
import org.meli.codigomorse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CodigoMorseController {

    @PostMapping("/morseTotText")
    public String morseToText(@RequestParam String morse) {
        return CodigoMorseService.translateToText(morse);
    }
}