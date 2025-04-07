package com.mercadolibre.edad_persona.controller;

import com.mercadolibre.edad_persona.service.EdadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    private EdadService edadService;

    @GetMapping ("/{dia}/{mes}/{anio}")
    public ResponseEntity<Object> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        try {
            Integer edad = edadService.calcularEdad(dia, mes, anio);
            return new ResponseEntity<>(edad, HttpStatus.OK);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // En caso de error, devuelve 400
        }
        catch (Exception e) {
            return new ResponseEntity<>("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR); // Error inesperado
        }
    }

}
