package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.function.Predicate.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter ow;

    @BeforeEach
    void setUp() {
        ow = new ObjectMapper().writerWithDefaultPrettyPrinter();
    }

    private List<SubjectDTO> sampleSubjects(double... scores) {
        List<SubjectDTO> subjects = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            subjects.add(new SubjectDTO("Materia " + i, scores[i]));
        }
        return subjects;
    }

    @Test
    public void testRegisterStudent_shouldReturn200() throws Exception {
        StudentDTO studentDTO = new StudentDTO(null, "Andrés", null, null,  sampleSubjects(8.0, 7.0, 9.0));
        String json = ow.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterStudent_shouldReturnNotBlankValidation() throws Exception {
        StudentDTO studentDTO = new StudentDTO(null, null, null, null,  sampleSubjects(8.0, 7.0, 9.0));
        String json = ow.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    public void testRegisterStudent_shouldReturnNameValidation() throws Exception {
        StudentDTO studentDTO = new StudentDTO(null, "camilo", null, null,  sampleSubjects(8.0, 7.0, 9.0));
        String json = ow.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }

    @Test
    public void testRegisterStudent_shouldReturnNameSizeValidation() throws Exception {
        String invalidName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXY";
        StudentDTO studentDTO = new StudentDTO(null, invalidName, null, null,  sampleSubjects(8.0, 7.0, 9.0));
        String json = ow.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));
    }

    @Test
    public void testRegisterStudent_shouldReturnSubjectsValidation() throws Exception {
        StudentDTO studentDTO = new StudentDTO(null, "Mateo", null, null,  null);
        String json = ow.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }

    @Test
    public void testFindById_shouldReturnStudentDTO() throws Exception {
        Long id = 1L;
        mockMvc.perform(get("/student/getStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.studentName").isNotEmpty())
                .andExpect(jsonPath("$.averageScore").isNumber())
                .andExpect(jsonPath("$.subjects").isArray());// Asegura que hay materias
    }



}
