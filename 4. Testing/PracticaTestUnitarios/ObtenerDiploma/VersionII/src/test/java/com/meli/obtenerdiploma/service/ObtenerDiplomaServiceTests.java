package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
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
import com.meli.obtenerdiploma.utils.Utils;

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

    @BeforeEach
    void setUp() {
        try {
            Utils.emptyUsersFile();
        } catch (IOException e) {
            fail("Error al restaurar el archivo de usuarios: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test ObtenerDiplomaService - Caso válido sin honores: id existente -> cálculo de promedio y mensaje incluye 'Puedes mejorar'")
    void analyzeScoresTestI() {
        // Arrange
        StudentDTO student = Utils.createRegularStudent();
        Double expectedAverage = student.getSubjects()
                .stream()
                .mapToDouble(SubjectDTO::getScore)
                .average()
                .orElse(0.0);
        Mockito.when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = service.analyzeScores(student.getId());

        // Assert
        assertNotNull(result);
        assertEquals(expectedAverage, result.getAverageScore());
        assertTrue(result.getMessage().contains(student.getStudentName()));
        assertTrue(result.getMessage().contains("Puedes mejorar"));
    }

    @Test
    @DisplayName("Test ObtenerDiplomaService - Caso válido con honores: id existente -> cálculo de promedio y mensaje incluye 'Felicitaciones!'")
    void analyzeScoresTestII() {
        // Arrange
        StudentDTO student = Utils.createStudentWithHonors();
        Double expectedAverage = student.getSubjects()
                .stream()
                .mapToDouble(SubjectDTO::getScore)
                .average()
                .orElse(0.0);
        Mockito.when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = service.analyzeScores(student.getId());

        // Assert
        assertEquals(expectedAverage, result.getAverageScore());
        assertTrue(result.getMessage().contains(student.getStudentName()));
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
        // Arrange
        StudentDTO student = Utils.createInvalidStudent();
        Mockito.when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = service.analyzeScores(student.getId());

        // Assert
        assertNotNull(result);
        assertTrue(Double.isNaN(result.getAverageScore()), "El promedio debe ser NaN cuando no hay materias.");
        assertTrue(result.getMessage().contains("NaN"), "El mensaje debe indicar que el promedio es NaN.");
    }

}