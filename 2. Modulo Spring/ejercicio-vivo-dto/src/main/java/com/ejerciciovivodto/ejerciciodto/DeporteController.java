package com.ejerciciovivodto.ejerciciodto;

import com.ejerciciovivodto.ejerciciodto.dto.PersonaDTO;
import com.ejerciciovivodto.ejerciciodto.model.Deporte;
import com.ejerciciovivodto.ejerciciodto.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {
    Deporte deporte = new Deporte("Basquet", 6);
    Deporte deporte2 = new Deporte("Futbol", 5);
    Deporte deporte3 = new Deporte("Voley", 2);
    Persona persona = new Persona(1, "Juan", "Perez", 23);
    Persona persona2 = new Persona(2, "Marco", "Gonzalez", 15);
    Persona persona3 = new Persona(3, "Franco", "Alb", 19);

    List<Deporte> listaDeporte = List.of(deporte, deporte2, deporte3);
    List<Persona> listaPersona = List.of(persona, persona2, persona3);

    @GetMapping("/findSports")
    public List<Deporte> verEnfermedades(){
        return listaDeporte;
    }

    @GetMapping("/findSports/{name}")
    ResponseEntity<String> gravedadSintoma(@PathVariable String name){
        var deporte = listaDeporte.stream().filter(x-> x.getNombre().equalsIgnoreCase(name)).findFirst();

        return deporte.map(value -> ResponseEntity.ok()
                .header("Estado deporte", "Deporte: " + value.getNombre())
                .body("Nivel del deporte: " + value.getNivel())).orElseGet(() -> ResponseEntity.badRequest().body("No se encontró el sintoma"));
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    ResponseEntity<List<PersonaDTO>> personaRiesgo() {
        List<PersonaDTO> personasDTO = new ArrayList<>();

        for (Persona perso : listaPersona) {
            PersonaDTO personaDto = new PersonaDTO();
            personaDto.setNombreCompleto(perso.getNombre() + " " + perso.getApellido());
            personaDto.setNombreDeporte(deporte.getNombre());
            personaDto.setId(perso.getId());

            personasDTO.add(personaDto);
        }

        return ResponseEntity.ok()
                .header("Estado persona riesgo", "Persona riesgo")
                .body(personasDTO);
    }
}
