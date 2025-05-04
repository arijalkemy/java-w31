package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.model.StudentDTO;

public class StudentRepositoryTest {

    private static IStudentRepository studentRepository;

    @BeforeAll
    static void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    void testFindAll() {
        // Act
        Set<StudentDTO> students = studentRepository.findAll();

        // Assert
        assertNotNull(students);
    }
}
