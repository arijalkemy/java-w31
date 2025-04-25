package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void analyzeScores_shouldCalculateAverageAndMessage(){
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                                            new SubjectDTO("Física", 7.0),
                                            new SubjectDTO("Química", 6.0));
        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);

        when(studentDAO.findById(1L)).thenReturn(mockStudent);

        // Act
        StudentDTO result = service.analyzeScores(1L);


        // Assert
        assertEquals(7.33, result.getAverageScore(), 0.01);
        assertEquals("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", result.getMessage());
    }

    @Test
    public void entryAndReturn_shouldReturnSameData() {
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);

        when(studentDAO.findById(1L)).thenReturn(mockStudent);

        // Act
        StudentDTO result = studentDAO.findById(1L);


        // Assert
        assertEquals("Juan", result.getStudentName());
        assertEquals("Física", result.getSubjects().get(1).getName());
    }

    @Test
    public void analyzeScores_shouldCalculateAverageAndMessageWithHonors(){
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Historia", 10.0));
        StudentDTO mockStudent = new StudentDTO(17L, "Lucía Modificada", null, null, subjects);

        when(studentDAO.findById(17L)).thenReturn(mockStudent);

        // Act
        StudentDTO result = service.analyzeScores(17L);


        // Assert
        assertEquals(10.0, result.getAverageScore(), 0.01);
        assertEquals("El alumno Lucía Modificada ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
    }




    @Test
    public void analyzeScores_shouldReturnAnException(){
        // Arrange
        when(studentDAO.findById(999L)).thenThrow(new StudentNotFoundException(999L));

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(999L));
    }
}
