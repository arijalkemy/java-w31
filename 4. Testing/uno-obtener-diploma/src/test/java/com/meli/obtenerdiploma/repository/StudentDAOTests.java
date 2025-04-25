package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentDAOTests {
    StudentDAO studentDAO = new StudentDAO();

    @Test
    public void givenStudent_whenSaveStudent_thenExists() {
        // Arrange - Given
        StudentDTO studentDTO = new StudentDTO(0L, "Laura", "", 0D,
                List.of(new SubjectDTO("Italian", 10D),
                        new SubjectDTO("English", 10D)));

        // Act - When
        StudentDTO savedStudent = studentDAO.save(studentDTO);
        boolean exists = studentDAO.exists(savedStudent);

        // Assert - Then
        Assertions.assertTrue(exists);
    }

    @Test
    public void givenExistingIdAndDifferentData_whenSaveStudent_thenUpdatesStudent() {
        // Arrange - Given
        StudentDTO studentDTO = new StudentDTO(3L, "Laura", "", 0D,
                List.of(new SubjectDTO("Italian", 7D),
                        new SubjectDTO("English", 9D),
                        new SubjectDTO("Spanish", 10D)
                ));

        // Act - When
        StudentDTO savedStudent = studentDAO.save(studentDTO);

        // Assert - Then
        Assertions.assertEquals(savedStudent.getId(), studentDTO.getId());
    }

    @Test
    public void givenExistingId_whenDeleteStudent_thenReturnsTrue() {
        // Arrange - Given
        StudentDTO studentDTO = new StudentDTO(10L, "Juan", "", 0D,
                List.of(new SubjectDTO("Matemática", 9D),
                        new SubjectDTO("Física", 7D),
                        new SubjectDTO("Química", 6D)
                ));

        long studentId = studentDAO.save(studentDTO).getId();

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
        StudentDTO expectedStudentDTO = new StudentDTO(3L, "Laura", "", 0D,
                List.of(new SubjectDTO("Italian", 7D),
                        new SubjectDTO("English", 9D),
                        new SubjectDTO("Spanish", 10D)
                ));

        // Act - When
        StudentDTO foundStudentDTO = studentDAO.findById(expectedStudentDTO.getId());

        // Assert - Then
        Assertions.assertEquals(expectedStudentDTO, foundStudentDTO);
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
        StudentDTO studentDTO = new StudentDTO(3L, "Laura", "", 0D,
                List.of(new SubjectDTO("Italian", 10D), new SubjectDTO("English", 10D)));

        // Act - When
        boolean exists = studentDAO.exists(studentDTO);

        // Assert - Then
        Assertions.assertTrue(exists);
    }

    @Test
    public void givenNotExistingId_whenExists_thenReturnsFalse() {
        // Arrange - Given
        StudentDTO studentDTO = new StudentDTO(100L, "Laura", "", 0D,
                List.of(new SubjectDTO("Italian", 10D), new SubjectDTO("English", 10D)));

        // Act - When
        boolean exists = studentDAO.exists(studentDTO);

        // Assert - Then
        Assertions.assertFalse(exists);
    }
}
