package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired //inyeccion de dependencia
    private MockMvc mockMvc;

    private static ObjectWriter writer;
    private SubjectDTO music;
    private  SubjectDTO math;

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).
                writer().withDefaultPrettyPrinter();
    }

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
    public void testRegisterStudent() throws Exception {
        music = new SubjectDTO("Music", 9.00);
        math = new SubjectDTO("Math", 9.00);
        StudentDTO payloadDTO = new StudentDTO(4L, "Pedro", "message",
                9.00,List.of(music,math));

        String payloadJson = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print()).
                andExpect(status().isOk()); // como no devuelve nada solo chequeo que se ejecuto bien el endpoint
    }

    @Test
    public void testGetStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 4))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Pedro"))
                .andExpect(jsonPath("$.averageScore").value(9))
                .andExpect(jsonPath("$.subjects.length()").value(2))
                .andExpect(jsonPath("$.subjects[?(@.name == \""+music.getName()+"\"  && " +
                        "@.score == "+music.getScore()+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+math.getName()+"\"  &&" +
                        " @.score == "+math.getScore()+")]").exists());
    }

    @Test
    public void testModifyStudent() throws Exception {
        music = new SubjectDTO("Music", 9.00);
        math = new SubjectDTO("Math", 9.00);
        StudentDTO payloadDTO = new StudentDTO(4L, "Carlos", "message",
                9.00,List.of(music,math));

        String payloadJson = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetInvalidStudent() throws Exception {
        Long invalidId = 999L;
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", invalidId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json")) // tengo que chequear el content y la exception
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    public void testListStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$[0].studentName").value("Juan"))
                .andExpect(jsonPath("$[0].averageScore").value(9))
                .andExpect(jsonPath("$[3].studentName").value("Carlos"))
                .andExpect(jsonPath("$[3].averageScore").value(9));
    }

    @Test
    public void testRemoveStudent() throws Exception{
        //por que un remove es un get?
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
