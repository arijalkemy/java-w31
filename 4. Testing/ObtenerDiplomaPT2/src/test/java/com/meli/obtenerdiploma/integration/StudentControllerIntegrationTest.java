package com.meli.obtenerdiploma.integration;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectWriter = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .registerModule(new JavaTimeModule());

    @Test
    public void testRegisterNewStudent() throws Exception {
        // Arrange
        StudentDTO student = new StudentDTO(99L, "John Doe", null, null,
                List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 8.5)));
        String studentJson = objectWriter.writeValueAsString(student);

        // Act & Assert
        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterOldStudent() throws Exception {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "John Doe", null, null,
                List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 8.5)));
        String studentJson = objectWriter.writeValueAsString(student);

        // Act & Assert
        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStudent() throws Exception {
        // Arrange
        Long studentId = 2L;
        StudentDTO student = new StudentDTO(2L, "John Doe", null, null,
                List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 8.5)));
        String studentJson = objectWriter.writeValueAsString(student);

        // Act & Assert
        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/student/getStudent/{id}", studentId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(jsonPath("$.subjects[0].name").value("Math"))
                .andExpect(jsonPath("$.subjects[1].name").value("Science"))
                .andExpect(jsonPath("$.subjects[0].score").value(9.0))
                .andExpect(jsonPath("$.subjects[1].score").value(8.5));
    }

    @Test
    public void testGetStudentNotFound() throws Exception {
        // Arrange
        Long studentId = 100L;

        // Act & Assert
        mockMvc.perform(get("/student/getStudent/{id}", studentId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testModifyStudent() throws Exception {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "New John Doe", null, null,
                List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 8.5)));
        String studentJson = objectWriter.writeValueAsString(student);

        // Act & Assert
        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveStudent() throws Exception {
        // Arange
        Long studentId = 1L;

        // Act & Assert
        mockMvc.perform(get("/student/removeStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveStudentNotFound() throws Exception {
        // Arange
        Long studentId = 100L;

        // Act & Assert
        mockMvc.perform(get("/student/removeStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testListStudents() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
