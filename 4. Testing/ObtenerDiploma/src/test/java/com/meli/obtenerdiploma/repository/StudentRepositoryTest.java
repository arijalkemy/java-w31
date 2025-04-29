package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testFindAllStudents() throws IOException {

        Set<StudentDTO> students = studentRepository.findAll();

        // Assert: Verificar que el resultado sea el esperado
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }

    @Test
    void testFindAllStudentsEmpty() throws IOException {
        // Simular un archivo vacío
        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("src/main/resources/users.json");
        objectMapper.writeValue(file, Set.of());

        Set<StudentDTO> students = studentRepository.findAll();
        assertTrue(students.isEmpty());
    }
}
