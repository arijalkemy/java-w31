package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO student;

    @BeforeEach
    void setUp() {

        // Arrange
        student = new StudentDTO(1L, "Jane Doe", "Lorem ipsum", 9.0, List.of(new SubjectDTO("Maths", 9.0)));
    }

    @Test
    void analyzeScores_validArgs() {

        // Arrange
        when(studentDAO.findById(1L)).thenReturn(student);

        // Act:
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        assertNotNull(result);
        assertEquals(9.0, result.getAverageScore());
        assertEquals("El alumno Jane Doe ha obtenido un promedio de 9. Puedes mejorar.", result.getMessage());
    }

    @Test
    void analyzeScores_noStudentFound() {

        // Arrange
        when(studentDAO.findById(1L)).thenThrow(new StudentNotFoundException(student.getId()));

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }

}