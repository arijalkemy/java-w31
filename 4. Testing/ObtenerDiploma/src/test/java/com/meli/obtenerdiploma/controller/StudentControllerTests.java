package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentService service;

    @Test
    public void registerStudent() throws Exception {
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Matematicas", 9.0)
        );
        StudentDTO studentDTO = new StudentDTO(911L, "Johan", null, null, subjectDTOList);
        String json = new ObjectMapper().writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getStudent() throws Exception {
        mockMvc.perform(get("/student/getStudent/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void modifyStudent() throws Exception {
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Matematicas", 9.0)
        );
        StudentDTO studentDTO = new StudentDTO(911L, "Johan", null, null, subjectDTOList);
        String json = new ObjectMapper().writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void removeStudent() throws Exception {
        mockMvc.perform(get("/student/removeStudent/911"))
                .andExpect(status().isOk());
    }

    @Test
    public void listStudents() throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk());
    }
}
