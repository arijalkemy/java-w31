package com.meli.obtenerdiploma.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.security.auth.Subject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestsIntegracion {
    private static final String TEST_RESOURCES_PATH = "./src/test/resources";
    private static final String TEST_JSON_FILE = TEST_RESOURCES_PATH + "/users.json";
    private static final String ORIGINAL_JSON_FILE = TEST_RESOURCES_PATH + "/original_users.json";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentDAO studentDAO;

    private StudentDTO testStudent;

    @BeforeEach
    void setUp() throws IOException {
        File originalFile = new File(ORIGINAL_JSON_FILE);
        if(!originalFile.exists()) {
            Files.copy(Paths.get(TEST_JSON_FILE), Paths.get(ORIGINAL_JSON_FILE), StandardCopyOption.REPLACE_EXISTING);
        }
        studentDAO = new StudentDAO();
    }

    @AfterEach
    void tearDown() throws IOException {
        File jsonFile = new File(TEST_JSON_FILE);
        Files.copy(Paths.get(ORIGINAL_JSON_FILE), Paths.get(TEST_JSON_FILE), StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void testAnalyzeOkScore() throws Exception {
        mockMvc.perform(get("/analyzeScores/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void testAnalyzeNotExistingStudentScore() throws Exception {
        mockMvc.perform(get("/analyzeScores/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testAnalyzeNotValidInputScore() throws Exception {
        mockMvc.perform(get("/analyzeScores/carlos"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetStudent() throws Exception {
        mockMvc.perform(get("/student/getStudent/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.subjects[0].name").value("Matemática"))
                .andExpect(jsonPath("$.subjects[0].score").value(9.0));
    }

    @Test
    public void testCreateStudent() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(3L);
        student.setStudentName("Javier");
        SubjectDTO subject = new SubjectDTO();
        subject.setName("Literatura");
        subject.setScore(9.0);
        student.setSubjects(List.of(subject));

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/student/getStudent/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Javier"));
    }

    @Test
    public void testCreateNonValidStudent() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(3L);
        SubjectDTO subject = new SubjectDTO();
        subject.setName("Literatura");
        subject.setScore(9.0);
        student.setSubjects(List.of(subject));

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }


    @Test
    void testModifyStudent() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Javier");
        SubjectDTO subject = new SubjectDTO();
        subject.setName("Literatura");
        subject.setScore(9.0);
        student.setSubjects(List.of(subject));

        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/student/getStudent/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.subjects.length()").value(1))
                .andExpect(jsonPath("$.studentName").value("Javier"));
    }

    @Test
    void testRemoveStudent() throws Exception {
        mockMvc.perform(get("/student/removeStudent/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/student/getStudent/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testListStudents() throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

}
