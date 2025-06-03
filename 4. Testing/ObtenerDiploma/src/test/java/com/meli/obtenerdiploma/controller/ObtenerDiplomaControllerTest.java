package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void testAnalyzeScores() {
        // Arrange
        Long studentId = 1L;
        StudentDTO mockStudent = new StudentDTO(studentId
                , "Juan"
                , "El alumno Juan ha obtenido un promedio de 8. Felicitaciones!"
                , 8.0
                , null);

        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(mockStudent);

        // Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(studentId);

        // Assert
        verify(obtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(studentId);
        assertEquals(mockStudent, result);
    }
}
