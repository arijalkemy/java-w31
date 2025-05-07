package com.mercadolibre.starwars.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    void testFind() {
        // Arrange
        String query = "Luke";
        String expectedName = "Luke Skywalker";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(expectedName);
        List<CharacterDTO> expectedCharacters = List.of(characterDTO);
        when(findService.find(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> result = findController.find(query);

        // Assert
        verify(findService, atLeast(1)).find(query);
        assertTrue(result.stream().anyMatch(character -> character.getName().equals(expectedName)));
    }

    @Test
    void testFindEmpty() {
        // Arrange
        String query = "LoremIpsum";
        List<CharacterDTO> expectedCharacters = List.of();
        when(findService.find(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> result = findController.find(query);

        // Assert
        verify(findService, atLeast(1)).find(query);
        assertTrue(result.isEmpty());
    }
}
