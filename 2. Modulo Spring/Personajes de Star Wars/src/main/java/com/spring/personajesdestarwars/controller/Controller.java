package com.spring.personajesdestarwars.controller;

import com.spring.personajesdestarwars.model.dto.PersonajeDto;
import com.spring.personajesdestarwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/findCharacter/{name}")
    public List<PersonajeDto> getCharacterByName(@PathVariable String name) {
        return this.personajeService.getCharactersByName(name);
    }
}
