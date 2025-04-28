package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.Utils;

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

    @BeforeEach
    void setUp() {
        try {
            Utils.emptyUsersFile();
        } catch (IOException e) {
            fail("Error al restaurar el archivo de usuarios: " + e.getMessage());
        }
    }

    @Test
    void analyzeScoresTest() {
        // Arrange
        StudentDTO student = Utils.createStudent();

        // Act
        obtenerDiplomaController.analyzeScores(student.getId());

        // Assert
        verify(obtenerDiplomaService, atLeast(1)).analyzeScores(student.getId());

    }
}
