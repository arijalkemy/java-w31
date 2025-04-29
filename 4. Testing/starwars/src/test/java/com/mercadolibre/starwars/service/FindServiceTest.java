package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.UtilTest;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    List<CharacterDTO> characters;
    @InjectMocks
    private FindService findService;
    @Mock
    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characters = UtilTest.getCharacters();
    }

    @Test
    void testFind() {
        // Arrange
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(List.of(characters.getFirst()));
        // Act
        List<CharacterDTO> result = findService.find("Luke");
        // Assert
        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals("Luke Skywalker", result.getFirst().getName())
        );
    }

    @Test
    void testFindWithEmptyQuery() {
        // Arrange
        when(characterRepository.findAllByNameContains("")).thenReturn(characters);
        // Act
        List<CharacterDTO> result = findService.find("");
        // Assert
        assertAll(
                () -> assertEquals(3, result.size()),
                () -> assertEquals("Luke Skywalker", result.get(0).getName()),
                () -> assertEquals("Leia Organa", result.get(1).getName()),
                () -> assertEquals("Darth Vader", result.get(2).getName())
        );
    }

    @Test
    void testFindWithNonExistentQuery() {
        // Arrange
        when(characterRepository.findAllByNameContains("Yoda")).thenReturn(List.of());
        // Act
        List<CharacterDTO> result = findService.find("Yoda");
        // Assert
        assertAll(
                () -> assertEquals(0, result.size())
        );
    }
}
