package com.mercadolibre.ejerciciodto.controller;

import com.mercadolibre.ejerciciodto.entidades.Deporte;
import com.mercadolibre.ejerciciodto.entidades.PersonaDTO;
import com.mercadolibre.ejerciciodto.service.EncontrarDeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EncontrarDeporteController {
    private EncontrarDeporteService servicio;
    public EncontrarDeporteController(EncontrarDeporteService servicio){
        this.servicio = servicio;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getDeportes() {
        return new ResponseEntity<>(this.servicio.getListaDeporte(), HttpStatus.OK);
    }
    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<String> getDeporteFiltrado(@PathVariable String nombre){
       return new ResponseEntity<>(this.servicio.getNivelDelDeporte(nombre), HttpStatus.OK) ;
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<String>> getPersonasDeportistas(){
        return new ResponseEntity<>(this.servicio.getPersonasDeportistas(), HttpStatus.OK);
    }

}
