package com.meli.obtenerdiploma.integration.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void analyzeScores_shouldReturnTheScoresFromStudent() throws Exception {
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 10))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").exists())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").exists())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.subjects").isArray())
                        .andReturn();
    }

    @Test
    public void analyzeScores_shouldReturnNotFoundWhenStudentDoesNotExist() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 9999))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
