package com.fernandotorres.dtoyresponseentity.controller;

import com.fernandotorres.dtoyresponseentity.DTO.DeportistaDTO;
import com.fernandotorres.dtoyresponseentity.model.Deporte;
import com.fernandotorres.dtoyresponseentity.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@RestController
public class DeportistaController {

    public static List<Deporte> DEPORTES = List.of(new Deporte("futbol", 3),
            new Deporte("basket", 1),
            new Deporte("voley", 2),
            new Deporte("handball", 2)
    );

    public static List<Persona> PERSONAS = List.of(new Persona("pedro", "perez", 23),
            new Persona("pablo", "perez", 23),
            new Persona("beto", "perez", 23),
            new Persona("camilo", "perez", 23)
            );

    @GetMapping("/findSports")
    public List<Deporte> getDeportes(){
        return DEPORTES;
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> isDeporte(@PathVariable String name){
        OptionalInt Opnivel = DEPORTES.stream()
                .filter(deporte -> deporte.getNombre().equals(name))
                .mapToInt(deporte -> deporte.getNivel())
                .findFirst();
        Integer nivel =  Opnivel.orElse(0);
        if(nivel == 0){
            return new ResponseEntity<>("el deporte NO esta registrado" , HttpStatus.OK);
        }
        return new ResponseEntity<>("el deporte esta registrado. Nivel: " + nivel , HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getDeportistas(){

        List<DeportistaDTO> deportistas = new ArrayList<>();
        for(int i = 0; i < PERSONAS.size() ; i++){
            DeportistaDTO deportista = new DeportistaDTO();
            deportista.setNombre(PERSONAS.get(i).getNombre());
            deportista.setApellido(PERSONAS.get(i).getApellido());
            deportista.setDeporte(DEPORTES.get(i).getNombre());
            deportistas.add(deportista);
        }
        return new ResponseEntity<>(deportistas,HttpStatus.OK);
    }

}

/*
Ejercicio Deportistas
Hacer deporte es muy importante para la salud. Consideramos una persona deportista a aquella que realice algún tipo de actividad física de forma frecuente.

Para validar si una persona es deportista, se necesita una aplicación que permita relacionar dos entidades:


Persona, cuyos atributos serán:
Nombre
Apellido
Edad

Deporte, cuyos atributos serán:
Nombre
Nivel

Nuestra aplicación deberá contar con la siguiente funcionalidad:


Ver todos los deportes que tenemos cargados.
PATH: /findSports

Consultar si existe un deporte ingresando su nombre. De existir, se deberá mostrar el nivel del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.
PATH: /findSport/{name}

Visualizar a las personas deportistas. Queremos que se vea un listado con el nombre y el apellido de la persona y el nombre del deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado). Para este punto es importante valerse de un DTO.
PATH: /findSportsPersons

Nota: Por el momento no se utilizará ninguna base de datos, así que se manipulan los objetos en listas.


 */