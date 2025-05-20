package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void testAnalyzeScores() {
        //Arrange
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO(id, "Juan", "Score analizado", 28D, new ArrayList<>());
        when(obtenerDiplomaService.analyzeScores(id)).thenReturn(studentDTO);
        //Act
        StudentDTO studentDTO2 = obtenerDiplomaController.analyzeScores(id);
        //Assert
        Assertions.assertEquals(studentDTO, studentDTO2);
    }
}
