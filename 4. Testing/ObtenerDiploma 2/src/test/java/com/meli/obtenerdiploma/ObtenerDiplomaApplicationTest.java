package com.meli.obtenerdiploma;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc

public class ObtenerDiplomaApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentDAO dao;

    private static final Path JSON_PATH = Paths.get("./src/test/resources/users.json");
    private static final Path JSON_BACKUP_PATH = Paths.get("./src/test/resources/users_backup.json");
    private static final Path JSON_EMPTY_PATH = Paths.get("./src/test/resources/users_empty.json");

    @BeforeEach
    void backupJson() throws IOException {
        Files.copy(JSON_PATH, JSON_BACKUP_PATH, StandardCopyOption.REPLACE_EXISTING);
    }

    @AfterEach
    void restoreJson() throws IOException {
        Files.copy(JSON_BACKUP_PATH, JSON_PATH, StandardCopyOption.REPLACE_EXISTING);
    }



    // GET get student
    @Test
    void getStudent_shouldReturnStudent_WhenIdIsValid() throws Exception{
        this.mockMvc.perform(get("/student/getStudent/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Juan"))).andReturn();
    }

    @Test
    void getStudent_shouldThrowException_WhenStudentNotFound() throws Exception{
        this.mockMvc.perform(get("/student/getStudent/0"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("StudentNotFoundException"))).andReturn();
    }


    @Test
    void getStudent_shouldReturnBadRequest_WhenIdIsNullOrInvalid() throws Exception{
        this.mockMvc.perform(get("/student/getStudent/"))
                .andDo(print())
                .andExpect(status().isNotFound()).andReturn();
    }


    //GET /removeStudent/{id}
    @Test
    void removeStudent_shouldDeleteStudentSuccessfully() throws Exception{
        this.mockMvc.perform(get("/student/removeStudent/1"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void removeStudent_shouldReturnBadRequest_WhenIdIsNullOrInvalid() throws Exception{
        this.mockMvc.perform(get("/student/removeStudent/"))
                .andDo(print())
                .andExpect(status().isNotFound()).andReturn();
    }

    //GET /listStudents

    @Test
    void listStudents_shouldReturnAllStudents() throws Exception{
        this.mockMvc.perform(get("/student//listStudents/"))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("Juan"))).andReturn();
    }

    @Test
    void listStudents_shouldReturnEmptySet_WhenNoStudentsExist() throws Exception{
        Files.copy(JSON_EMPTY_PATH, JSON_PATH, StandardCopyOption.REPLACE_EXISTING);
        this.mockMvc.perform(get("/student//listStudents/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andReturn();
    }

    // POST /registerStudent


    @Test
    void registerStudent_shouldCreateStudentSuccessfully() throws Exception {
        String validStudentJson = "{"
                + "\"id\": 188888,"
                + "\"studentName\": \"Mariano\","
                + "\"subjects\": ["
                + "{ \"name\": \"Matemática\", \"score\": 9 },"
                + "{ \"name\": \"Física\", \"score\": 7 },"
                + "{ \"name\": \"Química\", \"score\": 6 }"
                + "]"
                + "}";

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validStudentJson))
                        .andDo(print())
                        .andExpect(status().isOk());
    }


    @Test
    void registerStudent_shouldReturnBadRequest_WhenDataIsInvalid() throws Exception{
        String validStudentJson = "{"
                + "\"id\": 188888,"
                + "\"subjects\": ["
                + "{ \"name\": \"Matemática\", \"score\": 9 },"
                + "{ \"name\": \"Física\", \"score\": 7 },"
                + "{ \"name\": \"Química\", \"score\": 6 }"
                + "]"
                + "}";

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validStudentJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("MethodArgumentNotValidException"))).andReturn();
    }



    /*

POST /modifyStudent
            modifyStudent_shouldUpdateStudentSuccessfully
            modifyStudent_shouldReturnBadRequest_WhenDataIsInvalid
            modifyStudent_shouldThrowException_WhenStudentNotFound





*/

}


