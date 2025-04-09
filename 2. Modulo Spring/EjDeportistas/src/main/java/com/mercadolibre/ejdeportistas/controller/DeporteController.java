package com.mercadolibre.ejdeportistas.controller;

import com.mercadolibre.ejdeportistas.dto.DeportistaDTO;
import com.mercadolibre.ejdeportistas.model.Deporte;
import com.mercadolibre.ejdeportistas.model.Persona;
import com.mercadolibre.ejdeportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public List<Deporte> findAllDeportes() {
        return deporteService.findAllDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> findDeporteByName(@PathVariable String name) {
        Deporte deporte = deporteService.findDeporteByName(name).orElse(null);
        if (deporte != null) {
            return ResponseEntity.ok(deporte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> findAllDeportistas() {
        return deporteService.findAllDeportistas();
    }
}