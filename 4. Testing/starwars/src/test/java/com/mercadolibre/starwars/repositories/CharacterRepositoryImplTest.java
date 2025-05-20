package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {

    private CharacterRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Test unitario happy path findAllByNameContains")
    public void testFindAllByNameContainsHappyPath() {
        //Arrange
        String query = "Luke";

        //Act
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        //Assert
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("Test unitario not found findAllByNameContains")
    public void testFindAllByNameContainsNotFound() {
        //Arrange
        String query = "Carlos";

        //Act
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        //Assert
        assertTrue(result.isEmpty());
    }
}