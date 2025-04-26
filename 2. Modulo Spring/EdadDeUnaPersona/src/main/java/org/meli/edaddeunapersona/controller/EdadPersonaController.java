package org.meli.edaddeunapersona.controller;

import lombok.RequiredArgsConstructor;
import org.meli.edaddeunapersona.model.entity.Persona;
import org.meli.edaddeunapersona.service.EdadPersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EdadPersonaController {

    private final EdadPersonaService edadPersonaService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String obtenerEdad (@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        Persona persona = new Persona(dia, mes, anio);
        int edad = edadPersonaService.calcularEdad(persona);
        return "Edad: " + edad + " años";
    }
}