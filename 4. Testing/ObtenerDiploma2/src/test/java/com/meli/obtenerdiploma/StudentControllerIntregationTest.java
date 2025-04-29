package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntregationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //Crear un student Ok
    @Test
    void shouldCreateStudentSuccessfully() throws Exception{
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(40L);
        studentDTO.setStudentName("Miguel");

        //Act & Assert
        mockMvc.perform(MockMvcRequestBuilders
                                .post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(studentDTO))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.studentName").value("Miguel"));
                //.andExpect(jsonPath("$.id").value(40));
    }

    //Buscar un estudiante (Caso exitoso)
    @Test
    void findById() throws Exception{
        //Arrange
        Long param = 2L;

        //Act & Assert
        mockMvc.perform(get("/student/getStudent/{id}",param))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").exists());
    }


    //buscar un estudiante (Caso error)
    @Test
    void nonFindById() throws Exception{
        //Arrange
        Long param = 999L;

        //Act & Assert
        mockMvc.perform(get("/student/getStudent/{id}",param))
                .andExpect(status().isNotFound());
    }


}
