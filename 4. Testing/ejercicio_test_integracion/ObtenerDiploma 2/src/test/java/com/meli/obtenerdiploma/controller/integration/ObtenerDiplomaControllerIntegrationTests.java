package com.meli.obtenerdiploma.controller.integration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScores_ok() throws Exception {
        mockMvc.perform(get("/analyzeScores/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName", notNullValue()))
                .andExpect(jsonPath("$.averageScore", notNullValue()))
                .andExpect(jsonPath("$.message", containsString("Puedes mejorar")));
    }

    @Test
    void analyzeScores_notFound() throws Exception {
        mockMvc.perform(get("/analyzeScores/{id}", 9999))
                .andExpect(status().isNotFound());
    }

}
