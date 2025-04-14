package com.starwars.ejerciciovivoinyeccion.controller;

import com.starwars.ejerciciovivoinyeccion.dto.PersonajeDTO;
import com.starwars.ejerciciovivoinyeccion.entity.Personaje;
import com.starwars.ejerciciovivoinyeccion.repository.StarRepository;
import com.starwars.ejerciciovivoinyeccion.services.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarController {
    @Autowired
    private StarService service;

    @GetMapping("/{query}")
    public List<PersonajeDTO> find(@PathVariable String query) {
        return service.find(query);
    }

}
