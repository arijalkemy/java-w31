package com.meli.obtenerdiploma.integration;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAnalyzeScoresCanImprove() throws Exception {
        // Arrange
        Long studentId = 1L;
        Double expectedAverage = (9.0 + 7.0 + 6.0) / 3;
        String expectedMessage = "El alumno Juan ha obtenido un promedio de "
                + new DecimalFormat("#0.00").format(expectedAverage) + ". Puedes mejorar.";
        // Act & Assert
        mockMvc.perform(
                get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.averageScore").value(expectedAverage))
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @Test
    public void testAnalyzeScoresNotFound() throws Exception {
        // Arrange
        Long id = 99L;
        // Act & Assert
        mockMvc.perform(get("/analyzeScores/{studentId}", id)).andDo(print()).andExpect(status().isNotFound());
    }
}
