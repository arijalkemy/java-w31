package com.mercadolibre.starwars.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;

@SpringBootTest
public class CharacterRepositoryTest {
    @Autowired
    CharacterRepositoryImpl repository;

    @Test
    public void findAllByNameContainsTest() {
        // Arrange
        String input = "Darth";
        CharacterDTO expectedCharacter = (new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY",
                "male",
                "Tatooine", "Human", 202, 136));

        // Act
        List<CharacterDTO> result = repository.findAllByNameContains(input);

        // Assert
        assertNotNull(result);
        assertTrue(result.stream().anyMatch(c -> expectedCharacter.getName().equals(c.getName())
                && expectedCharacter.getHair_color().equals(c.getHair_color())
                && expectedCharacter.getSkin_color().equals(c.getSkin_color())
                && expectedCharacter.getEye_color().equals(c.getEye_color())
                && expectedCharacter.getBirth_year().equals(c.getBirth_year())
                && expectedCharacter.getGender().equals(c.getGender())
                && expectedCharacter.getHomeworld().equals(c.getHomeworld())
                && expectedCharacter.getSpecies().equals(c.getSpecies())
                && expectedCharacter.getMass().equals(c.getMass())
                && expectedCharacter.getHeight().equals(c.getHeight())));
    }

    @Test
    public void findAllByNameContainsSadPath() {
        // Arrange
        String input = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> repository.findAllByNameContains(input));
    }

    @Test
    public void findAllByNameContainsEmptyResultTest() {
        // Arrange
        String input = "Nonexistent Character";

        // Act
        List<CharacterDTO> result = repository.findAllByNameContains(input);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    public void findAllByNameContainsCaseInsensitiveTest() {
        // Arrange
        String input = "dArTh";
        CharacterDTO expectedCharacter = new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male",
                "Tatooine", "Human", 202, 136);

        // Act
        List<CharacterDTO> result = repository.findAllByNameContains(input);

        // Assert
        assertNotNull(result);
        assertTrue(result.stream()
                .anyMatch(c -> expectedCharacter.getName().equals(c.getName())
                        && expectedCharacter.getHair_color().equals(c.getHair_color())
                        && expectedCharacter.getSkin_color().equals(c.getSkin_color())
                        && expectedCharacter.getEye_color().equals(c.getEye_color())
                        && expectedCharacter.getBirth_year().equals(c.getBirth_year())
                        && expectedCharacter.getGender().equals(c.getGender())
                        && expectedCharacter.getHomeworld().equals(c.getHomeworld())
                        && expectedCharacter.getSpecies().equals(c.getSpecies())
                        && expectedCharacter.getMass().equals(c.getMass())
                        && expectedCharacter.getHeight().equals(c.getHeight())));
    }
}
