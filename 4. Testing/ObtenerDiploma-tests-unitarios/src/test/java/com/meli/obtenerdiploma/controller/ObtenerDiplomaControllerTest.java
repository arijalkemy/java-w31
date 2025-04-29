package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private ObtenerDiplomaService service;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresTest() {
        // arrange
        Long studentId = 1L;
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        StudentDTO expectedStudent = new StudentDTO(
                studentId,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                subjects.stream()
                        .mapToDouble(SubjectDTO::getScore)
                        .average().orElseThrow(),
                subjects
        );


        when(service.analyzeScores(studentId)).thenReturn(expectedStudent);
        // act
        StudentDTO obtainedStudent = obtenerDiplomaController.analyzeScores(studentId);
        // assert
        verify(service, times(1)).analyzeScores(studentId);
        assertThat(obtainedStudent).isEqualTo(expectedStudent);
    }
}
