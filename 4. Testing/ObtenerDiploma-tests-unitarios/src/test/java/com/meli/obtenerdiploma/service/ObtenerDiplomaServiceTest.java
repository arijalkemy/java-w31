package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresBelowNineTest() {
        // arrange
        Long param = 1L;
        StudentDTO foundStudentDTO = createStudentDTO();
        StudentDTO expectedStudentDTO = createExpectedStudentDTO();
        when(studentDAO.findById(param)).thenReturn(foundStudentDTO);
        // act
        StudentDTO obtainedStudentDTO = obtenerDiplomaService.analyzeScores(param);
        // assert
        assertThat(obtainedStudentDTO.getMessage()).isEqualTo(expectedStudentDTO.getMessage());
        assertThat(obtainedStudentDTO.getAverageScore()).isEqualTo(expectedStudentDTO.getAverageScore());

    }

    @Test
    public void analyzeScoresAboveNineTest() {
        // arrange
        Long param = 3L;
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 9.0),
                new SubjectDTO("Química", 9.0));

        StudentDTO foundStudentDTO = new StudentDTO(
                param, "Romina", null, null,
                subjects
        );
        StudentDTO expectedStudentDTO = new StudentDTO(
                param,
                "Romina",
                "El alumno Romina ha obtenido un promedio de 9,33. Felicitaciones!",
                subjects.stream()
                        .mapToDouble(SubjectDTO::getScore)
                        .average().orElseThrow(),
                subjects
        );

        when(studentDAO.findById(param)).thenReturn(foundStudentDTO);
        // act
        StudentDTO obtainedStudentDTO = obtenerDiplomaService.analyzeScores(param);
        // assert
        assertThat(obtainedStudentDTO.getMessage()).isEqualTo(expectedStudentDTO.getMessage());
        assertThat(obtainedStudentDTO.getAverageScore()).isEqualTo(expectedStudentDTO.getAverageScore());
    }

    @Test
    public void analyzeScoresStudentNotFoundTest() {
        // arrange
        Long param = 6L;
        when(studentDAO.findById(param)).thenThrow(new StudentNotFoundException(param));
        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            obtenerDiplomaService.analyzeScores(param);
        });
    }


    // DATA GENERATION METHODS
    private StudentDTO createExpectedStudentDTO() {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));

        return new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                subjects.stream()
                        .mapToDouble(SubjectDTO::getScore)
                        .average().orElseThrow(),
                subjects);
    }

    private StudentDTO createStudentDTO() {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));

        return new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                subjects);
    }
}
