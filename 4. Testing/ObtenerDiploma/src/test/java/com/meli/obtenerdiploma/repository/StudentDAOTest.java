package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new ClassPathResource("test-users.json").getFile();
        Set<StudentDTO> testData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {});
        studentDAO.students = new HashSet<>(testData);
    }

    @Test
    void testAddStudent() {
        // Arrange
        StudentDTO newStudent = new StudentDTO(null, "Juan Perez", null, null, null);

        // Act
        studentDAO.save(newStudent);

        // Assert
        assertNotNull(newStudent.getId());
        assertTrue(studentDAO.students.contains(newStudent));
    }

    @Test
    void testFindStudentById() {
        // Arrange
        Long studentId = 1L;

        // Act
        StudentDTO student = studentDAO.findById(studentId);

        // Assert
        assertNotNull(student);
        assertEquals(studentId, student.getId());
    }

    @Test
    void testFindStudentByIdNotFound() {
        // Arrange
        Long nonExistentId = 999L;

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(nonExistentId));
    }

    @Test
    void testUpdateStudent() {
        // Arrange
        StudentDTO updatedStudent = new StudentDTO(1L, "Juan Modificado", null, null, null);

        // Act
        studentDAO.save(updatedStudent);

        // Assert
        StudentDTO result = studentDAO.findById(1L);
        assertEquals("Juan Modificado", result.getStudentName());
    }

    @Test
    void testDeleteStudent() {
        // Arrange
        Long studentId = 1L;

        // Act
        boolean deleted = studentDAO.delete(studentId);

        // Assert
        assertTrue(deleted);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentId));
    }

    @Test
    void testDeleteStudentNotFound() {
        // Arrange
        Long nonExistentId = 999L;

        // Act
        boolean deleted = studentDAO.delete(nonExistentId);

        // Assert
        assertFalse(deleted);
    }
}
