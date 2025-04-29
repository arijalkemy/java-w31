package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest // levanta el contexto
@AutoConfigureMockMvc // inyecta mockmvc
public class FindControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // busqueda exitosa de un personaje existente
    @Test
    void testFindCharacterSuccessfully() throws Exception {
        mockMvc.perform(get("/Luke"))
                .andExpect(status().isOk()) // HTTP 200
                .andExpect(content().contentType("application/json")) // Content-Type
                .andExpect(jsonPath("$", not(empty()))) // devuelva al menos un resultado
                .andExpect(jsonPath("$[0].name", containsStringIgnoringCase("Luke"))); // contiene "Luke"
    }

    // busqueda con varios resultados ("Darth" → Darth Vader, Darth Maul)
    @Test
    void testFindMultipleCharacters() throws Exception {
        mockMvc.perform(get("/Darth"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2)))) // al menos 2 resultados
                .andExpect(jsonPath("$[*].name", everyItem(containsStringIgnoringCase("Darth"))));
    }

    // busqueda sin resultados ("PersonajeQueNoExiste")
    @Test
    void testFindNoCharacterFound() throws Exception {
        mockMvc.perform(get("/PersonajeQueNoExiste"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", empty())); // Lista vacía
    }

    // busqueda con string vacío
    @Test
    void testFindWithEmptyQuery() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is4xxClientError()); // error 404 porque no matchea ruta
    }

}
