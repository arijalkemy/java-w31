package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void testAnalizeScore_validStudentWithHonors_shouldReturnDiplomaWithCongrats(){
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Miguel");
        List<SubjectDTO> subjectDTOList = new ArrayList<>(List.of(
                new SubjectDTO("Matematicas",10.0),
                new SubjectDTO("Historia",9.5)));

        student.setSubjects(subjectDTOList);

        when(studentDAO.findById(1L)).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(9.75, result.getAverageScore());
        assertTrue(result.getMessage().contains("Felicitaciones"));

    }

    @Test
    void testAnalizeScore_ValidStudent_shouldDiplomaWithImprovementMessage(){
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Miguel");
        List<SubjectDTO> subjectDTOList = new ArrayList<>(List.of(
                new SubjectDTO("Matematicas",6.0),
                new SubjectDTO("Historia",5.5)));

        student.setSubjects(subjectDTOList);

        when(studentDAO.findById(1L)).thenReturn(student);
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        //Assert
        assertEquals(5.75, result.getAverageScore());
        assertTrue(result.getMessage().contains("Puedes mejorar"));
    }

    @Test
    void testAnalizeScrore_notSubject_ShouldThrowException() {
        // Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Pepe");
        student.setSubjects(null);

        when(studentDAO.findById(1L)).thenReturn(student);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }

    @Test
    void testAnalizeScores_studentNotFound_ShouldThrowException(){
        //Arrange
        when(studentDAO.findById(999L)).thenThrow(new RuntimeException("Not Found"));

        //Art & Assert
        assertThrows(RuntimeException.class, ()->obtenerDiplomaService.analyzeScores(999L));

    }

    @Test
    void testAnalizeScores_NullStudentName_ShouldStillWork(){
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName(null);
        student.setSubjects(Arrays.asList(
                new SubjectDTO("Math", 7.0),
                new SubjectDTO("Science", 8.0)
        ));
        when(studentDAO.findById(1L)).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(7.5,result.getAverageScore());
        assertTrue(result.getMessage().contains("El alumno null ha obtenido un promedio"));
    }

}
