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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    private SubjectDTO createSubject(String name, Double score) {
        SubjectDTO subject = new SubjectDTO();
        subject.setName(name);
        subject.setScore(score);
        return subject;
    }

    @BeforeEach
    void setUp() {}

    @Test
    public void testObtenerDiplomaAlumno(){
        StudentDTO student = new StudentDTO();
        student.setStudentName("Carlos");
        List<SubjectDTO> highScoreSubjects = Arrays.asList(
                createSubject("Math", 9.5),
                createSubject("Physics", 9.5),
                createSubject("Chemistry", 9.5)
        );
        student.setAverageScore(9.5);
        when(service.analyzeScores(1L)).thenReturn(student);
        controller.analyzeScores(1L);
        verify(service).analyzeScores(1L);
    }

    @Test
    public void testObtenerDiplomaEstudianteNull() {
        assertNull(controller.analyzeScores(999L));
    }

    @Test
    void testAnalyzeScoresNonExistentId() {
        // Given: Service throws StudentNotFoundException for non-existent ID
        when(service.analyzeScores(999L)).thenThrow(new StudentNotFoundException(999L));

        // When/Then
        assertThrows(StudentNotFoundException.class, () -> controller.analyzeScores(999L));

        // Verify service was called with non-existent ID
        verify(service).analyzeScores(999L);
    }



}