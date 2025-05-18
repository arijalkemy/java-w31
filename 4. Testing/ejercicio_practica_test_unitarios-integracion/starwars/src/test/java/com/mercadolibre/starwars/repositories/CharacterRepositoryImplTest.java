package com.mercadolibre.starwars.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repo = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains_exactMatch() {
        var result = repo.findAllByNameContains("Luke");
        assertEquals(1, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
    }

    @Test
    void findAllByNameContains_partialMatch() {
        var result = repo.findAllByNameContains("Darth");
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(c -> c.getName().contains("Darth")));
    }

    @Test
    void findAllByNameContains_caseInsensitive() {
        var result = repo.findAllByNameContains("leia");
        assertEquals(1, result.size());
        assertEquals("Leia Organa", result.get(0).getName());
    }

    @Test
    void findAllByNameContains_empty_returnsAll() {
        var result = repo.findAllByNameContains("");
        assertEquals(87, result.size());
    }

    @Test
    void findAllByNameContains_noMatch_returnsEmpty() {
        var result = repo.findAllByNameContains("YodaX");
        assertTrue(result.isEmpty());
    }

    @Test
    void findAllByNameContains_null_throwsNPE() {
        assertThrows(NullPointerException.class, () -> repo.findAllByNameContains(null));
    }
}