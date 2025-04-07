package org.mercadolibre.ejercicio_deportistas.controller;

import org.mercadolibre.ejercicio_deportistas.models.Deporte;
import org.mercadolibre.ejercicio_deportistas.models.DeportePersonaDTO;
import org.mercadolibre.ejercicio_deportistas.service.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {
    private final SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public List<Deporte> findSports() {
       return this.sportService.findSports();
    }

    @GetMapping("findSports/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        Deporte sport = this.sportService.findSport(name);

        if(sport == null) {
            return new ResponseEntity<>("No se encontró el deporte", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(sport.toString(), HttpStatus.OK);
        }
    }

    @GetMapping("/findSportsPersons")
    public List<DeportePersonaDTO> findSportsPersons() {
        return this.sportService.getPersonasYDeportes();
    }
}
