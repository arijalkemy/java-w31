package com.bootcamp.ejercicio_dtoresponseentity.controlador;

import com.bootcamp.ejercicio_dtoresponseentity.dto.PersonaDeporteDto;
import com.bootcamp.ejercicio_dtoresponseentity.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDto>> findSportsPersons() {
        return new ResponseEntity<>(personaService.getAllWithSport(), HttpStatus.OK);
    }
}
