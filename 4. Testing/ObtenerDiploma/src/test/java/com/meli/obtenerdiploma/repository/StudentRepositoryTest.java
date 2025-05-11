package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository;

    @Test
    void testFindAll() {

        // Arrange
        int size_expected = 2;

        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(result.size(), size_expected);

    }
}