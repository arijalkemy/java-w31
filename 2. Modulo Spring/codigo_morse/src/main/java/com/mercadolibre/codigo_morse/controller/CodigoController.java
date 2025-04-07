package com.mercadolibre.codigo_morse.controller;

import com.mercadolibre.codigo_morse.service.ICodigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoController {

    @Autowired
    ICodigoService codigoService;

    @GetMapping("/descifrar/{codigo}")
    public String descifrarCodigo(@PathVariable String codigo){
        return codigoService.descifrarCodigoService(codigo);
    }



}
