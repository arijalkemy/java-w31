package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*
       Casos nulos, vacíos, inválidos.
       Datos de Salida idénticos a datos de Entrada.
       Cálculo del Promedio.
       Leyenda del Diploma.
       Mensaje de Diploma con Honores.

   Pasos del test Unitario con Mocks
       Crear el mock IStudentDAO.
       Inyectarlo en ObtenerDiplomaService.
       Configurar su comportamiento (setup) con el método when.
       Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.
   */

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    void analyzeScores_getAvarageAndMessege() {
        //Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                                            new SubjectDTO("Física", 7.0),
                                            new SubjectDTO("Química", 6.0));
        StudentDTO studentMock = new StudentDTO(1L, "Juan", null, null, subjects);

        when(studentDAO.findById(1L)).thenReturn(studentMock);

        //Act
        StudentDTO result = service.analyzeScores(1L);

        //Assert
        assertEquals(7.33, result.getAverageScore(), 0.01);
        assertEquals("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", result.getMessage());
    }

    @Test
    void analyzeScores_getAvarageAndMessegeWithHonors() {
        //Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 10.0),
                new SubjectDTO("Química", 10.0));
        StudentDTO studentMock = new StudentDTO(12L, "Joa", null, null, subjects);

        when(studentDAO.findById(12L)).thenReturn(studentMock);

        //Act
        StudentDTO result = service.analyzeScores(12L);

        //Assert
        assertEquals(10.00, result.getAverageScore(), 0.01);
        assertEquals("El alumno Joa ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());

    }

    @Test
    void analyzeScores_shouldReturnAnException() {
        //Arrange
        when(studentDAO.findById(777L)).thenThrow(new StudentNotFoundException(777L));

        //Act & Assert
        assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(777L));

    }
}