package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaExceptionController;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void analyzeScores_shouldReturnStudentWithAverageAndMessage(){
        // Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));

        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);
        mockStudent.setAverageScore(7.33);
        mockStudent.setMessage("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.");

        when(service.analyzeScores(1L)).thenReturn(mockStudent);

        // Act
        StudentDTO result = controller.analyzeScores(1L);

        // Assert
        assertEquals(mockStudent, result);
        verify(service).analyzeScores(1L);
    }

    @Test
    public void analyzeScores_withBadData_shouldReturnException(){
        // Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("jj", 9.0));

        StudentDTO mockStudent = new StudentDTO(1L, "juan", null, null, subjects);
        mockStudent.setAverageScore(9.0);
        mockStudent.setMessage("El alumno juan ha obtenido un promedio de 9. Puedes mejorar.");

        when(service.analyzeScores(1L)).thenThrow(ObtenerDiplomaException.class);

        //  Act & Assert
        assertThrows(ObtenerDiplomaException.class, () -> controller.analyzeScores(1L));
    }

    }

