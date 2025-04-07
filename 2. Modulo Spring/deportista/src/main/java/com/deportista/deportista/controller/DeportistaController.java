package com.deportista.deportista.controller;

import com.deportista.deportista.dto.PersonaDeportistaDTO;
import com.deportista.deportista.model.Deporte;
import com.deportista.deportista.service.DeportistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistaController {

    DeportistaService service = new DeportistaService();

    @GetMapping("/findSports")
    public List<Deporte> obtenerDeportes(){
        return service.getListaDeportes();
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<String> consultarDeporte(@PathVariable String name){
        return service.buscarDeportePorNombre(name)
                .map(d -> ResponseEntity.ok("Nivel: "+d.getNivel()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findSportsPersonas")
    public List<PersonaDeportistaDTO> obtenerPersonasDeportistas(){
        return service.verPersonasDeportistas();
    }
}
