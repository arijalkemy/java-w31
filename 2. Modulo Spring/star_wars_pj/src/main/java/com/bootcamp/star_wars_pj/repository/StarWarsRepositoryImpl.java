package com.bootcamp.star_wars_pj.repository;

import com.bootcamp.star_wars_pj.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements IStarWarsRepository {
    private List<Personaje> listPersonaje= new ArrayList();

    public StarWarsRepositoryImpl(){
        try {
            loadDataBase();
        } catch (IOException e) {
            // Manejo de la excepción: loguear el error y continuar
            System.err.println("Error al cargar la base de datos: " + e.getMessage());
        }
    }

    public List<Personaje> findAll() {
        return this.listPersonaje;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:starwars.json");
        List<Personaje> personajes = objectMapper.readValue(file,new TypeReference<List<Personaje>>(){});

        listPersonaje = personajes;
    }
}
