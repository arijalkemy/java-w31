package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    private FindService service;

    @InjectMocks
    private FindController controller;

    @Test
    @DisplayName("Test happy path find")
    public void testFind() {
        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedCharacters = Arrays.asList(new CharacterDTO("Luke", "blond", "pink", "blue", "19BBY", "male", "Tatooine", "Human", 177, 77));
        when(service.find(query)).thenReturn(expectedCharacters);

        //Act
        List<CharacterDTO> result = controller.find(query);

        //Assert
        assertEquals(expectedCharacters, result);
    }

    @Test
    @DisplayName("Test not found find")
    public void testFindNotFound() {
        //Arrange
        String query = "Luke";
        when(service.find(query)).thenReturn(new ArrayList<>());

        //Act
        List<CharacterDTO> result = controller.find(query);

        //Assert
        assertEquals(new ArrayList<>(), result);
    }
}