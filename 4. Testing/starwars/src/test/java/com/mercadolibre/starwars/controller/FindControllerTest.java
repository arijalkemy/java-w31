package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.annotation.MultipartConfig;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    void find_shouldReturnDto() {
        // Arrange
        List<CharacterDTO> dtos = Arrays.asList(new CharacterDTO(), new CharacterDTO());
        when(findService.find(anyString())).thenReturn(dtos);
        // Act
        List<CharacterDTO> dtos2 = findController.find(anyString());
        assertNotNull(dtos2);
        assertEquals(dtos.size(), dtos2.size());
        assertArrayEquals(dtos.toArray(), dtos2.toArray());
    }
}