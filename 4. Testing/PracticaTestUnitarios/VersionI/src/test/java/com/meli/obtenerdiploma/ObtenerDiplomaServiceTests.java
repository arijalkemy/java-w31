package com.meli.obtenerdiploma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;

/*
 * EJERCICIO 2: TEST UNITARIOS CON MOCKS
 * Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa
 * de servicios ObtenerDiplomaService. Tener en cuenta múltiples escenarios y “casos borde”
 * de cada comportamiento.
 *  - Casos nulos, vacíos, inválidos.
 *  - Datos de Salida idénticos a datos de Entrada.
 *  - Cálculo del Promedio.
 *  - Leyenda del Diploma.
 *  - Mensaje de Diploma con Honores.
 */

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTests {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    @DisplayName("Test ObtenerDiplomaService - Caso válido sin honores: id existente -> cálculo de promedio y mensaje incluye 'Puedes mejorar'")
    void analyzeScoresTestI() {
        StudentDTO student = new StudentDTO(100L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0)));
        double expectedAverage = (8.0 + 9.0 + 7.0) / 3.0; // 8.0

        Mockito.when(studentDAO.findById(100L)).thenReturn(student);

        StudentDTO result = service.analyzeScores(100L);

        assertNotNull(result);
        assertEquals(expectedAverage, result.getAverageScore());
        assertTrue(result.getMessage().contains("Ana Lopez"));
        assertTrue(result.getMessage().contains("Puedes mejorar"));
    }

    @Test
    @DisplayName("Test ObtenerDiplomaService - Caso válido con honores: id existente -> cálculo de promedio y mensaje incluye 'Felicitaciones!'")
    void analyzeScoresTestII() {
        StudentDTO student = new StudentDTO(200L, "Carlos Gomez", null, null,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 9.5), new SubjectDTO("History", 9.6)));
        double expectedAverage = (10.0 + 9.5 + 9.6) / 3.0; // 9.7

        when(studentDAO.findById(200L)).thenReturn(student);

        StudentDTO result = service.analyzeScores(200L);
        assertEquals(expectedAverage, result.getAverageScore());
        assertTrue(result.getMessage().contains("Carlos Gomez"));
        assertTrue(result.getMessage().contains("Felicitaciones!"));
    }

    @Test
    @DisplayName("Test ObtenerDiplomaService - Sad path: id nulo -> lanza NullPointerException")
    void analyzeScoresSadPathI() {
        assertThrows(NullPointerException.class, () -> service.analyzeScores(null));
    }

    @Test
    @DisplayName("Test ObtenerDiplomaService - Sad path: id inexistente -> lanza NullPointerException")
    void analyzeScoresSadPathII() {
        assertThrows(NullPointerException.class, () -> service.analyzeScores(-1L));
    }

    @Test
    @DisplayName("Test ObtenerDiplomaService - Sad path: estudiante con materias vacía -> promedio NaN y mensaje adecuado")
    void analyzeScoresSadPathIII() {
        StudentDTO student = new StudentDTO();
        student.setId(3L);
        student.setStudentName("Empty Student");
        student.setSubjects(Collections.emptyList());

        Mockito.when(studentDAO.findById(3L)).thenReturn(student);

        StudentDTO result = service.analyzeScores(3L);

        assertNotNull(result);
        assertTrue(Double.isNaN(result.getAverageScore()), "El promedio debe ser NaN cuando no hay materias.");
        assertTrue(result.getMessage().contains("NaN"), "El mensaje debe indicar que el promedio es NaN.");
    }
}