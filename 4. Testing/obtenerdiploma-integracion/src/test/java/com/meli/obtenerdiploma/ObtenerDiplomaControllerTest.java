package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @Test
    void obtenerDiploma() {
        // Arrange
        StudentDTO marcos = new StudentDTO(1L, "Marcos", "Excellent", 95.0, null);
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);
        marcos.setSubjects(List.of(subject1, subject2, subject3));
        // Act
        obtenerDiplomaController.analyzeScores(marcos.getId());
        // Assert
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(marcos.getId());
    }
}
