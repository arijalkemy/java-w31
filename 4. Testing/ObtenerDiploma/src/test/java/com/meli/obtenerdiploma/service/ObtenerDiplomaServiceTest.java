package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testAnalyzeScores_NullStudent() {
        // Configurar el mock para devolver null
        when(studentDAO.findById(1L)).thenReturn(null);

        // Verificar que se lanza NullPointerException
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(1L));

        // Verificar que el método findById fue llamado una vez
        verify(studentDAO, times(1)).findById(1L);
    }

    @Test
    void testAnalyzeScores_EmptySubjects() {
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, Collections.emptyList());
        when(studentDAO.findById(1L)).thenReturn(student);

        assertThrows(ArithmeticException.class, () -> obtenerDiplomaService.analyzeScores(1L));
        verify(studentDAO, times(1)).findById(1L);
    }

    @Test
    void testAnalyzeScores_CalculateAverage() {
        StudentDTO student = new StudentDTO(1L, "Juan", null, null,
                Arrays.asList(
                        new SubjectDTO("Math", 8.0),
                        new SubjectDTO("Science", 6.0)
                ));
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(7.0, result.getAverageScore());
        verify(studentDAO, times(1)).findById(1L);
    }

    @Test
    void testAnalyzeScores_DiplomaMessage() {
        StudentDTO student = new StudentDTO(1L, "Juan", null, null,
                Arrays.asList(
                        new SubjectDTO("Math", 10.0),
                        new SubjectDTO("Science", 9.5)
                ));
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertEquals("El alumno Juan ha obtenido un promedio de 9,75. Felicitaciones!", result.getMessage());
        verify(studentDAO, times(1)).findById(1L);
    }

    @Test
    void testAnalyzeScores_DiplomaMessageCanImprove() {
        StudentDTO student = new StudentDTO(1L, "Juan", null, null,
                Arrays.asList(
                        new SubjectDTO("Math", 7.0),
                        new SubjectDTO("Science", 6.0)
                ));
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertEquals("El alumno Juan ha obtenido un promedio de 6,5. Puedes mejorar.", result.getMessage());
        verify(studentDAO, times(1)).findById(1L);
    }
}
