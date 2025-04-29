package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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

public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

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

        when(findService.find(testQuery)).thenReturn(expectedCharacters);
    }

    @Test
    void find_ShouldCallServiceWithQuery() {
        // Act
        List<CharacterDTO> result = findController.find(testQuery);

        // Assert
        verify(findService, times(1)).find(testQuery);
        assertNotNull(result);
        assertEquals(expectedCharacters, result);
    }

    @Test
    void find_WithEmptyQuery_ShouldCallServiceWithEmptyString() {
        // Arrange
        String emptyQuery = "";
        when(findService.find(emptyQuery)).thenReturn(new ArrayList<>());

        // Act
        List<CharacterDTO> result = findController.find(emptyQuery);

        // Assert
        verify(findService, times(1)).find(emptyQuery);
        assertNotNull(result);
    }

    @Test
    void find_WithNullQuery_ShouldCallServiceWithNull() {
        // Arrange
        String nullQuery = null;
        when(findService.find(nullQuery)).thenReturn(new ArrayList<>());

        // Act
        List<CharacterDTO> result = findController.find(nullQuery);

        // Assert
        verify(findService, times(1)).find(nullQuery);
        assertNotNull(result);
    }
}