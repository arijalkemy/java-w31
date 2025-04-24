package com.fernandotorres.multicapa.repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandotorres.multicapa.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Personaje> personajesFiltrados(String name) {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/starwars.json");
            TypeReference<List<Personaje>> typeReference = new TypeReference<>() {};
            List<Personaje> personajes = objectMapper.readValue(inputStream, typeReference);

            return personajes.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }



}
