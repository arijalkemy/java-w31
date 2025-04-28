package com.mercadolibre.starwars.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;

@SpringBootTest
public class FindControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void findTest() {
        // Arrange
        String input = "Darth";
        CharacterDTO expectedCharacter = (new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY",
                "male", "Tatooine", "Human", 202, 136));
        List<CharacterDTO> expectedResult = List.of(expectedCharacter);
        Mockito.when(service.find(input)).thenReturn(expectedResult);

        // Act
        List<CharacterDTO> result = controller.find(input);

        // Assert
        assertNotNull(result);
        verify(service, atLeast(1)).find(input);
        assertTrue(result.stream().anyMatch(c -> expectedCharacter.getName().equals(c.getName())
                && expectedCharacter.getHair_color().equals(c.getHair_color())
                && expectedCharacter.getSkin_color().equals(c.getSkin_color())
                && expectedCharacter.getEye_color().equals(c.getEye_color())
                && expectedCharacter.getBirth_year().equals(c.getBirth_year())
                && expectedCharacter.getGender().equals(c.getGender())
                && expectedCharacter.getHomeworld().equals(c.getHomeworld())
                && expectedCharacter.getSpecies().equals(c.getSpecies())
                && expectedCharacter.getMass().equals(c.getMass())
                && expectedCharacter.getHeight().equals(c.getHeight())));
    }
}
