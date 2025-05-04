package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.CustomFactory;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import lombok.AllArgsConstructor;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void registerStudent() throws Exception {
        //Arrange
        String payload= CustomFactory.getStudentDto();

        //Act And Assert
        this.mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void getStudent() throws Exception{
        //Arrange
        StudentDTO stu= CustomFactory.getResponse();


        //Act And Assert
        this.mockMvc.perform(get("/student/getStudent/{id}",2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value(stu.getStudentName()))
                .andExpect(jsonPath("$.id").value(stu.getId()));
    }

    @Test
    @Order(4)
    void modifyStudent() throws Exception {
        //Arrange
        String payload= CustomFactory.getStudentDtoOver();

        //Act And Assert
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(5)
    void removeStudent() throws Exception {
        this.mockMvc.perform(get("/student/removeStudent/{id}",2))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void listStudents() throws Exception {
        StudentDTO stu= CustomFactory.getResponse();


        this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(stu.getId()))
                .andExpect(jsonPath("$[0].studentName").value(stu.getStudentName()));

    }
}