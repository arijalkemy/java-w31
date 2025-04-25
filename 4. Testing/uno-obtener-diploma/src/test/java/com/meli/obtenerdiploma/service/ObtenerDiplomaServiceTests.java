package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void givenHighScores_whenAnalyzeScore_thenCorrectMessageAndHighAverage(){
        // Arrange - Given
        StudentDTO studentDTO = new StudentDTO(1L, "Laura",
                List.of(new SubjectDTO("Italian", 10D),
                        new SubjectDTO("English", 10D)
                ));
        long id = studentDTO.getId();
        double expectedAverage = studentDTO.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(expectedAverage) + ". Felicitaciones!";

        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);

        // Act - When
        StudentDTO returnedStudent = obtenerDiplomaService.analyzeScores(id);

        // Assert - Then
        Mockito.verify(studentDAO, Mockito.times(1)).findById(id);
        Assertions.assertEquals(expectedAverage, returnedStudent.getAverageScore());
        Assertions.assertEquals(expectedMessage, returnedStudent.getMessage());
    }

    @Test
    public void givenLowScores_whenAnalyzeScore_thenCorrectMessageAndLowAverage(){
        // Arrange - Given
        StudentDTO studentDTO = new StudentDTO(1L, "Laura",
                List.of(new SubjectDTO("Italian", 1D),
                        new SubjectDTO("English", 2D)
                ));
        long id = studentDTO.getId();
        double expectedAverage = studentDTO.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(expectedAverage) + ". Puedes mejorar.";

        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);

        // Act - When
        StudentDTO returnedStudent = obtenerDiplomaService.analyzeScores(id);

        // Assert - Then
        Mockito.verify(studentDAO, Mockito.times(1)).findById(id);
        Assertions.assertEquals(expectedAverage, returnedStudent.getAverageScore());
        Assertions.assertEquals(expectedMessage, returnedStudent.getMessage());
    }
}
