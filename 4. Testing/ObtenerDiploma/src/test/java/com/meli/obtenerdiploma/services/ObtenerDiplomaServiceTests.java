package com.meli.obtenerdiploma.services;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class ObtenerDiplomaServiceTests {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void obtenerPromedioTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        Mockito.when(studentDAO.findById(student1.getId())).thenReturn(student1);
        // Act
        obtenerDiplomaService.analyzeScores(student1.getId());
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).findById(student1.getId());
        Assertions.assertEquals(8, student1.getAverageScore());
    }
    @Test
    public void obtenerMensajeFelitacionesTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 9.0)
                )
        );
        Mockito.when(studentDAO.findById(student1.getId())).thenReturn(student1);
        // Act
        obtenerDiplomaService.analyzeScores(student1.getId());
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).findById(student1.getId());
        Assertions.assertEquals("El alumno Pedro ha obtenido un promedio de 9,33. Felicitaciones!", student1.getMessage());
    }
    @Test
    public void obtenerMensajeMejorableTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        Mockito.when(studentDAO.findById(student1.getId())).thenReturn(student1);
        // Act
        obtenerDiplomaService.analyzeScores(student1.getId());
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).findById(student1.getId());
        Assertions.assertEquals("El alumno Pedro ha obtenido un promedio de 8. Puedes mejorar.", student1.getMessage());
    }

}
