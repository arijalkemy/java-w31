package com.starwars.starwars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.model.Characters;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository {

    public List<Characters> getCharactersByNameMatch(String searchWord) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Characters[] charactersArray = mapper.readValue(new File("/Users/caseoane/Documents/Repositorios/java-w31/2. Modulo Spring/3-multicapas/star-wars/src/main/resources/starwars.json"), Characters[].class);
            List<Characters> characters = Arrays.asList(charactersArray);

            List<Characters> filteredList = characters.stream().filter(c -> c.getName().toLowerCase().contains(searchWord.toLowerCase())).collect(Collectors.toList());
            if (filteredList.isEmpty()) {
                throw new Exception("Character not found");
            }
            return filteredList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
