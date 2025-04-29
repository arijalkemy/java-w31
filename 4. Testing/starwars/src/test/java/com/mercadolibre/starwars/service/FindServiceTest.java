package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindServiceTest {
    private FindService findService;
    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = mock(CharacterRepository.class);
        findService = new FindService(characterRepository);
    }

    @Test
    void testFindReturnsMatchingCharacters() {
        // Arrange
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");

        when(characterRepository.findAllByNameContains("Luke"))
                .thenReturn(List.of(character));

        // Act
        List<CharacterDTO> result = findService.find("Luke");

        // Assert
        verify(characterRepository, times(1)).findAllByNameContains("Luke");
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getName()).contains("Luke");
    }

    @Test
    void testFindReturnsEmptyListIfNoMatch() {
        when(characterRepository.findAllByNameContains("NoExiste"))
                .thenReturn(List.of());

        List<CharacterDTO> result = findService.find("NoExiste");

        verify(characterRepository, times(1)).findAllByNameContains("NoExiste");
        assertThat(result).isEmpty();
    }
}
