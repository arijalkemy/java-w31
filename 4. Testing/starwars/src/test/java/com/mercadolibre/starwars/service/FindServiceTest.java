package com.mercadolibre.starwars.service;

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
import com.mercadolibre.starwars.repositories.CharacterRepository;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    void testFind() {
        // Arrange
        String query = "Luke";
        String expectedName = "Luke Skywalker";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(expectedName);
        List<CharacterDTO> expectedCharacters = List.of(characterDTO);
        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        verify(characterRepository, atLeast(1)).findAllByNameContains(query);
        assertTrue(result.stream().anyMatch(character -> character.getName().equals(expectedName)));
    }

    @Test
    void testFindEmpty() {
        // Arrange
        String query = "LoremIpsum";
        List<CharacterDTO> expectedCharacters = List.of();
        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        verify(characterRepository, atLeast(1)).findAllByNameContains(query);
        assertTrue(result.isEmpty());
    }
}
