package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    /*
    @GetMapping("/analyzeScores/{studentId}")
    public StudentDTO analyzeScores(@PathVariable Long studentId) {
        return service.analyzeScores(studentId);
    }
     */

    @Test
    void testAnalyzeScores(){

        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(100L);
        studentDTO.setStudentName("Miguel");
        studentDTO.setMessage("Felicitaciones");
        studentDTO.setAverageScore(9.0);

        when(service.analyzeScores(100L)).thenReturn(studentDTO);

        //Act
        StudentDTO resultado = controller.analyzeScores(100L);

        //Assert
        assertEquals(100L,resultado.getId());
        assertEquals("Miguel",resultado.getStudentName());

        verify(service,times(1)).analyzeScores(100L);
    }

}
