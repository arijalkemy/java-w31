package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores_returnCorrectAverageAndMessage_whenAverageBelowOrEqualNine() {
        StudentDTO student = buildStudent("Carlos", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));

        when(studentDAO.findById(anyLong())).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(7.33, Math.round(result.getAverageScore()*100)/100.0);
        assertTrue(result.getMessage().contains("Puedes mejorar"));
        assertTrue(result.getMessage().contains("Carlos"));
    }

    @Test
    void analyzeScores_returnFelicitaciones_whenAverageAboveNine() {
        StudentDTO student = buildStudent("Sofi", List.of(
                new SubjectDTO("Matemática", 9.5),
                new SubjectDTO("Física", 10.0),
                new SubjectDTO("Química", 10.0)
        ));
        when(studentDAO.findById(anyLong())).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(2L);

        assertTrue(result.getAverageScore() > 9);
        assertTrue(result.getMessage().contains("Felicitaciones!"));
        assertTrue(result.getMessage().contains("Sofi"));
    }

    @Test
    void analyzeScores_withSingleSubject_worksAndFormats() {
        StudentDTO student = buildStudent("Paula", List.of(
                new SubjectDTO("Historia", 8.12345)
        ));
        when(studentDAO.findById(anyLong())).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(5L);

        assertEquals(8.12, Math.round(result.getAverageScore()*100)/100.0); // Solo un elemento
        assertTrue(result.getMessage().contains("Paula"));
    }

    @Test
    void analyzeScores_withNullSubjects_throwsNullPointerException() {
        StudentDTO student = buildStudent("Null", null);
        when(studentDAO.findById(anyLong())).thenReturn(student);

        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(99L));
    }

    @Test
    void analyzeScores_withNullStudentName_messageHandled() {
        StudentDTO student = buildStudent(null, List.of(
                new SubjectDTO("Historia", 10.0)
        ));
        when(studentDAO.findById(anyLong())).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(23L);

        assertTrue(result.getMessage().contains("alumno null ha obtenido"));
    }

    @Test
    void analyzeScores_withNullScore_throwsNullPointerException() {
        StudentDTO student = buildStudent("Con nulo", List.of(
                new SubjectDTO("Matemática", null)
        ));
        when(studentDAO.findById(anyLong())).thenReturn(student);

        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(42L));
    }

    @Test
    void analyzeScores_whenStudentNotFound_throwsStudentNotFoundException() {
        when(studentDAO.findById(anyLong())).thenThrow(new StudentNotFoundException(999L));
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(999L));
    }

    private StudentDTO buildStudent(String name, List<SubjectDTO> subjects) {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName(name);
        student.setSubjects(subjects);
        return student;
    }
}