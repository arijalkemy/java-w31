package com.example.deportistas.controller;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.entity.Deporte;
import com.example.deportistas.service.DeporteService;
import com.example.deportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private final DeporteService deporteService;
    private final PersonaService personaService;

    @Autowired
    public Controller(DeporteService deporteService, PersonaService personaService){
        this.deporteService = deporteService;
        this.personaService = personaService;
    }

    @GetMapping("/finSports")
    public List<Deporte> findSports(){
        return deporteService.getDeportes();
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> findByName(@PathVariable("name") String name){
        return deporteService.findDeporteByName(name);
    }

    @GetMapping("/findSportsPersons")
    public List<DeporteDTO> findSportsPerson(){
        return personaService.getDeporte();
    }
}
