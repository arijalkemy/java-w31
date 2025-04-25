package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresValid() {

        // Arrange
        Long studentId = 1L;
        StudentDTO devolucion = new StudentDTO(10L, "Juancito", null,
                null, null);

        // Act

        when(service.analyzeScores(studentId)).thenReturn(devolucion);
        StudentDTO obtained = obtenerDiplomaController.analyzeScores(studentId);

        // Asserts
        assertEquals(devolucion, obtained);
    }
}