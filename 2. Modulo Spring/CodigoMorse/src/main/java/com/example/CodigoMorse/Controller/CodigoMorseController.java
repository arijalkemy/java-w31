package com.example.CodigoMorse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.CodigoMorse.Service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CodigoMorseController {

    @Autowired
    private CodigoMorseService codigoMorseService;

    @GetMapping("/{codigoMorse}")
    public String getMethodName(@PathVariable String codigoMorse) {
        return codigoMorseService.decodificar(codigoMorse);
    }
}
