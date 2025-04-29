package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @AfterEach
    public void setUp() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        StudentDTO studentPayload = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores("Mario");
        studentPayload.setId(1L);
        String studentPayloadJson = objectMapper.writeValueAsString(studentPayload);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentPayloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void givenExistingId_whenAnalyzeScores_thenMessageAndAverageScoreAreSet() throws Exception {
        // Arrange - Given & Act - When
        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("El alumno Mario ha obtenido un promedio de 9,5. Felicitaciones!"))
                .andReturn();

        // Assert - Then
        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    public void givenNonExistingId_whenAnalyzeScores_thenNotFoundMessage() throws Exception {
        String id = "1000";
        this.mockMvc.perform(get("/analyzeScores/" + id).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id " + id + " no se encuentra registrado."))
                .andExpect(result -> assertInstanceOf(StudentNotFoundException.class, result.getResolvedException()));
    }
}
