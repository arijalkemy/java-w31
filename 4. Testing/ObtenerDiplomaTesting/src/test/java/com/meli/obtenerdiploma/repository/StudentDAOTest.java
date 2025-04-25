package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentDAOTest {
    private static final String TEST_RESOURCES_PATH = "./src/test/resources";
    private static final String TEST_JSON_FILE = TEST_RESOURCES_PATH + "/users.json";
    private static final String ORIGINAL_JSON_FILE = TEST_RESOURCES_PATH + "/original_users.json";

    private StudentDAO studentDAO;
    private ObjectMapper objectMapper = new ObjectMapper();

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
    void testSaveStudent() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Mario");
        studentDAO.save(student);

        assertNotNull(studentDAO.findById(3L));
        assertEquals(3, studentDAO.findAll().size());
    }

    @Test
    void testSaveExistingStudent() {
        StudentDTO updatedStudent = new StudentDTO();
        updatedStudent.setId(1L);
        updatedStudent.setStudentName("Actualizado");

        studentDAO.save(updatedStudent);

        StudentDTO found = studentDAO.findById(1L);
        assertEquals("Actualizado", found.getStudentName());
        assertEquals(2, studentDAO.findAll().size());
    }

    @Test
    void testSaveStudentWithoutID() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Mario");

        studentDAO.save(student);

        assertNotNull(student.getId());
        assertEquals(3L, student.getId());
        assertEquals(3, studentDAO.findAll().size());
    }

    @Test
    void testDeleteStudent() {
        boolean result = studentDAO.delete(1L);

        assertTrue(result);
        assertEquals(1, studentDAO.findAll().size());
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }

    @Test
    void testDeleteNonExistingStudent() {
        boolean result = studentDAO.delete(999L);

        assertFalse(result);
        assertEquals(2, studentDAO.findAll().size());
    }

    @Test
    void testExists() {
        StudentDTO existingStudent = new StudentDTO();
        existingStudent.setId(1L);

        StudentDTO nonExistingStudent = new StudentDTO();
        nonExistingStudent.setId(999L);

        assertTrue(studentDAO.exists(existingStudent));
        assertFalse(studentDAO.exists(nonExistingStudent));
    }

    @Test
    void findById() {
        StudentDTO student = studentDAO.findById(1L);

        assertNotNull(student);
        assertEquals("Juan", student.getStudentName());
    }

    @Test
    void testFindByIdNotFound() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(999L));
    }
}