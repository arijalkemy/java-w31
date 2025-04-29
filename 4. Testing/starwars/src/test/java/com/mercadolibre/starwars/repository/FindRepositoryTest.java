package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.UtilTest;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FindRepositoryTest {
    @InjectMocks
    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    void setUp() {
        List<CharacterDTO> characterDTOS = UtilTest.getCharacters();
        ReflectionTestUtils.setField(characterRepository, "database", characterDTOS);
    }

    @Test
    void findAllByNameContains() {
        String query = "Leia";
        List<CharacterDTO> characterDTOS = characterRepository.findAllByNameContains(query);
        assertEquals(1, characterDTOS.size());
        assertEquals("Leia Organa", characterDTOS.getFirst().getName());
    }

    @Test
    void findAllByNameContainsEmpty() {
        String query = "";
        List<CharacterDTO> characterDTOS = characterRepository.findAllByNameContains(query);
        assertEquals(3, characterDTOS.size());
    }
}
