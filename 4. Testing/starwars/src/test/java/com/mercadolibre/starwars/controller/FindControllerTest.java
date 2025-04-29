package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(FindController.class)
class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindService findService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private CharacterDTO luke;

    @BeforeEach
    void setUp() {
        luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
    }

    @Test
    void testFindCharacterSuccessfully() throws Exception {
        when(findService.find("Luke")).thenReturn(List.of(luke));

        mockMvc.perform(get("/Luke"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));

        verify(findService, times(1)).find("Luke");
    }

    @Test
    void testFindCharacterNoMatch() throws Exception {
        when(findService.find("NoExiste")).thenReturn(List.of());

        mockMvc.perform(get("/NoExiste"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType("application/json"))
                .andExpect(content().json("[]"));

        verify(findService, times(1)).find("NoExiste");
    }
}
