package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContains_shouldReturnCharacterDTOList() {
        // Arrange
        String name = "Luke";
        // Act
        List<CharacterDTO> dtos = characterRepository.findAllByNameContains(name);
        // Assert
        assertNotNull(dtos);
        assertFalse(dtos.isEmpty());
        dtos.forEach(characterDTO -> assertTrue(characterDTO.getName().contains(name)));
    }

    @Test
    void findAllByNameContains_shouldReturnEmptyList() {
        // Arrange
        String name = "@";
        // Act
        List<CharacterDTO> dtos = characterRepository.findAllByNameContains(name);
        System.out.println(Arrays.toString(dtos.toArray()));
        // Assert
        assertNotNull(dtos);
        assertTrue(dtos.isEmpty());
    }


}