package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    private SubjectDTO createSubject(String name, Double score) {
        SubjectDTO subject = new SubjectDTO();
        subject.setName(name);
        subject.setScore(score);
        return subject;
    }

    @Test
    void testAnalyzeScoreWithNullStudent() {
        Long studentId = null;
        assertThrows(NullPointerException.class, () -> service.analyzeScores(studentId));
    }

    @Test
    void testCalculateAverageScores() {
        StudentDTO studentWithHighScores = new StudentDTO();
        studentWithHighScores.setId(3L);
        studentWithHighScores.setStudentName("Honor Student");
        List<SubjectDTO> highScoreSubjects = Arrays.asList(
                createSubject("Math", 9.5),
                createSubject("Physics", 9.8),
                createSubject("Chemistry", 9.7)
        );
        studentWithHighScores.setSubjects(highScoreSubjects);

        when(studentDAO.findById(3L)).thenReturn(studentWithHighScores);
        StudentDTO result = service.analyzeScores(3L);
        assertEquals(9.67, result.getAverageScore(), 0.01);
        verify(studentDAO).findById(3L);
    }

    @Test
    void testStudentWithNoSubjects() {
        StudentDTO studentWithNullSubjects = new StudentDTO();
        studentWithNullSubjects.setId(4L);
        studentWithNullSubjects.setStudentName("No Subjects");

        when(studentDAO.findById(4L)).thenReturn(studentWithNullSubjects);
        assertThrows(NullPointerException.class, () -> service.analyzeScores(4L));
    }

    @Test
    void testMensajeDiplomas() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Carlos");
        List<SubjectDTO> highScoreSubjects = Arrays.asList(
                createSubject("Math", 9.5),
                createSubject("Physics", 9.5),
                createSubject("Chemistry", 9.5)
        );

        student.setSubjects(highScoreSubjects);
        when(studentDAO.findById(2L)).thenReturn(student);
        String expectedMessage = "El alumno Carlos ha obtenido un promedio de 9.5. Felicitaciones!";
        String resultMessage = service.analyzeScores(2L).getMessage();
        assertEquals(expectedMessage, resultMessage);
    }

    @Test
    void testAllMensajesDiplomas() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Carlos");
        List<SubjectDTO> highScoreSubjects = Arrays.asList(
                createSubject("Math", 9.5),
                createSubject("Physics", 9.5),
                createSubject("Chemistry", 9.5)
        );

        student.setSubjects(highScoreSubjects);
        when(studentDAO.findById(2L)).thenReturn(student);
        String expectedMessage = "El alumno Carlos ha obtenido un promedio de 9.5. Felicitaciones!";
        String resultMessage = service.analyzeScores(2L).getMessage();
        assertEquals(expectedMessage, resultMessage);

        student.setStudentName("Juan");
        student.setSubjects(Arrays.asList(
                createSubject("Math", 5.0),
                createSubject("Physics", 6.0),
                createSubject("Chemistry", 7.0)
        ));

        when(studentDAO.findById(3L)).thenReturn(student);
        String expectedMessage2 = "El alumno Juan ha obtenido un promedio de 6. Puedes mejorar.";
        String resultMessage2 = service.analyzeScores(3L).getMessage();
        assertEquals(expectedMessage2, resultMessage2);

        student.setStudentName("Pedro");
        student.setSubjects(Arrays.asList(
                createSubject("Math", 10.0),
                createSubject("Physics", 9.0),
                createSubject("Chemistry", 8.0)
        ));

        when(studentDAO.findById(4L)).thenReturn(student);
        String expectedMessage3 = "El alumno Pedro ha obtenido un promedio de 9. Puedes mejorar.";
        String resultMessage3 = service.analyzeScores(4L).getMessage();
        assertEquals(expectedMessage3, resultMessage3);
    }
}