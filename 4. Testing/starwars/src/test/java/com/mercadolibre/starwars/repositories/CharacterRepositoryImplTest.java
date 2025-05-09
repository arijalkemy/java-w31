package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    }


}