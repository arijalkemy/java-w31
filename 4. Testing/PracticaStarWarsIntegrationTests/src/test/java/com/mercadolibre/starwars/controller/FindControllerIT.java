package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.StarWarsApplication;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = StarWarsApplication.class)
@AutoConfigureMockMvc
class FindControllerIT {

    @Autowired
    MockMvc mvc;

    @Test
    void shouldReturnCharacters_whenQueryMatch() throws Exception {
        mvc.perform(get("/Luke")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Luke Skywalker")));
    }

    @Test
    void shouldReturnEmptyList_whenQueryNoMatch() throws Exception {
        mvc.perform(get("/NoOne")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void shouldBeCaseInsensitive() throws Exception {
        mvc.perform(get("/luKe")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Luke Skywalker")));
    }
}