package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    private static final String SUCCESS_TEST_SCOPE = "test";
    private static final String ERROR_TEST_SCOPE = "error";
    private static final String ERROR_TEST_JSON_PATH = "./src/" + ERROR_TEST_SCOPE + "/resources/users.json";

    @Test
    void testFindAllSuccess() {
        StudentRepository repo = new StudentRepository();
        ReflectionTestUtils.setField(repo, "SCOPE", SUCCESS_TEST_SCOPE);

        Set<StudentDTO> students = repo.findAll();

        assertNotNull(students);
        assertEquals(2, students.size());
    }

    @Test
    void testFindAllFileNotFound() {
        StudentRepository repo = new StudentRepository();
        ReflectionTestUtils.setField(repo, "SCOPE", ERROR_TEST_JSON_PATH);

        Set<StudentDTO> students = repo.findAll();
        assertNotNull(students);
        assertTrue(students.isEmpty());
    }

    @Test
    void testFindAllMalformedJson() {
        saveFailData();

        StudentRepository repo = new StudentRepository();
        ReflectionTestUtils.setField(repo, "SCOPE", SUCCESS_TEST_SCOPE);

        Set<StudentDTO> students = repo.findAll();

        assertNotNull(students);
        assertTrue(students.isEmpty());
        restoreData();
    }

    private void restoreData(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File fileMain = ResourceUtils.getFile("./src/main/resources/users.json");
            File fileTest = ResourceUtils.getFile("./src/test/resources/users.json");
            Files.copy(fileMain.toPath(), fileTest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private void saveFailData() {
        try {
            File file = ResourceUtils.getFile("./src/test/resources/users.json");
            new ObjectMapper().writeValue(file, "Fail");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}