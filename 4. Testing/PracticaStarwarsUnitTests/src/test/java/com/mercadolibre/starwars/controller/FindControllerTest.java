package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController controller;

    @Test
    void shouldReturnCharacters_givenValidQuery() {
        CharacterDTO luke = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        when(findService.find("Luke")).thenReturn(List.of(luke));

        List<CharacterDTO> result = controller.find("Luke");

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Luke Skywalker");
    }

    @Test
    void shouldReturnEmptyList_whenNoResult() {
        when(findService.find("NO_ONE")).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = controller.find("NO_ONE");
        assertThat(result).isEmpty();
    }
}