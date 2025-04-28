package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.entity.StarWarsCharacter;
import com.mercadolibre.starwars.repository.StarWarsCharacterRepository;
import com.mercadolibre.starwars.service.StarWarsCharacterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StarWarsCharacterServiceTest {

    @Mock
    StarWarsCharacterRepository repository;
    @InjectMocks
    StarWarsCharacterService service;

    @Test
    public void getCharactersByDath_shouldReturnListOfCharacters() {
    // Arrange
    List<StarWarsCharacter> fakeCharacters = List.of(
            new StarWarsCharacter("Darth Vader", 202, 136, "none", "white",
                            "yellow", "41.9BBY", "male", "Tatooine", "Human"),
            new StarWarsCharacter("Darth Maul", 175, 80, "none", "red",
                    "yellow", "54BBY", "male", "Dathomir", "Dathomirian"),
            new StarWarsCharacter("Luke Skywalker", 172, 77, "blond", "fair",
                    "blue", "19BBY", "male", "Tatooine", "Human")
    );

    when(repository.getCharacters()).thenReturn(fakeCharacters);

    // Act
    List<CharacterDTO> result = service.getCharactersByName("Darth");

    // Assert
    assertEquals(2, result.size());
    assertEquals("Darth Vader", result.get(0).getName());
    assertEquals("Darth Maul", result.get(1).getName());
}

    @Test
    public void getCharactersByAbbreviative_shouldReturnListOfCharacters() {
        // Arrange
        List<StarWarsCharacter> fakeCharacters = List.of(
                new StarWarsCharacter("Darth Vader", 202, 136, "none", "white",
                        "yellow", "41.9BBY", "male", "Tatooine", "Human"),
                new StarWarsCharacter("Darth Maul", 175, 80, "none", "red",
                        "yellow", "54BBY", "male", "Dathomir", "Dathomirian"),
                new StarWarsCharacter("Luke Skywalker", 172, 77, "blond", "fair",
                        "blue", "19BBY", "male", "Tatooine", "Human")
        );

        when(repository.getCharacters()).thenReturn(fakeCharacters);

        // Act
        List<CharacterDTO> result = service.getCharactersByName("Lu");

        // Assert
        assertEquals(1, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
    }

    @Test
    public void getCharacters_withBadArguments_shouldReturnEmptyList(){
        // Arrange
        List<StarWarsCharacter> fakeCharacters = List.of(
                new StarWarsCharacter("Darth Vader", 202, 136, "none", "white",
                        "yellow", "41.9BBY", "male", "Tatooine", "Human"),
                new StarWarsCharacter("Darth Maul", 175, 80, "none", "red",
                        "yellow", "54BBY", "male", "Dathomir", "Dathomirian"),
                new StarWarsCharacter("Luke Skywalker", 172, 77, "blond", "fair",
                        "blue", "19BBY", "male", "Tatooine", "Human")
        );

        when(repository.getCharacters()).thenReturn(fakeCharacters);

        // Act
        List<CharacterDTO> result = service.getCharactersByName(".");

        // Assert
        assertTrue(result.isEmpty());
    }
}

