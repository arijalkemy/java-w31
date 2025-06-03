package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAnalyzeScores_InvalidStudentId() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("El alumno con Id 999 no se encuetra registrado."));
    }

    @Test
    public void testRegisterStudent() throws Exception {
        StudentDTO newStudent = new StudentDTO(null, "Maria", null, null, List.of(new SubjectDTO("Math", 8.0)));

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newStudent)))
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterStudent_InvalidData() throws Exception {
        String invalidStudentData = "{ \"studentName\": null }";

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidStudentData))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetStudent_InvalidId() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("El alumno con Id 999 no se encuetra registrado."));
    }

    @Test
    public void testModifyStudent() throws Exception {
        StudentDTO modifyStudent = new StudentDTO(1L, "Modified Name", null, null, List.of(new SubjectDTO("History", 9.0)));

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(modifyStudent)))
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveStudent_ValidId() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void testListStudents() throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }
}