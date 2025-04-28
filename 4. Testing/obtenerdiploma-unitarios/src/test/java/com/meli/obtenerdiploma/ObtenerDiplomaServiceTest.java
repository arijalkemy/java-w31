package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @InjectMocks
    private ObtenerDiplomaService service;

    @Mock
    private IStudentDAO studentDAO;

    @Test
    void testCalculateAverageScore() {
        // Arrange (preparar)
        StudentDTO marcos = new StudentDTO(1L, "Marcos", "Excellent", 95.0, null);
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);
        marcos.setSubjects(List.of(subject1, subject2, subject3));

        when(studentDAO.findById(1L)).thenReturn(marcos);

        // Act (actuar)
        StudentDTO result = service.analyzeScores(1L);

        // Assert (aseverar)
        verify(studentDAO, atLeastOnce()).findById(1L);
        assertEquals(6.0, result.getAverageScore());
    }
}
