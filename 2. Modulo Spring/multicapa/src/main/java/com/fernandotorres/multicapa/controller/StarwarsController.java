package com.fernandotorres.multicapa.controller;

import com.fernandotorres.multicapa.dto.PersonajeDTO;
import com.fernandotorres.multicapa.service.impl.PesonajesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarwarsController {

    PesonajesServiceImpl pesonajesService = new PesonajesServiceImpl();

@GetMapping("/getPersonaje/{name}")
    public ResponseEntity<?> getPersonaje(@PathVariable String name){
    List<PersonajeDTO> personajes = pesonajesService.getPersonaje(name);
        return new ResponseEntity(personajes, HttpStatus.OK);
    }
}

/*

Ejercicio Personajes de Star Wars
Se necesita desarrollar un API para buscar por nombre o parte del mismo personajes de Star Wars.


 La misma va a recibir una palabra a buscar y retorna un listado de personajes que contengan esa palabra en su nombre.


Ejemplo:

Si buscamos "Luke" ->  nos mostrará el personaje de "Luke Skywalker"
Si buscamos "Darth" -> nos mostrará el personaje de "Darth Vader" y "Darth Maul".

Tendremos una sola entidad llamada Personaje, con los siguientes atributos:

name
height
mass
hairColor
skinColor
eyeColor
birthYear
gender
homeworld
species
Todos los atributos serán de tipo String, excepto height y mass que serán de tipo entero.


Del personaje, se desea ver todos los atributos menos hairColor, skinColor, eyeColor y birthYear.


Nota: Por el momento no se utilizará ninguna conexión de base de datos, así que utilizaremos el archivo starwars.json como base de datos. Tratar de aplicar la arquitectura multicapa donde sea posible hacerlo.


 */