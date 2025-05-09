package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.Subject;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    StudentDTO studentFer;

    @BeforeEach
    void setUp() {
        SubjectDTO s1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO s2 = new SubjectDTO("Lengua", 9.0);
        SubjectDTO s3 = new SubjectDTO("Historia", 10.0);
        StudentDTO studentJuan = new StudentDTO();
        studentJuan.setStudentName("Juan");
        studentJuan.setSubjects(Arrays.asList(s1, s2, s3));
        lenient().when(studentDAO.findById(1L)).thenReturn(studentJuan); //OJO CON ESTO NO DEBERIA CORRERLO EN TEST QUE NO VA A CORRER

        // Estudiante con materias vacías
        studentFer = new StudentDTO();
        studentFer.setStudentName("Fer");



    }

    @Test
    void calculateAverageEmptyStudentsException() {
        when(studentDAO.findById(2L)).thenReturn(studentFer);
        assertThrows(NullPointerException.class, () -> {
            obtenerDiplomaService.analyzeScores(2L);
        });
    }

    @Test
    void calculateAverageCorrectAverage() {
        StudentDTO stu1 = obtenerDiplomaService.analyzeScores(1L);
            assertEquals(9.0, stu1.getAverageScore());
    }

    @Test
    void calculateAverageCorrectMessage() {
        StudentDTO stu1 = obtenerDiplomaService.analyzeScores(1L);
        assertEquals("El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.", stu1.getMessage());
    }

    @Test
    void calculateAverageIncorrectMessage() {
        StudentDTO stu1 = obtenerDiplomaService.analyzeScores(1L);
        assertNotEquals("El alumno Fer ha obtenido un promedio de 9.", stu1.getMessage());
    }

    @Test
    void calculateAverageWrongAverage() {
        StudentDTO stu1 = obtenerDiplomaService.analyzeScores(1L);
        assertNotEquals(9.4, stu1.getAverageScore());
    }




}



/*

 @Test
    void calculateAverageWrongAverageV2() {
        when(studentDAO.findById(2L)).thenReturn(studentFer);
        StudentDTO stu1 = obtenerDiplomaService.analyzeScores(2L);
        assertNotEquals(9.4, stu1.getAverageScore());
    }

    @Test
    void calculateAverageEmptyStudentsException() {
        when(studentDAO.findById(2L)).thenReturn(studentFer);
        assertThrows(NullPointerException.class, () -> {
            obtenerDiplomaService.analyzeScores(2L);
        });
    }

   @Test
    void calculateAverageEmptyStudentsException() {
        when(studentDAO.findById(3L))
                .thenThrow(new IllegalArgumentException("Estudiante no encontrado con ID: 3"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            obtenerDiplomaService.analyzeScores(3L);
        });
        assertEquals("Estudiante no encontrado con ID: 3", exception.getMessage());
    }


@Test
    void calculateAverageEmptySubjectsException() {
        when(studentDAO.findById(2L))
                .thenThrow(new IllegalArgumentException("El estudiante no tiene materias cargadas."));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            obtenerDiplomaService.analyzeScores(2L);
        });
        assertEquals("El estudiante no tiene materias cargadas.", exception.getMessage());
    }

 StudentDTO stu = obtenerDiplomaService.studentDAO.findById(1L);
        System.out.println("Estudiante encontrado: " + stu);

        if (stu != null) {
            System.out.println("Subjects: " + stu.getSubjects());
            for (SubjectDTO sub : stu.getSubjects()) {
                System.out.println("Subject: " + sub + ", Score: " + sub.getScore());
            }
        }


class ObtenerDiplomaServiceTest {

    private IStudentDAO studentDAO;
    private ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    void setUp() {
        studentDAO = mock(IStudentDAO.class);
        obtenerDiplomaService = new ObtenerDiplomaService();
        obtenerDiplomaService.studentDAO = studentDAO;

        // Alumno con materias
        SubjectDTO s1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO s2 = new SubjectDTO("Lengua", 9.0);
        SubjectDTO s3 = new SubjectDTO("Historia", 10.0);

        StudentDTO studentJuan = new StudentDTO();
        studentJuan.setStudentName("Juan");
        studentJuan.setSubjects(Arrays.asList(s1, s2, s3));
        when(studentDAO.findById(1L)).thenReturn(studentJuan);

        // Alumno sin materias
        StudentDTO studentFer = new StudentDTO();
        studentFer.setStudentName("Fer");
        when(studentDAO.findById(2L)).thenReturn(studentFer);

        // ID inexistente
        when(studentDAO.findById(3L)).thenReturn(null);
    }

    @Test
    void testAverageCalculationIsCorrect() {
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertEquals(9.0, result.getAverageScore());
    }

    @Test
    void testMessageWithHighScore() {
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertEquals("El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.", result.getMessage());
    }

    @Test
    void testInvalidStudentIdThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            obtenerDiplomaService.analyzeScores(3L);
        });
        assertEquals("Estudiante no encontrado con ID: 3", ex.getMessage());
    }

    @Test
    void testEmptySubjectsThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            obtenerDiplomaService.analyzeScores(2L);
        });
        assertEquals("El estudiante no tiene materias cargadas.", ex.getMessage());
    }
}


 */