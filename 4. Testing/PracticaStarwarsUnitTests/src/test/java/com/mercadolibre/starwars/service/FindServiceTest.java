package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class FindServiceTest {

    @Test
    void shouldReturnListWhenQueryMatches() {
        CharacterRepository repository = Mockito.mock(CharacterRepository.class);
        CharacterDTO luke = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        when(repository.findAllByNameContains("luke")).thenReturn(Arrays.asList(luke));

        FindService service = new FindService(repository);
        List<CharacterDTO> result = service.find("luke");

        assertThat(result).hasSize(1).contains(luke);
    }

    @Test
    void shouldReturnEmptyListWhenNoMatch() {
        CharacterRepository repository = Mockito.mock(CharacterRepository.class);
        when(repository.findAllByNameContains("vader")).thenReturn(Collections.emptyList());

        FindService service = new FindService(repository);

        List<CharacterDTO> result = service.find("vader");

        assertThat(result).isEmpty();
    }
}