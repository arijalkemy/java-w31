package com.mercadolibre.starwars.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void find_exactMatch_returnsOneResult() throws Exception {
        mockMvc.perform(get("/Luke"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void find_partialMatch_returnsMultipleResults() throws Exception {
        mockMvc.perform(get("/Darth"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", containsString("Darth")))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))));
    }

    @Test
    void find_noMatch_returnsEmptyList() throws Exception {
        mockMvc.perform(get("/NonexistentCharacter"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    void find_caseInsensitiveMatch_returnsResults() throws Exception {
        mockMvc.perform(get("/luke"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    void find_emptyQuery_returnsAllResults() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is4xxClientError());
    }
}