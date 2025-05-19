package com.example.personajesstarwars.repository;

import com.example.personajesstarwars.model.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajesRepository {
    private List<Personaje> personajesList;

    public PersonajesRepository() {
        File personajesFile = new
                File("src/main/resources/static/starwars.json");

        ObjectMapper mapper = new ObjectMapper();

        try{
            personajesList = mapper.readValue(personajesFile, mapper.getTypeFactory()
                    .constructCollectionType(List.class, Personaje.class));
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public List<Personaje> getPersonaje(String name) throws IOException {
        return personajesList.stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());
    }
}
