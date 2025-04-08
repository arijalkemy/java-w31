package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.PersonajeServiceImpl;
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
    private PersonajeServiceImpl personajeService;
    @Autowired
    private PersonajeServiceImpl personajeServiceImpl;

    @GetMapping("/{nombre}")
    public List<PersonajeDTO> getPersonajesPorNombre(@PathVariable String nombre) {
        return personajeServiceImpl.getPersonajePorNombre(nombre);
    }
}
