package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFind_WithMatchingQuery_ReturnsCharacterList() {
        // Arrange
        String query = "Harry";

        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Harry Potter");

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Harry Dresden");

        List<CharacterDTO> expectedCharacters = List.of(character1, character2);

        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertEquals(expectedCharacters.size(), result.size());
        assertEquals(expectedCharacters, result);
    }

    @Test
    public void testFind_WithNoMatchingQuery_ReturnsEmptyList() {
        // Arrange
        String query = "NonExistentName";
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of());

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertEquals(0, result.size(), "Expected no characters to be found");
    }
}