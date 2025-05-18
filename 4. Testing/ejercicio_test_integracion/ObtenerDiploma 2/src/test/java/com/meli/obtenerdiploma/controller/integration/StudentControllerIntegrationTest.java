package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    ObjectMapper mapper;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        try {
            File fileMain = ResourceUtils.getFile("./src/main/resources/users.json");
            File fileTest = ResourceUtils.getFile("./src/test/resources/users.json");
            Files.copy(fileMain.toPath(), fileTest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Test
    void registerStudent_ok() throws Exception {
        StudentDTO dto = new StudentDTO(null, "Luli", null, null,
                List.of(new SubjectDTO("Arte", 10.0)));
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    void registerStudent_validationFails() throws Exception {
        StudentDTO dto = new StudentDTO(null, "", null, null,
                List.of(new SubjectDTO("Arte", 10.0)));
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getStudent_ok() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName", is("Juan")));
    }

    @Test
    void getStudent_notFound() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 99999))
                .andExpect(status().isNotFound());
    }

    @Test
    void modifyStudent_ok() throws Exception {
        // Registrar primero
        StudentDTO dto = new StudentDTO(null, "Juan", null, null,
                List.of(new SubjectDTO("Historia", 6.0)));
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        StudentDTO modif = new StudentDTO(1L, "Juan Modificado", null, null,
                List.of(new SubjectDTO("Historia", 9.0)));
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(modif)))
                .andExpect(status().isOk());
        mockMvc.perform(get("/student/getStudent/1"))
                .andExpect(jsonPath("$.studentName", is("Juan Modificado")));
    }

    @Test
    void removeStudent_ok() throws Exception {
        StudentDTO dto = new StudentDTO(null, "Pedro", null, null,
                List.of(new SubjectDTO("Ciencias", 8.0)));
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
        mockMvc.perform(get("/student/removeStudent/{id}", 1))
                .andExpect(status().isOk());
        mockMvc.perform(get("/student/getStudent/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    void listStudents_ok() throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}