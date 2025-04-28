package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private List<SubjectDTO> sampleSubjects(double... scores) {
        List<SubjectDTO> subjects = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            subjects.add(new SubjectDTO("Materia " + i, scores[i]));
        }
        return subjects;
    }

    @Test
    public void testAnalyzeScores_shouldCalculateAverageAndMessage() {
        // Arrange
        Long studentId = 1L;
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Historia", 7.0),
                new SubjectDTO("Lengua", 8.0)
        );
        StudentDTO student = new StudentDTO(studentId, "Mateo", null, null, subjects);
        when(studentDAO.findById(studentId)).thenReturn(student);
        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);
        // Assert
        assertEquals(studentId, result.getId());
        assertEquals(8.0, result.getAverageScore());
        assertNotNull(result.getMessage());
        assertTrue(result.getMessage().contains("Mateo"));
        verify(studentDAO).findById(studentId);
    }

    @Test
    public void testAnalyzeScores_basicCase() {
        // Arrange
        Long id = 1L;
        StudentDTO stu = new StudentDTO(id, "Sara", null, null, sampleSubjects(8.0, 7.0, 9.0));
        when(studentDAO.findById(id)).thenReturn(stu);
        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);
        // Assert
        assertEquals(8.0, result.getAverageScore());
        assertTrue(result.getMessage().contains("Puedes mejorar"));
    }

    @Test
    public void testAnalyzeScores_withHonors() {
        // Arrange
        Long id = 2L;
        StudentDTO stu = new StudentDTO(id, "Pedro Torres", null, null, sampleSubjects(10.0, 9.5, 9.8));
        when(studentDAO.findById(id)).thenReturn(stu);
        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);
        // Assert
        assertEquals(9.77, result.getAverageScore(), 0.01);
        assertTrue(result.getMessage().contains("Felicitaciones"));
    }

    @Test
    public void testAnalyzeScores_emptySubjects_throwsException() {
        // Arrange
        Long id = 3L;
        StudentDTO stu = new StudentDTO(id, "Ana", null, null, new ArrayList<>());
        when(studentDAO.findById(id)).thenReturn(stu);
        // Act Assert
        Double averageScore = obtenerDiplomaService.analyzeScores(id).getAverageScore();
        assertTrue(Double.isNaN(averageScore));
    }

    @Test
    public void testAnalyzeScores_nullStudent_throwsException() {
        Long id = 4L;
        when(studentDAO.findById(id)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(id));
    }

    @Test
    public void testAnalyzeScores_subjectWithNull_throwsException() {
        Long id = 5L;
        List<SubjectDTO> subjects = Arrays.asList(new SubjectDTO("Math", null));
        StudentDTO stu = new StudentDTO(id, "Carlos", null, null, subjects);
        when(studentDAO.findById(id)).thenReturn(stu);
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(id));
    }

    @Test
    public void testAnalyzeScores_outputRespectsInput() {
        Long id = 6L;
        StudentDTO original = new StudentDTO(id, "Majo", null, null, sampleSubjects(7.0, 9.0));
        when(studentDAO.findById(id)).thenReturn(original);
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);
        assertEquals("Majo", result.getStudentName());
        assertEquals(original.getSubjects(), result.getSubjects());
    }

    @Test
    public void testAnalyzeScores_averageRounding() {
        Long id = 7L;
        StudentDTO stu = new StudentDTO(id, "Esteban", null, null, sampleSubjects(8.333, 8.333, 8.334));
        when(studentDAO.findById(id)).thenReturn(stu);
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);
        assertEquals(8.33, result.getAverageScore(), 0.01);
        assertTrue(result.getMessage().contains("8,33"));
    }

    @Test
    void testAnalyzeScores_whenStudentNotFound_shouldThrowException() {
        // Arrange
        Long studentId = 999L;
        when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));
        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
    }

}
