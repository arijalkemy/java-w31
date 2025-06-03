package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddStudent() {
        // Arrange
        StudentDTO newStudent = new StudentDTO(3L, "Maria", null, null, null);

        // Act
        studentDAO.save(newStudent);
        StudentDTO returnStudent = studentDAO.findById(newStudent.getId());

        // Assert
        assertNotNull(returnStudent);
        assertEquals("Maria", returnStudent.getStudentName());
    }
    @Test
    void testFindStudentById() {
        // Arrange
        Long studentId = 1L;

        // Act
        StudentDTO student = studentDAO.findById(studentId);

        // Assert
        assertNotNull(student);
        assertEquals("Juan", student.getStudentName());
    }

    @Test
    void testModifyStudentData() {
        // Arrange
        StudentDTO student = studentDAO.findById(1L);
        student.setStudentName("Juan Updated");

        // Act
        studentDAO.save(student);
        StudentDTO updatedStudent = studentDAO.findById(1L);

        // Assert
        assertEquals("Juan Updated", updatedStudent.getStudentName());
    }

    @Test
    void testDeleteStudent() {
        // Arrange
        Long studentId = 3L;

        // Act
        boolean removed = studentDAO.delete(studentId);
        Exception exception = assertThrows(RuntimeException.class, () -> studentDAO.findById(studentId));

        // Assert
        assertTrue(removed);
    }

    @Test
    void testHandleNonExistentStudent() {
        // Arrange
        Long nonExistentId = 20L;

        // Act and Assert
        Exception exception = assertThrows(RuntimeException.class, () -> studentDAO.findById(nonExistentId));
    }

    @Test
    void testExistsStudent() {
        // Arrange
        Long existingStudentId = 1L;
        StudentDTO existingStudent = new StudentDTO(existingStudentId, null, null, null, null);

        // Act
        boolean exists = studentDAO.exists(existingStudent);

        // Assert
        assertTrue(exists, "El estudiante con ID 1 debería existir");
    }
}
