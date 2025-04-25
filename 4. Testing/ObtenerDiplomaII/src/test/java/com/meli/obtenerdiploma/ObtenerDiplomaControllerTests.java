package com.meli.obtenerdiploma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;

/*
 * EJERCICIO 4: TEST UNITARIOS CON MOCKS
 * Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa
 * de controlador ObtenerDiplomaController, mockeando su dependencia con el servicio.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTests {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Test ObtenerDiplomaController - Caso válido: id existente -> se llama al servicio")
    void analyzeScoresTest() {
        StudentDTO student = new StudentDTO(100L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0)));
        Mockito.when(obtenerDiplomaService.analyzeScores(student.getId())).thenReturn(student);

        StudentDTO result = obtenerDiplomaController.analyzeScores(student.getId());

        verify(obtenerDiplomaService).analyzeScores(student.getId());
        assertNotNull(result);
        assertEquals(student.getId(), result.getId());
        assertEquals(student.getStudentName(), result.getStudentName());

    }

    @Test
    @DisplayName("Test ObtenerDiplomaController - Caso inválido: id nula -> se llama al servicio y lanza excepción")
    void analyzeScoresSadPathI() {
        Long studentId = null;
        Mockito.when(obtenerDiplomaService.analyzeScores(studentId)).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> obtenerDiplomaController.analyzeScores(studentId));
    }

    @Test
    @DisplayName("Test ObtenerDiplomaController - Caso inválido: id inválida -> se llama al servicio y lanza excepción")
    void analyzeScoresSadPathII() {
        Long studentId = -1L;
        Mockito.when(obtenerDiplomaService.analyzeScores(studentId)).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> obtenerDiplomaController.analyzeScores(studentId));
    }

}
