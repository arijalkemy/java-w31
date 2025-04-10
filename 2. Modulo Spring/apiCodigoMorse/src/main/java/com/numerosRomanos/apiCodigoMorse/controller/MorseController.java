package com.numerosRomanos.apiCodigoMorse.controller;

import org.springframework.web.bind.annotation.*;
import com.numerosRomanos.apiCodigoMorse.service.LectorMorse;

@RestController
public class MorseController {
    private static LectorMorse lector = new LectorMorse();

    @GetMapping("/{codigoMorse}")
    public String getMensaje(@PathVariable String codigoMorse) {
        return lector.leerMorse(codigoMorse);
    }

    //Lo hago tambien con post para poder enviar el morse por body
    @PostMapping("/morse")
    public String postMensaje(@RequestBody LectorMorse codigoMorse) {
        return lector.leerMorse(codigoMorse.getMorse());
    }
}
