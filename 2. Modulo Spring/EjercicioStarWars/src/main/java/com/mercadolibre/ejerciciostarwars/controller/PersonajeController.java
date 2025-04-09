package com.mercadolibre.ejerciciostarwars.controller;

import com.mercadolibre.ejerciciostarwars.dto.PersonajeDto;
import com.mercadolibre.ejerciciostarwars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {
    @Autowired
    private PersonajeServiceImpl personajeServiceImpl;

    @GetMapping("/{nombre}")
    public List<PersonajeDto> getPersonajesPorNombre(@PathVariable String nombre) {
        return personajeServiceImpl.getPersonajesPorNombre(nombre);
    }
}
