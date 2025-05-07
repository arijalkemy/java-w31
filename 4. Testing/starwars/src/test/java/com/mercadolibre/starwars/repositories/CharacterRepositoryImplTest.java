package com.mercadolibre.starwars.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class CharacterRepositoryImplTest {

    @Autowired
    private CharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Test
    void testFindAllByNameContains() {
        // Arrange
        String expectedName = "Luke Skywalker";
        String query = "Luke";

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);
        // Assert
        assertTrue(result.stream().anyMatch(character -> character.getName().equals(expectedName)));
    }

    @Test
    void testFindAllByNameContainsEmpty() {
        // Arrange
        String query = "LoremIpsum";

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);
        // Assert
        assertTrue(result.isEmpty());
    }
}
