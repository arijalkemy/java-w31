package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    void testAnalyzeScores_shouldReturnStudentDTO() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudent = new StudentDTO(
                studentId,
                "Camilo",
                "El alumno Camilo ha obtenido un promedio de 9.5. Felicitaciones!",
                9.5,
                List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 10.0))
        );
        when(service.analyzeScores(studentId)).thenReturn(expectedStudent);
        // Act
        StudentDTO result = controller.analyzeScores(studentId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedStudent.getId(), result.getId());
        assertEquals(expectedStudent.getStudentName(), result.getStudentName());
        assertEquals(expectedStudent.getAverageScore(), result.getAverageScore());
        assertEquals(expectedStudent.getMessage(), result.getMessage());
        assertEquals(expectedStudent.getSubjects(), result.getSubjects());
    }

    @Test
    void testAnalyzeScores_whenNotFound_shouldThrowException() {
        // Arrange
        Long studentId = 999L;
        when(service.analyzeScores(studentId)).thenThrow(new StudentNotFoundException(studentId));
        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> controller.analyzeScores(studentId));
    }


}
