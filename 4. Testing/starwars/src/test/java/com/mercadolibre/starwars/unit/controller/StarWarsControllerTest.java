package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.StarWarsController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.entity.StarWarsCharacter;
import com.mercadolibre.starwars.service.IStarWarsCharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StarWarsControllerTest {

    @Mock
    IStarWarsCharacterService service;

    @InjectMocks
    StarWarsController controller;


    @Test
    public void getCharactersByDath_shouldReturnListOfCharacters() {
        // Arrange
        List<CharacterDTO> fakeCharacters = List.of(
                new CharacterDTO("Darth Vader", 202, 136, "male", "Tatooine", "Human"),
                new CharacterDTO("Darth Maul", 175, 80, "male", "Dathomir", "Dathomirian")
        );

        when(service.getCharactersByName("Darth")).thenReturn(fakeCharacters);

        // Act
        List<CharacterDTO> result = controller.getCharacterByName("Darth");

        // Assert
        assertEquals(2, result.size());
        assertEquals("Darth Vader", result.get(0).getName());
        assertEquals("Darth Maul", result.get(1).getName());
    }

    @Test
    public void getCharactersByAbbreviative_shouldReturnListOfCharacters() {
        // Arrange
        List<CharacterDTO> onlyLuke = List.of(
                new CharacterDTO("Luke Skywalker", 172, 77, "male", "Tatooine", "Human")
        );

        when(service.getCharactersByName("Lu")).thenReturn(onlyLuke);

        // Act
        List<CharacterDTO> result = controller.getCharacterByName("Lu");

        // Assert
        assertEquals(1, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
    }

    @Test
    public void getCharacters_withBadArguments_shouldReturnEmptyList(){
        // Arrange
        when(service.getCharactersByName(".")).thenReturn(Collections.emptyList());

        // Act
        List<CharacterDTO> result = controller.getCharacterByName(".");

        // Assert
        assertTrue(result.isEmpty());
    }
}
