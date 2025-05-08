package com.spring.personajesdestarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.personajesdestarwars.model.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class PersonajeRepository {

    private final ObjectMapper mapper = new ObjectMapper();

    public List<Personaje> getCharacters() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/starwars.json"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            return mapper.readValue(content.toString(), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
