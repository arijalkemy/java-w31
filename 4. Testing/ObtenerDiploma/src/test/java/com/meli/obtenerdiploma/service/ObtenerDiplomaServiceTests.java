package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    private static final String STUDENT_NAME = "Marco";
    private static final double AVERAGE_SCORE = 6.0;


    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    void shouldCalculateAverageScoreCorrectly() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects(STUDENT_NAME);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        service.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(AVERAGE_SCORE, student.getAverageScore(), "The average score should be calculated correctly.");
    }

    @Test
    void shouldWriteMessageForHighAverageScore() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9(STUDENT_NAME);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        service.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 9,00. Felicitaciones!", student.getMessage(),
                "The message for a high average score should be correct.");
    }

    @Test
    void shouldWriteMessageForLowAverageScore() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects(STUDENT_NAME);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        service.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 6,00. Puedes mejorar.", student.getMessage(),
                "The message for a low average score should be correct.");
    }

    @Test
    void shouldMatchRequestAndResponseStudentName() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects(STUDENT_NAME);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        service.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(STUDENT_NAME, student.getStudentName(), "The student name in the response should match the request.");
    }

    @Test
    void shouldMatchRequestAndResponseSubjectList() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects(STUDENT_NAME);
        List<SubjectDTO> initialList = new ArrayList<>();
        student.getSubjects().forEach(subject -> initialList.add(SerializationUtils.clone(subject)));

        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        service.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertTrue(CollectionUtils.isEqualCollection(initialList, student.getSubjects()),
                "The subject list in the response should match the request.");
    }
}