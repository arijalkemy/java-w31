package org.example.starwarsnames.repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwarsnames.entity.CharacterStarWars;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepository {
    private List<CharacterStarWars> characters = new ArrayList<>();

    public StarWarsRepository() {
        ObjectMapper mapper = new ObjectMapper();
        File personajesFile = new File("src/main/java/org/example/starwarsnames/utils/starWars.json");

        try {
            characters = mapper.readValue(
                    personajesFile,
                    mapper.getTypeFactory().constructCollectionType(List.class, CharacterStarWars.class)
            );
        } catch (IOException e) {
            System.err.println("Error reading characters.json: " + e.getMessage());
        }
    }

    public List<CharacterStarWars> getCharactersByName(String name) {
        return characters.stream()
                .filter(c -> c.getName().toLowerCase().startsWith(name.toLowerCase()))
                .toList();
    }
}
