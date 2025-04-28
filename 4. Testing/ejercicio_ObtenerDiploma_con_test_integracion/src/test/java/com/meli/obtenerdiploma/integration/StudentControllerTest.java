package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterStudent() throws Exception {
        // Arrange
        StudentDTO payloadDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        // Act
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetStudentById() throws Exception {
        // Arrange
        Long studentId = 1L;

        // Act
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}", studentId)).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void testGetStudentByIdFail() throws Exception {
        // Arrange
        Long studentId = 1L;

        // Act
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/getStudent/{id}", studentId)).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testModifyStudent() throws Exception {
        // Arrange
        StudentDTO payloadDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        // Act
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testModifyStudentFail400() throws Exception {
        // Act
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testRemoveStudent() throws Exception{
        // Arrange
        Long studentId = 1L;

        // Act
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/student/removeStudent/{id}", studentId))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveStudent404Fail() throws Exception{
        // Arrange
        Long studentId = 999L;

        // Act
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/student/removeStudent/{id}", studentId))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testListStudents() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
