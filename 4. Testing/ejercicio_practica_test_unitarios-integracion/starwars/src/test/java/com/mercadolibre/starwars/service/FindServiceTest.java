package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository repoMock;

    @InjectMocks
    FindService service;

    @Test
    void find_delegatesToRepository_andReturnsResult() {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        List<CharacterDTO> expected = List.of(characterDTO);
        when(repoMock.findAllByNameContains("Luke")).thenReturn(expected);
        List<CharacterDTO> result = service.find("Luke");
        assertEquals(expected, result);
        verify(repoMock).findAllByNameContains("Luke");
    }

    @Test
    void find_emptyQuery_returnsRepositoryResults() {
        when(repoMock.findAllByNameContains("")).thenReturn(List.of());
        assertTrue(service.find("").isEmpty());
    }

    @Test
    void find_nullQuery_returnsRepositoryResults() {
        when(repoMock.findAllByNameContains(null)).thenReturn(List.of());
        assertTrue(service.find(null).isEmpty());
    }
}