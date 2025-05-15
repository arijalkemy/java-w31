package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService diplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analizarScoresTest() {
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
        // Act
        obtenerDiplomaController.analyzeScores(student1.getId());
        // Assert
        Mockito.verify(diplomaService, Mockito.atLeastOnce()).analyzeScores(student1.getId());
    }
}
