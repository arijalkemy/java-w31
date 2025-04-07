package com.covid19.covid19.controller;

import com.covid19.covid19.dto.PersonaConSintomaDTO;
import com.covid19.covid19.model.Sintoma;
import com.covid19.covid19.service.Covid19Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid19Controller {
    Covid19Service service = new Covid19Service();

    @GetMapping("findSymptom")
    public List<Sintoma> listaDeSintomas(){
        return service.getSintomasCargados();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> consultarSintoma(@PathVariable String name){
        return service.consultarSintoma(name)
                .map(m -> ResponseEntity.ok("Nivel de Gravedad: " + m.getNivelDeGravedad()))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaConSintomaDTO> getPersonasConSintomas(){
        return service.getPersonasConSintomasMayores();
    }
}
