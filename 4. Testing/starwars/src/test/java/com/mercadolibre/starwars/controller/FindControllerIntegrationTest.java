package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.UtilTest;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerIntegrationTest {
    private static ObjectWriter objectWriter;
    List<CharacterDTO> characters;
    @MockitoBean
    private CharacterRepository characterRepository;
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    void init() {
        reset(characterRepository);
        characters = UtilTest.getCharacters();
    }

    @Test
    void testFind() throws Exception {
        when(characterRepository.findAllByNameContains("Luke"))
                .thenReturn(List.of(characters.getFirst()));

        String query = "Luke";
        String expectedResponse = objectWriter.writeValueAsString(List.of(characters.getFirst()));

        mockMvc.perform(get("/" + query))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedResponse));

        verify(characterRepository, times(1)).findAllByNameContains(query);
    }

    @Test
    void testFindWithEmptyQuery_404Error() throws Exception {
        String query = "";

        mockMvc.perform(get("/" + query))
                .andExpect(status().isNotFound());

    }
}
