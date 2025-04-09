package com.mercadolibre.ejnumerosromanos.controller;

import com.mercadolibre.ejnumerosromanos.service.RomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romanos")
public class RomanosController {
    @Autowired
    private RomanosService romanosService;

    @GetMapping("/{numero}")
    public ResponseEntity<String> convertirARomanos(@PathVariable Integer numero) {
        try {
            String resultado = romanosService.convertirARomanos(numero);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
