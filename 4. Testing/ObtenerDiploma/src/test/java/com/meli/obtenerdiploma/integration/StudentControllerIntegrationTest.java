package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudent_ok() throws Exception {

        // Arrange
        StudentDTO newStudent = new StudentDTO(2L, "John Doe", "Lorem ipsum", 7.5, Arrays.asList(
                new SubjectDTO("History", 7.5),
                new SubjectDTO("Science", 7.5)
        ));

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newStudent)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getStudent_ok() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andReturn();
    }

    @Test
    void modifyStudent_ok() throws Exception {

        // Arrange
        StudentDTO modifiedStudent = new StudentDTO(1L, "Jane Doe", "Updated description", 9.0, Arrays.asList(
                new SubjectDTO("Math", 9.5),
                new SubjectDTO("English", 8.5)
        ));

        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(modifiedStudent)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void removeStudent_ok() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", 2L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void listStudents_ok() throws Exception {
        mockMvc.perform(get("/student/listStudents")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andReturn();
    }
}

