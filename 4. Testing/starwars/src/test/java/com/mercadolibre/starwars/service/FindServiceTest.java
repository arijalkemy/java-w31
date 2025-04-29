package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    private List<CharacterDTO> expectedCharacters;
    private final String testQuery = "Luke";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        expectedCharacters = new ArrayList<>();
        CharacterDTO lukeSkywalker = new CharacterDTO();
        lukeSkywalker.setName("Luke Skywalker");
        lukeSkywalker.setHeight(172);
        lukeSkywalker.setMass(77);
        lukeSkywalker.setHair_color("blond");
        expectedCharacters.add(lukeSkywalker);

        when(characterRepository.findAllByNameContains(testQuery)).thenReturn(expectedCharacters);
    }

    @Test
    void find_WithValidQuery_ShouldReturnMatchingCharacters() {
        // Act
        List<CharacterDTO> result = findService.find(testQuery);

        // Assert
        verify(characterRepository, times(1)).findAllByNameContains(testQuery);
        assertNotNull(result);
        assertEquals(expectedCharacters.size(), result.size());
        assertEquals(expectedCharacters, result);
    }

    @Test
    void find_WithEmptyQuery_ShouldPassEmptyStringToRepository() {
        // Arrange
        String emptyQuery = "";
        List<CharacterDTO> emptyList = new ArrayList<>();
        when(characterRepository.findAllByNameContains(emptyQuery)).thenReturn(emptyList);

        // Act
        List<CharacterDTO> result = findService.find(emptyQuery);

        // Assert
        verify(characterRepository, times(1)).findAllByNameContains(emptyQuery);
        assertEquals(emptyList, result);
    }

    @Test
    void find_WithNullQuery_ShouldPassNullToRepository() {
        // Arrange
        String nullQuery = null;
        List<CharacterDTO> emptyList = new ArrayList<>();
        when(characterRepository.findAllByNameContains(nullQuery)).thenReturn(emptyList);

        // Act
        List<CharacterDTO> result = findService.find(nullQuery);

        // Assert
        verify(characterRepository, times(1)).findAllByNameContains(nullQuery);
        assertEquals(emptyList, result);
    }
}