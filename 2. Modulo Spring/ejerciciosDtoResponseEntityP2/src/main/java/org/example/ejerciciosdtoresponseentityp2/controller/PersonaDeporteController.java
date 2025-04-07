package org.example.ejerciciosdtoresponseentityp2.controller;


import org.example.ejerciciosdtoresponseentityp2.model.entity.BdMemoria;
import org.example.ejerciciosdtoresponseentityp2.model.entity.Deporte;
import org.example.ejerciciosdtoresponseentityp2.model.entity.Persona;
import org.example.ejerciciosdtoresponseentityp2.model.entity.PersonaDeporteDto;
import org.example.ejerciciosdtoresponseentityp2.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaDeporteController {

    @Autowired
    DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> obtenerDeportes(){
        BdMemoria bdMemoria = deporteService.cargaDeDatos();
        return new ResponseEntity<>(deporteService.listarDeportes(bdMemoria), HttpStatus.OK)  ;
    }

    @GetMapping("/findSport/{deporte}")
    public ResponseEntity<List<String>> buscarDeportePorNombre(@PathVariable String deporte){
        BdMemoria bdMemoria = deporteService.cargaDeDatos();
        return new ResponseEntity<>(deporteService.encontrarDeportePorNombre(bdMemoria,deporte),HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDto>> obtenerDeportesPersonas(){
        BdMemoria bdMemoria = deporteService.cargaDeDatos();
        List<PersonaDeporteDto> personaDeporteDtos = deporteService.cargaDeDatosPersonaDeportesDto(bdMemoria);
        return new ResponseEntity<>(deporteService.listarPersonasDeportesDto(personaDeporteDtos),HttpStatus.OK);
    }

}
