package com.example.starwars.Controller;


import com.example.starwars.DTO.PersonajeDTO;
import com.example.starwars.Services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/buscar/{nombre}/{apellido}")
    public ResponseEntity<List<PersonajeDTO>> buscarPersonajes(
            @PathVariable String nombre,
            @PathVariable String apellido) {

        String nombreCompleto = nombre + " " + apellido;
        List<PersonajeDTO> resultado = personajeService.buscarPorNombre(nombreCompleto);

        if (resultado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultado);
    }



}
