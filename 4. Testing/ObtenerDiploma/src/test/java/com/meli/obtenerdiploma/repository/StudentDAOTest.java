package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

public class StudentDAOTest {

    private static IStudentDAO studentDAO;
    private static List<SubjectDTO> subjects;

    @BeforeAll
    static void setUp() {
        studentDAO = new StudentDAO();

        subjects = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Math", 100.0);
        SubjectDTO subject2 = new SubjectDTO("English", 100.0);
        SubjectDTO subject3 = new SubjectDTO("Spanish", 100.0);
        subjects.add(subject);
        subjects.add(subject2);
        subjects.add(subject3);
    }

    @Test
    void testSaveNewStudent() {
        // Arrange
        List<SubjectDTO> subjects = this.subjects;
        StudentDTO student = new StudentDTO(null, "John Doe", "Default message", 50.0, subjects);

        // Act
        studentDAO.save(student);

        // Assert
        assertNotNull(student.getId());
        studentDAO.delete(student.getId());
    }

    @Test
    void testSaveOldStudent() {
        // Arrange
        List<SubjectDTO> subjects = this.subjects;
        StudentDTO student = new StudentDTO(null, "John Doe", "Default message", 50.0, subjects);
        StudentDTO student2 = new StudentDTO(null, "John Doe", "New message", 40.0, subjects);

        // Act
        studentDAO.save(student);
        Long id = student.getId();
        student2.setId(id);
        studentDAO.save(student2);

        // Assert
        assertEquals(studentDAO.findById(id), student2);
        studentDAO.delete(id);
    }

    @Test
    void testDeleteStudent() {
        // Arrange
        List<SubjectDTO> subjects = this.subjects;
        StudentDTO student = new StudentDTO(null, "John Doe", "Default message", 50.0, subjects);
        studentDAO.save(student);

        // Act
        Boolean response = studentDAO.delete(student.getId());

        // Assert
        assertTrue(response);
    }

    @Test
    void testDeleteNotFound() {
        // Act
        Boolean response = studentDAO.delete(Long.MIN_VALUE);

        // Assert
        assertFalse(response);
    }

    @Test
    void testExistsStudent() {
        // Arrange
        List<SubjectDTO> subjects = this.subjects;
        StudentDTO student = new StudentDTO(null, "John Doe", "Default message", 50.0, subjects);
        studentDAO.save(student);

        // Act
        Boolean response = studentDAO.exists(student);

        // Assert
        assertTrue(response);
        studentDAO.delete(student.getId());
    }

    @Test
    void testExistsStudentNotFound() {
        // Arrange
        List<SubjectDTO> subjects = this.subjects;
        StudentDTO student = new StudentDTO(null, "John Doe", "Default message", 50.0, subjects);

        // Act
        Boolean response = studentDAO.exists(student);

        // Assert
        assertFalse(response);
    }

    @Test
    void testFindByIdStudent() {
        // Arrange
        List<SubjectDTO> subjects = this.subjects;
        StudentDTO student = new StudentDTO(null, "John Doe", "Default message", 50.0, subjects);
        studentDAO.save(student);

        // Act
        StudentDTO found = studentDAO.findById(student.getId());

        // Assert
        assertEquals(student, found);
        studentDAO.delete(student.getId());
    }

    @Test
    void testFindByIdException() {
        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(Long.MIN_VALUE);
        });
    }
}
