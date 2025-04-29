package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void givenHighScores_whenAnalyzeScore_thenCorrectMessageAndHighAverage(){
        // Arrange - Given
        StudentDTO studentDTO = TestUtilsGenerator.createStudentWithThreeSubjectsHighScores("Carlos");
        studentDTO.setId(1L);
        long id = studentDTO.getId();
        double expectedAverage = studentDTO.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(expectedAverage) + ". Felicitaciones!";

        when(studentDAO.findById(id)).thenReturn(studentDTO);

        // Act - When
        StudentDTO returnedStudent = obtenerDiplomaService.analyzeScores(id);

        // Assert - Then
        verify(studentDAO, atLeastOnce()).findById(id);
        assertEquals(expectedAverage, returnedStudent.getAverageScore());
        assertEquals(expectedMessage, returnedStudent.getMessage());
    }

    @Test
    public void givenLowScores_whenAnalyzeScore_thenCorrectMessageAndLowAverage(){
        // Arrange - Given
        StudentDTO studentDTO = TestUtilsGenerator.createStudentWithThreeSubjectsLowScores("Mario");
        studentDTO.setId(1L);
        long id = studentDTO.getId();
        double expectedAverage = studentDTO.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(expectedAverage) + ". Puedes mejorar.";

        when(studentDAO.findById(id)).thenReturn(studentDTO);

        // Act - When
        StudentDTO returnedStudent = obtenerDiplomaService.analyzeScores(id);

        // Assert - Then
        verify(studentDAO, atLeastOnce()).findById(id);
        assertEquals(expectedAverage, returnedStudent.getAverageScore());
        assertEquals(expectedMessage, returnedStudent.getMessage());
    }
}
