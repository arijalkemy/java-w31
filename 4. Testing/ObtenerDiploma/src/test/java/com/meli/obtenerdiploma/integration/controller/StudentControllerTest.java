package com.meli.obtenerdiploma.integration.controller;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @Test
    public void createStudent_shouldReturn200OK() throws Exception{
        // Arrange
        StudentDTO payloadDTO = new StudentDTO(null, "Pedro", null, null,
                List.of(new SubjectDTO("Biología", 10.0)));

        String payloadJson = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(payloadDTO);
        // Act & Assert
        this.mockmvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    public void readStudent_shouldReturnStudent() throws Exception{
        MvcResult mvcResult =
                this.mockmvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 10))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").exists())
                        .andReturn();
    }

    @Test
    public void modifyStudent_shouldReturn200Ok() throws Exception{
        // Arrange
        StudentDTO payloadDTO = new StudentDTO(null, "Pedro", null, null,
                List.of(new SubjectDTO("Biología", 10.0)));

        String payloadJson = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(payloadDTO);
        // Act & Assert
        this.mockmvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteStudent_shouldReturn200OK() throws Exception{
        MvcResult mvcResult =
                this.mockmvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    public void listStudents_shouldReturnAllStudents() throws Exception{
        MvcResult mvcResult =
                this.mockmvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName").exists())
                        .andExpect(MockMvcResultMatchers.jsonPath("$[1].studentName").exists())
                        .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                        .andReturn();
    }

    @Test
    public void createStudent_withInvalidData_shouldReturn400BadRequest() throws Exception{
        // Arrange
        StudentDTO invalidPayloadDTO = new StudentDTO(null, null, null, null, null); // Datos inválidos

        String payloadJson = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writeValueAsString(invalidPayloadDTO);

        // Act & Assert
        this.mockmvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    @Test
    public void modifyStudent_withInvalidData_shouldReturn400BadRequest() throws Exception{
        // Arrange
        StudentDTO invalidPayloadDTO = new StudentDTO(null, null, null, null, null); // Datos inválidos

        String payloadJson = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writeValueAsString(invalidPayloadDTO);

        // Act & Assert
        this.mockmvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getStudent_withInvalidId_shouldReturn400BadRequest() throws Exception {
        String invalidId = "invalid";

        this.mockmvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", invalidId))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
