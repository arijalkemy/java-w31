package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerUnitTest {


    @InjectMocks
    private FindController findController; // El que vamos a testear

    @Mock
    private FindService findService; // Lo que vamos a simular

    @Test
    void find_ShouldReturnListOfCharacters_WhenQueryIsValid() {
        // Arrange
        CharacterDTO character =  new CharacterDTO();
        character.setName("Luke Skywalker");

        List<CharacterDTO> expectedCharacters = List.of(character);
        System.out.println(expectedCharacters.get(0).getName());
        when(findService.find("luke")).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> result = findController.find("luke");

        // Assert
        assertEquals(expectedCharacters, result);
        verify(findService).find("luke");
    }

    @Test
    void find_ShouldReturnEmptyList_WhenQueryNotFound() {
        // Arrange
        when(findService.find("unknown")).thenReturn(List.of());

        // Act
        List<CharacterDTO> result = findController.find("unknown");

        // Assert
        assertTrue(result.isEmpty());
        verify(findService).find("unknown");
    }

}
