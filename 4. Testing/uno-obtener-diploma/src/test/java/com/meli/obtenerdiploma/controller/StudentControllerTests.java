package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
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
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach @AfterEach
    public void setUp() throws Exception {
        StudentDTO expectedStudent = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores("Mario");
        expectedStudent.setId(1L);
        String expectedStudentJson = objectMapper.writeValueAsString(expectedStudent);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expectedStudentJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void givenStudent_whenRegisterStudent_thenCreate() throws Exception {
        // Arrange - Given
        StudentDTO payloadStudent = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores("Carlos");
        String studentPayloadJson = objectMapper.writeValueAsString(payloadStudent);

        // Act - When & Assert - Then
        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentPayloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void givenInvalidScore_whenRegisterStudent_thenThrowsMethodArgumentNotValidException() throws Exception {
        // Arrange - Given
        StudentDTO payloadStudent = new StudentDTO(null, "Mario",
                List.of(new SubjectDTO("Italian", 100D),
                        new SubjectDTO("English", 10D)
                ));
        String studentPayloadJson = objectMapper.writeValueAsString(payloadStudent);
        String expectedDescription = "La nota máxima de la materia es de 10 pts.";

        // Act - When & Assert - Then
        performRegisterBadRequestResultAction(studentPayloadJson, expectedDescription);
    }

    @Test
    public void givenInvalidStudentName_whenRegisterStudent_thenThrowsMethodArgumentNotValidException() throws Exception {
        // Arrange - Given
        StudentDTO payloadStudent = new StudentDTO(null, null,
                List.of(new SubjectDTO("Italian", 10D),
                        new SubjectDTO("English", 10D)
                ));
        String studentPayloadJson = objectMapper.writeValueAsString(payloadStudent);
        String expectedDescription = "El nombre del estudiante no puede estar vacío.";

        // Act - When & Assert - Then
        performRegisterBadRequestResultAction(studentPayloadJson, expectedDescription);
    }

    @Test
    public void givenEmptySubjectsList_whenRegisterStudent_thenThrowsMethodArgumentNotValidException() throws Exception {
        // Arrange - Given
        StudentDTO payloadStudent = new StudentDTO(null, "Mario", new ArrayList<>());
        String studentPayloadJson = objectMapper.writeValueAsString(payloadStudent);
        String expectedDescription = "La lista de materias no puede estar vacía.";

        // Act - When & Assert - Then
        performRegisterBadRequestResultAction(studentPayloadJson, expectedDescription);
    }

    @Test
    public void givenExistingId_whenGetStudent_thenReturnsStudent() throws Exception {
        // Arrange - Given
        String id = "2";
        String name = "Mario";
        StudentDTO expectedStudent = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores(name);
        expectedStudent.setId(Long.parseLong(id));
        String expectedStudentJson = objectMapper.writeValueAsString(expectedStudent);

        // Act - When
        MvcResult result = mockMvc.perform(get("/student/getStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value(name))
                .andReturn();

        StudentDTO actualStudent = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                StudentDTO.class
        );

        // Assert - Then
        assertEquals(expectedStudent.getId(), actualStudent.getId());
        assertEquals(expectedStudent.getStudentName(), actualStudent.getStudentName());
        assertEquals(expectedStudent.getSubjects().size(), actualStudent.getSubjects().size());
    }

    @Test
    public void givenNonExistingId_whenGetStudent_thenNotFoundMessage() throws Exception {
        // Arrange - Given
        String id = "10000";

        // Act - When & Assert - Then
        mockMvc.perform(get("/student/getStudent/{id}", id))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("El alumno con Id " + id + " no se encuentra registrado."))
                .andExpect(result -> assertInstanceOf(StudentNotFoundException.class, result.getResolvedException()));
    }

    @Test
    public void givenStudent_whenModifyStudent_thenModifiesStudent() throws Exception {
        // Arrange - Given
        StudentDTO payloadStudent = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores("Mario");
        payloadStudent.setId(1L);
        payloadStudent.getSubjects().get(0).setScore(2D);
        String studentPayloadJson = objectMapper.writeValueAsString(payloadStudent);

        // Act - When & Assert - Then
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentPayloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void givenStudentId_whenRemoveStudent_thenRemoves() throws Exception {
        // Arrange - Given
        long studentId = 1L;

        // Act - When
        mockMvc.perform(get("/student/removeStudent/{id}", studentId))
                .andDo(print()).andExpect(status().isOk());

        // Assert - Then
        mockMvc.perform(get("/student/getStudent/{id}", studentId))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("El alumno con Id " + studentId + " no se encuentra registrado."))
                .andExpect(result -> assertInstanceOf(StudentNotFoundException.class, result.getResolvedException()));
    }

    @Test
    public void whenGetAllStudents_thenGetAllStudents() throws Exception {
        // Arrange - Given

        // Act - When
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Assert - Then
    }

    private void performRegisterBadRequestResultAction(String studentPayloadJson, String expectedDescription) throws Exception {
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentPayloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value(expectedDescription))
                .andExpect(result -> assertInstanceOf(MethodArgumentNotValidException.class,
                        result.getResolvedException()));
    }
}
