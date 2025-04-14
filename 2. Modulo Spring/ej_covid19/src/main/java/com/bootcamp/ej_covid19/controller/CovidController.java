package com.bootcamp.ej_covid19.controller;

import com.bootcamp.ej_covid19.model.Persona;
import com.bootcamp.ej_covid19.dto.PersonaDTO;
import com.bootcamp.ej_covid19.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CovidController {
    //simulando una base de datos
    private List<Sintoma> sintomas;
    private List<Persona> personas;

    public CovidController() {
        sintomas = new ArrayList<>();
        personas = new ArrayList<>();

        sintomas.add(new Sintoma("Fiebre", "001", "Leve"));
        sintomas.add(new Sintoma("Tos", "002", "Media"));
        sintomas.add(new Sintoma("Dificultad para respirar", "003", "Alta"));

        personas.add(new Persona(1, "Nora", "Carullo", 78, List.of(String.valueOf(sintomas.get(0))))); // Fiebre
        personas.add(new Persona(2, "Marianela", "Carullo", 55, List.of())); // Sin síntomas
        personas.add(new Persona(3, "Pedro", "Tonelli", 60, List.of(String.valueOf(sintomas.get(2))))); // Dificultad para respirar
    }

    // Ver todos los síntomas cargados
    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptoms() {
        return ResponseEntity.ok(sintomas);
    }

    //Consultar si existe un síntoma ingresando su nombre
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable("name") String name) {
        Optional<Sintoma> symptomOptional = sintomas.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(name))
                .findFirst();

        if (symptomOptional.isPresent()) {
            return ResponseEntity.ok("Nivel de gravedad: " + symptomOptional.get().getNivelDeGravedad());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Síntoma no encontrado.");
        }
    }

    //Visualizar a las personas que puedan ser del grupo de riesgo
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findRiskPersons() {
        List<PersonaDTO> riskPersons = new ArrayList<>();

        for (Persona persona : personas) {
            if (persona.getEdad() > 60 && !persona.getSintomas().isEmpty()) {
                riskPersons.add(new PersonaDTO(persona.getNombre(), persona.getApellido()));
            }
        }

        return ResponseEntity.ok(riskPersons);
    }
}
