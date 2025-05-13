package com.meli.obtenerdiploma.controller.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // inyecto la dependencia
public class ObtenerDiplomaIntegrationTests {
    @Autowired //inyeccion de dependencia
    private MockMvc mockMvc;

    private SubjectDTO music;
    private  SubjectDTO math;

    @BeforeEach
    public void setTets(){
        StudentDAO studentDAO = new StudentDAO();
        music = new SubjectDTO("Music", 9.00);
        math = new SubjectDTO("Math", 9.00);
        StudentDTO student = new StudentDTO(3L, "Juan",
                "El alumno Juan ha obtenido un promedio de 9,00. Puedes mejorar.",
                9.00,  List.of(music,math));

        studentDAO.save(student);
    }

    @Test
    public void testValidStundetGetDiploma() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.averageScore").value(9.00))
                .andExpect(jsonPath("$.subjects.length()").value(2))
                .andExpect(jsonPath("$.subjects[?(@.name == \""+music.getName()+"\"  && " +
                        "@.score == "+music.getScore()+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+math.getName()+"\"  &&" +
                        " @.score == "+math.getScore()+")]").exists());
    }

    @Test
    public void testInvalidStudentGetDiploma() throws Exception{
        Long invalidId = 999L;
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", invalidId))
                .andExpect(status().isNotFound());
    }



}
