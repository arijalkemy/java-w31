package com.meli.obtenerdiploma.integracion;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestStudentIT {
    @Autowired
    MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    SubjectDTO matematica;
    SubjectDTO biologia;
    SubjectDTO lengua;

    StudentDTO student;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    public void beforEach() {
        matematica = new SubjectDTO("Matematica", 6.0);
        biologia = new SubjectDTO("Biologia", 8.0);
        lengua = new SubjectDTO("Lengua", 7.0);
        student = new StudentDTO(100L, "Carlos Gomez", null, null, List.of(matematica, biologia, lengua));

        if (!studentDAO.exists(student))
            studentDAO.save(student);

    }

    @Test
    public void registerValidStudent() throws Exception {
        String studentJson = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType("application/json")
                .content(studentJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("")); // Cuerpo rta vacío
    }

    @Test
    public void registerInvalidStudent() throws Exception {
        StudentDTO invalidStudent = new StudentDTO(100L, "", null, null, new ArrayList<>());

        String studentJson = writer.writeValueAsString(invalidStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType("application/json")
                .content(studentJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(
                        result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

    @Test
    public void modifyValidStudent() throws Exception {
        StudentDTO modifiedStudent = student;
        modifiedStudent.setStudentName("Mariana Fernandez");

        String modifiedStudentJson = writer.writeValueAsString(modifiedStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType("application/json")
                .content(modifiedStudentJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("")); // Cuerpo rta vacío
    }

    @Test
    public void modifyInvalidStudent() throws Exception {
        StudentDTO modifiedStudent = student;
        modifiedStudent.setStudentName("");

        String modifiedStudentJson = writer.writeValueAsString(modifiedStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType("application/json")
                .content(modifiedStudentJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(
                        result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

    @Test
    public void getValidStudent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", student.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(student.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Carlos Gomez"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects.length()").value(3));
    }

    @Test
    public void getInexistentStudent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", -1L))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(
                        result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException));
    }

    @Test
    public void removeExistentStudent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", student.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("")); // Cuerpo rta vacío
    }

    @Test
    public void removeInexistentStudent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", -1L))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Aunque no se encuentre, no tira excepción
                .andExpect(MockMvcResultMatchers.content().string("")); // Cuerpo rta vacío
    }

    @Test
    public void listStudents() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName").value(student.getStudentName()));
    }

}
