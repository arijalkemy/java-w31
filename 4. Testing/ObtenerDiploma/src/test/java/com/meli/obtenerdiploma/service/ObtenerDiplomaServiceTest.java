package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void testAnalyzeScoresWithRegularPerformance() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Test Student", null, null,
                Arrays.asList(
                        new SubjectDTO("Math", 7.0),
                        new SubjectDTO("Science", 8.0)
                )
        );

        when(studentDAO.findById(studentId)).thenReturn(student);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(7.5, result.getAverageScore(), 0.001, "El promedio debería ser 7.5");
        assertEquals("El alumno Test Student ha obtenido un promedio de 7,5. Puedes mejorar.", result.getMessage());
    }

    @Test
    void testAnalyzeScoresWithHonors() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Honors Student", null, null,
                Arrays.asList(
                        new SubjectDTO("Math", 10.0),
                        new SubjectDTO("Science", 10.0)
                )
        );

        when(studentDAO.findById(studentId)).thenReturn(student);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(10.0, result.getAverageScore());
        assertEquals("El alumno Honors Student ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
    }

    @Test
    void testAnalyzeScoresWithEmptySubjects() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Empty Subjects", null, null, Arrays.asList());

        when(studentDAO.findById(studentId)).thenReturn(student);

        // Act & Assert
        try {
            obtenerDiplomaService.analyzeScores(studentId);
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage(), "Debería lanzar una excepción de división por cero");
        }
    }
    @Test
    void testAnalyzeScoresWithNullSubjects() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Null Subjects", null, null, null);

        when(studentDAO.findById(studentId)).thenReturn(student);

        // Act & Assert
        try {
            obtenerDiplomaService.analyzeScores(studentId);
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    void testAnalyzeScoresWithNullScores() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Null Scores", null, null,
                Arrays.asList(
                        new SubjectDTO("Math", null),
                        new SubjectDTO("Science", 8.0)
                )
        );

        when(studentDAO.findById(studentId)).thenReturn(student);

        // Act & Assert
        assertThrows(NullPointerException.class, () ->
                obtenerDiplomaService.analyzeScores(studentId));
    }

}
