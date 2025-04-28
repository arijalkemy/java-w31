package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    //crear mock en la interfaz - mockear dependencia del DAO
    @Mock
    private IObtenerDiplomaService service;
    //inyectar mock en el service
    @InjectMocks
    private ObtenerDiplomaController controller;

    // test principal: verificar que el controller llame al service y retorne el resultado esperado
    @Test
    void testReturnDiplomaWhenStudentExists() {
        // Arrange: configura el mock con datos esperados
        Long studentId = 1L;

        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setId(studentId);
        expectedStudent.setStudentName("Jose");
        expectedStudent.setAverageScore(9.5);
        expectedStudent.setMessage("El alumno Jose ha obtenido un promedio de 9.5. Felicitaciones!");

        when(service.analyzeScores(studentId)).thenReturn(expectedStudent);

        // Act: llama al metodo del controller
        StudentDTO result = controller.analyzeScores(studentId);

        // Assert: verifica interacción y resultado
        verify(service, times(1)).analyzeScores(studentId);
        assertThat(result).isEqualTo(expectedStudent);
    }

    // test caso borde: cuando el service devuelve null
    @Test
    void shouldReturnNullWhenStudentNotFound() {
        Long invalidId = 99L;

        when(service.analyzeScores(invalidId)).thenReturn(null);

        StudentDTO result = controller.analyzeScores(invalidId);

        verify(service).analyzeScores(invalidId);
        assertThat(result).isNull();
    }

}
