package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    StudentDTO student;
    SubjectDTO subject1;
    SubjectDTO subject2;

    @BeforeEach
    void setUp() {

        // Arrange
        subject1 = new SubjectDTO("Math", 9.0);
        subject2 = new SubjectDTO("English", 8.0);
        student = new StudentDTO(1L, "Jane Doe", "Lorem ipsum", 8.5, List.of(subject1, subject2));
    }

    @Test
    void analyzeScores_ok() {

        // Arrange
        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(student);

        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);

        // Assert
        assertNotNull(result);
    }

    @Test
    void analyzeScores_exception() {

        // Arrange
        when(obtenerDiplomaService.analyzeScores(1L)).thenThrow(new StudentNotFoundException(student.getId()));

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(1L));
    }
}