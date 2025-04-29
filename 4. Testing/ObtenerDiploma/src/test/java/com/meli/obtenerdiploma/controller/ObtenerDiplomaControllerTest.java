package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void analyzeScores() {
        // Arrange
        Long studentId = 1L;
        StudentDTO mockStudent = new StudentDTO(studentId, "Juan", "¡Felicitaciones!", 9.5, null);
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(mockStudent);

        // Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(studentId);

        // Assert
        assertNotNull(result);
        assertEquals(studentId, result.getId());
        assertEquals("Juan", result.getStudentName());
        assertEquals("¡Felicitaciones!", result.getMessage());
        assertEquals(9.5, result.getAverageScore());


        verify(obtenerDiplomaService, times(1)).analyzeScores(studentId);
    }
}