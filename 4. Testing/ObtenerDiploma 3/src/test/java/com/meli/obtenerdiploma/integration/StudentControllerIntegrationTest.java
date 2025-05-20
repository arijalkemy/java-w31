package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test happy path registerStudent")
    public void testRegisterStudentHappyPath() throws Exception {
        StudentDTO newStudent = new StudentDTO(1L, "Carlos", "Nuevo alumno", 1D, Arrays.asList(new SubjectDTO("Matematica", 1D)));
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/student/registerStudent")
                        .content(objectMapper.writeValueAsBytes(newStudent))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test bad request registerStudent")
    public void testRegisterStudentThrowsBadRequest() throws Exception {
        StudentDTO newStudent = new StudentDTO(1L, "Carlos", "Nuevo alumno", 1D, new ArrayList<>());
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/student/registerStudent")
                        .content(objectMapper.writeValueAsBytes(newStudent))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }
}