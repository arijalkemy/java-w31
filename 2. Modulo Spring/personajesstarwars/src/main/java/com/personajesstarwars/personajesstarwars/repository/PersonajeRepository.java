package com.personajesstarwars.personajesstarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personajesstarwars.personajesstarwars.entity.Personaje;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//Se encarga de leer el archivo Json y almacenar los personajes en una lista de objetos

@Repository
public class PersonajeRepository {

    private List<Personaje> personajes = new ArrayList<>();


    //Se ejecuta solo una vez para cargar desde el archivo json a la lista personaje
    @PostConstruct
    public void init() { //Se ejecuta gracias a @PostConstruct
        try {
            ObjectMapper mapper = new ObjectMapper(); //Creamos un objeto mapper que se encarga de convertir JSON a Objeto o viceversa
            InputStream inputStream = getClass().getResourceAsStream("/data/starwars1.json"); //Buscamos el archivo y lo abrimos
            personajes = mapper.readValue(inputStream, new TypeReference<List<Personaje>>() {}); // Lee el json y lo convierte en una lista
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Personaje> obtenerTodos() {
        return personajes;
    }
}
