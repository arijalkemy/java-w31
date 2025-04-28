package com.meli.obtenerdiploma.integracion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestsIntegracion {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAnalyzeOkScore() throws Exception {
        mockMvc.perform(get("/analyzeScores/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void testAnalyzeNotExistingStudentScore() throws Exception {
        mockMvc.perform(get("/analyzeScores/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testAnalyzeNotValidInputScore() throws Exception {
        mockMvc.perform(get("/analyzeScores/carlos"))
                .andExpect(status().isBadRequest());
    }

}
