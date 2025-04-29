package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterRepositoryImplTest {
    private CharacterRepositoryImpl repository;

    @BeforeEach
    void setUp(){
        repository = new CharacterRepositoryImpl(); //arrange
    }

    @Test
    void testFindCharacterByExactName() {
        // Act
        List<CharacterDTO> result = repository.findAllByNameContains("Luke");

        // Assert
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getName()).containsIgnoringCase("Luke");
    }

    @Test
    void testFindCharacterByPartialName() {
        List<CharacterDTO> result = repository.findAllByNameContains("Darth");
        assertThat(result).isNotEmpty();
        assertThat(result.stream().anyMatch(c -> c.getName().contains("Darth"))).isTrue();
    }

    @Test
    void testNoCharacterFound() {
        List<CharacterDTO> result = repository.findAllByNameContains("NoExiste");
        assertThat(result).isEmpty();
    }

    @Test
    void testEmptyQueryReturnsAllCharacters() {
        List<CharacterDTO> result = repository.findAllByNameContains("");
        assertThat(result).isNotEmpty();
    }
}
