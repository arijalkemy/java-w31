package com.ejerciciodto.ejerciciodto;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class aController {
    /*@GetMapping("cabecera/{cliente}")
    ResponseEntity<String> cabeceraPersonalizada(@PathVariable String cliente){
        //HttpHeaders cabecera = new HttpHeaders();
        //cabecera.add("Estado cliente", "Cliente: " + cliente + " habilitado");

        return ResponseEntity.ok()
                .header("Estado cliente", "Cliente: " + cliente + " habilitado")
                .body("Bienvenido: " + cliente);
    }*/
    Sintoma sintoma = new Sintoma("14", "Tos", "2");
    Sintoma sintoma2 = new Sintoma("23", "Fiebre", "2");
    Sintoma sintoma3 = new Sintoma("82", "Angina", "6");
    Persona persona = new Persona(1, "Juan", "Perez", 23);
    Persona persona2 = new Persona(2, "Marco", "Gonzalez", 88);
    Persona persona3 = new Persona(3, "Franco", "Alb", 65);

    List<Sintoma> listaSintomas = List.of(sintoma, sintoma2, sintoma3);
    List<Persona> listaPersona = List.of(persona, persona2, persona3);

    @GetMapping("/findSymptom")
    public List<Sintoma> verEnfermedades(){
        return listaSintomas;
    }

    @GetMapping("/findSymptom/{name}")
    ResponseEntity<String> gravedadSintoma(@PathVariable String name){
        var sintoma = listaSintomas.stream().filter(x-> x.getNombre().equalsIgnoreCase(name)).findFirst();

        return sintoma.map(value -> ResponseEntity.ok()
                .header("Estado sintoma", "Sintoma: " + value.getNombre())
                .body("Nivel de gravedad: " + value.getNivel_de_gravedad())).orElseGet(() -> ResponseEntity.badRequest().body("No se encontró el sintoma"));
    }

    @GetMapping("/findRiskPerson")
    @ResponseBody
    ResponseEntity<List<PersonaDto>> personaRiesgo(){
        List<PersonaDto> personasDTO = new ArrayList<>();

        for (Persona perso : listaPersona) {
            PersonaDto personaDto = new PersonaDto();
            personaDto.setNombreCompleto(perso.getNombre() + " " + perso.getApellido());
            personaDto.setEdad(perso.getEdad());
            personaDto.setNombreSintoma(sintoma.getNombre());
            personaDto.setId(perso.getId());

            personasDTO.add(personaDto);
        }

        var riesgo = personasDTO.stream()
                                .filter(x->x.getEdad() >= 60)
                                .collect(Collectors.toList());

        /*String respuesta = "Personas de riesgo: " + riesgo.stream()
                .map(PersonaDto::getNombreCompleto)
                .collect(Collectors.joining(", "));*/

        return ResponseEntity.ok()
                .header("Estado persona riesgo", "Persona riesgo")
                .body(riesgo);
    }

}
