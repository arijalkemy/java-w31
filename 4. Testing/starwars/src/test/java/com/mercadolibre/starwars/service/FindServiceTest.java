package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    void find_shouldReturnCharacterDTO() {
        // Arrange
        String name = "test";
        List<CharacterDTO> characterDTOS = List.of(new CharacterDTO());
        when(characterRepository.findAllByNameContains(name)).thenReturn(characterDTOS);
        // Act
        List<CharacterDTO> characterDTOSFound = findService.find(name);
        // Assert
        assertNotNull(characterDTOSFound);
        assertEquals(1, characterDTOSFound.size());
        assertEquals(characterDTOSFound.get(0), characterDTOS.get(0));
        verify(characterRepository).findAllByNameContains(name);
    }
}