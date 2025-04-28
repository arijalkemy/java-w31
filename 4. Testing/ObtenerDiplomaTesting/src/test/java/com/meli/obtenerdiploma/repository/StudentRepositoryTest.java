package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentRepositoryTest {
    private static final String TEST_RESOURCES_PATH = "./src/test/resources";
    private static final String TEST_JSON_FILE = TEST_RESOURCES_PATH + "/users.json";
    private static final String ORIGINAL_JSON_FILE = TEST_RESOURCES_PATH + "/original_users.json";

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() throws IOException {
        File originalFile = new File(ORIGINAL_JSON_FILE);
        if(!originalFile.exists()) {
            Files.copy(Paths.get(TEST_JSON_FILE), Paths.get(ORIGINAL_JSON_FILE), StandardCopyOption.REPLACE_EXISTING);
        }

        studentRepository = new StudentRepository();
    }

    @AfterEach
    void tearDown() throws IOException {
        File jsonFile = new File(TEST_JSON_FILE);
        Files.copy(Paths.get(ORIGINAL_JSON_FILE), Paths.get(TEST_JSON_FILE), StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void testFindAll() {
        Set<StudentDTO> students = studentRepository.findAll();
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }

    @Test
    void testFindEmptyJson() {
        // Delete the contents of the JSON file
        try {
            Files.write(Paths.get(TEST_JSON_FILE), new byte[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Call the method to test
        Set<StudentDTO> students = studentRepository.findAll();
        assertNotNull(students);
        assertTrue(students.isEmpty());
    }
}