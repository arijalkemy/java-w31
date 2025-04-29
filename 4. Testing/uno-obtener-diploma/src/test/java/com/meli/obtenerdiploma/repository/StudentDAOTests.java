package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTests {
    StudentDAO studentDAO;

    @BeforeEach @AfterEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
       studentDAO  = new StudentDAO();
    }

    @Test
    public void givenStudent_whenSaveStudent_thenExists() {
        // Arrange - Given
        StudentDTO studentDTO = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores("Laura");
        Long expectedId = 1L;

        // Act - When
        studentDAO.save(studentDTO);

        // Assert - Then
        assertNotNull(studentDTO.getId());
        assertEquals(expectedId, studentDTO.getId());
    }

    @Test
    public void givenExistingIdAndDifferentData_whenSaveStudent_thenUpdatesStudent() {
        // Arrange - Given
        StudentDTO studentDTO = new StudentDTO(1L, "Laura",
                List.of(new SubjectDTO("Italian", 7D),
                        new SubjectDTO("English", 9D),
                        new SubjectDTO("Spanish", 10D)
                ));
        long expectedId = 1L;

        // Act - When
        studentDAO.save(studentDTO);

        // Assert - Then
        assertEquals(expectedId, studentDTO.getId());
    }

    @Test
    public void givenExistingId_whenDeleteStudent_thenReturnsTrue() {
        // Arrange - Given
        StudentDTO studentDTO = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores("Juan");

        studentDAO.save(studentDTO);
        long studentId = studentDTO.getId();

        // Act - When
        boolean removed = studentDAO.delete(studentId);

        // Assert - Then
        Assertions.assertTrue(removed);
    }

    @Test
    public void givenNotExistingId_whenDeleteStudent_thenReturnsFalse() {
        // Arrange - Given
        long studentId = 100L;

        // Act - When
        boolean removed = studentDAO.delete(studentId);

        // Assert - Then
        Assertions.assertFalse(removed);
    }

    @Test
    public void givenExistingId_whenFindById_thenReturnStudent() {
        // Arrange - Given
        StudentDTO expectedStudentDTO = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores("Marco");
        studentDAO.save(expectedStudentDTO);
        long studentId = expectedStudentDTO.getId();

        // Act - When
        StudentDTO foundStudentDTO = studentDAO.findById(studentId);

        // Assert - Then
        assertEquals(expectedStudentDTO, foundStudentDTO);
    }

    @Test
    public void givenNotExistingId_whenFindById_thenThrowsStudentNotFoundException() {
        // Arrange - Given
        long studentId = 100L;

        // Act - When & Assert - Then
        Assertions.assertThrows(StudentNotFoundException.class, () -> {studentDAO.findById(studentId);});
    }

    @Test
    public void givenExistingId_whenExists_thenReturnsTrue() {
        // Arrange - Given
        StudentDTO studentDTO = TestUtilsGenerator.createStudentWithThreeSubjectsLowScores("Marco");
        studentDAO.save(studentDTO);

        // Act - When
        boolean exists = studentDAO.exists(studentDTO);

        // Assert - Then
        Assertions.assertTrue(exists);
    }

    @Test
    public void givenNotExistingId_whenExists_thenReturnsFalse() {
        // Arrange - Given
        StudentDTO studentDTO = TestUtilsGenerator.createStudentWithThreeSubjectsLowScores("Marta");

        // Act - When
        boolean exists = studentDAO.exists(studentDTO);

        // Assert - Then
        Assertions.assertFalse(exists);
    }
}
