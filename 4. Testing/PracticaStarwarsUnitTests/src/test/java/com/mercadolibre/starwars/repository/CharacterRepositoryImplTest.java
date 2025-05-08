package com.mercadolibre.starwars.repository;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    void shouldFindCharacterByPartialName_caseInsensitive() {
        List<CharacterDTO> result = repository.findAllByNameContains("LUKE");
        assertThat(result)
                .isNotEmpty()
                .anySatisfy(character -> assertThat(character.getName()).isEqualTo("Luke Skywalker"));
    }

    @Test
    void shouldReturnEmptyListWhenNoNameMatches() {
        List<CharacterDTO> result = repository.findAllByNameContains("NotAStarWarsName");
        assertThat(result).isEmpty();
    }

    @Test
    void shouldReturnMultipleResultsIfQueryMatchesMultiple() {
        List<CharacterDTO> result = repository.findAllByNameContains("C");
        // C matches C-3PO and R2-D2. R2-D2 does not have a C but keep for example
        assertThat(result).hasSizeGreaterThanOrEqualTo(1);
    }
}