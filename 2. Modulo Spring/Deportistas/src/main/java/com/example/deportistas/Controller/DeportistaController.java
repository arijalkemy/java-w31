package com.example.deportistas.Controller;

import com.example.deportistas.DTO.DeportistaDTO;
import com.example.deportistas.Model.Deporte;
import com.example.deportistas.Services.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DeportistaController {

    @Autowired
    private DeportistaService deporteService;

    @GetMapping("/findSports")
    public List<Deporte> getAllSports() {
        return deporteService.getTodosLosDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getSportByName(@PathVariable String name) {
        return deporteService.buscarDeportePorNombre(name)
                .map(deporte -> ResponseEntity.ok("Nivel: " + deporte.getNivel()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> getSportsPersons() {
        return deporteService.getPersonasDeportistas();
    }
}
