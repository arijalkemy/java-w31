package com.fernandotorres.dtoyresponseentity.controller;

import com.fernandotorres.dtoyresponseentity.DTO.PersonaDTO;
import com.fernandotorres.dtoyresponseentity.model.Persona;
import com.fernandotorres.dtoyresponseentity.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CovidController {

    public static List<Sintoma> SINTOMAS = List.of(new Sintoma(1, "tos" , 1),
            new Sintoma(1, "fiebre" , 1),
            new Sintoma(1, "dolor de cabeza" , 1),
            new Sintoma(1, "sin olfato" , 1),
            new Sintoma(1, "dolor corporal" , 1)
            );

    public static List<Persona> PERSONAS = List.of(new Persona("pedro", "perez", 23),
            new Persona("pablo", "perez", 80),
            new Persona("beto", "perez", 23),
            new Persona("camilo", "perez", 150)
    );



    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSintoma(@PathVariable String name){
        for (Sintoma sintoma : SINTOMAS){
            if(sintoma.getNombre().equals(name)){
                return new ResponseEntity<>("el sintoma fue encontrado y su nivel de gravedad es: " + sintoma.getNivel_de_gravedad() , HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("el sintoma no fue encontrado "  , HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findRiskPerson(){
        List<PersonaDTO> personasDTO = new ArrayList<>();
        for(Persona persona : PERSONAS){
            if(persona.getEdad()>60){
                personasDTO.add(new PersonaDTO(persona.getNombre(), persona.getApellido()));
            }
        }

        return ResponseEntity.ok(personasDTO); // <-- forma simple y correcta

    }

    //Visualizar a las personas que puedan ser del grupo de riesgo.
    // Para ello, necesitamos visualizar un listado con el nombre y el apellido de aquellas personas mayores \
    // de 60 años que puedan poseer al menos un síntoma asociado.
    // Como para la respuesta de esta consulta habrá que tener en cuenta la relación entre las dos tablas, se recomienda utilizar el patrón DTO.
    //PATH: /findRiskPerson
}


/*

Ejercicio Covid-19
Una entidad de la salud necesita del desarrollo de una API para realizar consultas respecto a la salud de una persona teniendo en cuenta determinados síntomas que pueda presentar.

Para esto, tendremos dos clases:


Persona, cuyos atributos serán:
id
nombre
apellido
edad

Síntoma, cuyos atributos serán:
codigo
nombre
nivel_de_gravedad

Nuestra aplicación deberá contar con la siguiente funcionalidad:


Ver todos los síntomas que tenemos cargados.
PATH: /findSymptom
Consultar si existe un síntoma ingresando su nombre. De existir, se deberá mostrar el nivel de gravedad del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.
PATH: /findSymptom/{name}

Visualizar a las personas que puedan ser del grupo de riesgo. Para ello, necesitamos visualizar un listado con el nombre y el apellido de aquellas personas mayores de 60 años que puedan poseer al menos un síntoma asociado. Como para la respuesta de esta consulta habrá que tener en cuenta la relación entre las dos tablas, se recomienda utilizar el patrón DTO.
PATH: /findRiskPerson

Nota: Por el momento no se utilizará ninguna base de datos, por lo cual, los diferentes objetos se deben manejar mediante listas dinámicas (collections).


 */