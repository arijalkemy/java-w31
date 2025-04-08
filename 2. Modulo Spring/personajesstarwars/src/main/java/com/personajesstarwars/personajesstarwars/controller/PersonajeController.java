package com.personajesstarwars.personajesstarwars.controller;

import com.personajesstarwars.personajesstarwars.dto.PersonajeDTO;
import com.personajesstarwars.personajesstarwars.entity.Personaje;
import com.personajesstarwars.personajesstarwars.service.PersonajeServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    //Inyeccion de dependencia
    private final PersonajeServiceImp personajeServiceImp;

    public PersonajeController(PersonajeServiceImp personajeServiceImp) {
        this.personajeServiceImp = personajeServiceImp;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre){
        List<PersonajeDTO> personajeDTOList = personajeServiceImp.buscarPorNombre(nombre);
        if(personajeDTOList.isEmpty()){
            return ResponseEntity.status(404).body("Personaje no encontrado " + nombre);
        }else{
            return ResponseEntity.ok(personajeDTOList);
        }
    }

    //Solamente para chequear
    @GetMapping("/todos")
    public List<Personaje> mostrar(){
        return personajeServiceImp.mostrarTodo();
    }
}
