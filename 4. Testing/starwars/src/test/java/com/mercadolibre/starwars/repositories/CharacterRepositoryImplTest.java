package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {

    @Spy
    private CharacterRepositoryImpl characterRepository;

    private List<CharacterDTO> testDatabase;

    @BeforeEach
    void setUp() {
        // Create test database
        testDatabase = new ArrayList<>();

        CharacterDTO lukeSkywalker = new CharacterDTO();
        lukeSkywalker.setName("Luke Skywalker");
        lukeSkywalker.setHeight(172);
        lukeSkywalker.setMass(77);
        lukeSkywalker.setHair_color("blond");
        testDatabase.add(lukeSkywalker);

        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setHeight(202);
        darthVader.setMass(136);
        darthVader.setHair_color("none");
        testDatabase.add(darthVader);

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        darthMaul.setHeight(175);
        darthMaul.setMass(80);
        darthMaul.setHair_color("none");
        testDatabase.add(darthMaul);

        // Inject the test database into the repository
        ReflectionTestUtils.setField(characterRepository, "database", testDatabase);
    }

    @Test
    void findAllByNameContains_WithLuke_ShouldReturnLukeSkywalker() {
        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
    }

    @Test
    void findAllByNameContains_WithDarth_ShouldReturnTwoCharacters() {
        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Darth");

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(c -> c.getName().equals("Darth Vader")));
        assertTrue(result.stream().anyMatch(c -> c.getName().equals("Darth Maul")));
    }

    @Test
    void findAllByNameContains_WithNonExistentName_ShouldReturnEmptyList() {
        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("NonExistent");

        // Assert
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void findAllByNameContainsWithEmptyQueryShouldReturnAll() {
        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("");

        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    void findAllByNameContains_CaseInsensitive_ShouldWork() {
        // Act
        List<CharacterDTO> result1 = characterRepository.findAllByNameContains("luke");
        List<CharacterDTO> result2 = characterRepository.findAllByNameContains("LUKE");
        List<CharacterDTO> result3 = characterRepository.findAllByNameContains("Luke");

        // Assert
        assertEquals(1, result1.size());
        assertEquals(1, result2.size());
        assertEquals(1, result3.size());
        assertEquals("Luke Skywalker", result1.get(0).getName());
        assertEquals("Luke Skywalker", result2.get(0).getName());
        assertEquals("Luke Skywalker", result3.get(0).getName());
    }
}