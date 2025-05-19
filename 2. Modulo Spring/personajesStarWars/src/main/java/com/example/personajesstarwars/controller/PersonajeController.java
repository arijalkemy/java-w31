package com.example.personajesstarwars.controller;
import com.example.personajesstarwars.model.Personaje;
import com.example.personajesstarwars.service.PersonajeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajeController {
    PersonajeService personajeService;

    private List<Personaje> personajesList;

    @GetMapping("/personaje/{name}")
    public List<Personaje> getPersonaje(@PathVariable String name) throws IOException {
        return PersonajeService.getPersonaje(name);
    }
}
