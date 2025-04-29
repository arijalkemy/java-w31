package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;
    @InjectMocks
    FindService service;

    @Test
    void find() {
        // Arrange
        String entrada = "Luke";
        List<CharacterDTO> expectedCharacters = List.of(
                new CharacterDTO("Luke Skywalker", "Blond", "Fair", "Blue", "19BBY", "Male", "Tatooine", "Human", 172, 77),
                new CharacterDTO("Luke Skywalker Jr.", "Blond", "Fair", "Blue", "Unknown", "Male", "Tatooine", "Human", 180, 80)
        );
        when(repository.findAllByNameContains(entrada)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> result = service.find(entrada);

        // Assert
        assertEquals(expectedCharacters.size(), result.size());
        assertTrue(result.stream().anyMatch(a -> a.getName().contains(entrada)));
        assertTrue(result.containsAll(expectedCharacters));  // Verifica que los elementos esperados estén presentes
    }

    //Case sad path
    @Test
    void nonFind(){
        // Arrange
        String entrada = "Miguel";
        List<CharacterDTO> expectedCharacters = new ArrayList<CharacterDTO>();
        when(repository.findAllByNameContains(entrada)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> result = service.find(entrada);

        // Assert
        assertEquals(expectedCharacters.size(), result.size());
        assertFalse(result.stream().anyMatch(a -> a.getName().contains(entrada)));
        assertTrue(result.containsAll(expectedCharacters));  // Verifica que los elementos esperados estén presentes

    }


}
