package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    private static final Long STUDENT_ID = 1L;

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    public void analyzeScores_ShouldCallServiceAnalyzeScores() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.analyzeScores(STUDENT_ID)).thenReturn(student);

        // act
        StudentDTO result = controller.analyzeScores(STUDENT_ID);

        // assert
        verify(service, times(1)).analyzeScores(STUDENT_ID);
        assertEquals(student, result, "The returned student should match the expected student.");
    }
}