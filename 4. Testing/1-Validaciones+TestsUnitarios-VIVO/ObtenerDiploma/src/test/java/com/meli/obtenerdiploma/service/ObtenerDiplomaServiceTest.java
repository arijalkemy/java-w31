package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    
    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores_calculateAverage_TestAValidStudent(){
        StudentDTO student1 = new StudentDTO();
        
        student1.setId(35L);
        student1.setStudentName("Juan Pérez");
        student1.setMessage("Buen desempeño durante el semestre.");
        student1.setAverageScore(8.7);
        student1.setSubjects(List.of(
            new SubjectDTO("Matemáticas", 9.0),
            new SubjectDTO("Lengua", 8.5)
        ));
        
        when(studentDAO.findById(35L)).thenReturn(student1);
        assertEquals(
            obtenerDiplomaService.analyzeScores(student1.getId()).getAverageScore(),
            (9.0+8.5)/2
        );

    }

    // Leyenda del Diploma.
    @Test
    void analyzeScores_getMessageOfAnalyzeScore_getASuccessMessage(){
        StudentDTO student1 = new StudentDTO();
        
        student1.setId(35L);
        String studentName1 = "Juan Perez";
        student1.setStudentName(studentName1);
        student1.setMessage("Buen desempeño durante el semestre.");
        student1.setAverageScore(8.7);
        student1.setSubjects(List.of(
            new SubjectDTO("Matemáticas", 9.0),
            new SubjectDTO("Lengua", 9.0)
        ));

        StudentDTO student2 = new StudentDTO();

        student2.setId(36L);
        String studentName2 = "Juan Perez";
        student2.setStudentName(studentName2);
        student2.setMessage("Buen desempeño durante el semestre.");
        student2.setAverageScore(8.7);
        student2.setSubjects(List.of(
            new SubjectDTO("Matemáticas", 10.0),
            new SubjectDTO("Lengua", 9.0)
        ));
        
        when(studentDAO.findById(35L)).thenReturn(student1);
        when(studentDAO.findById(36L)).thenReturn(student2);
        
        System.out.println("---------------");
        System.out.println(obtenerDiplomaService.analyzeScores(student1.getId()).getMessage());
        System.out.println("---------------");

        assertEquals(
            obtenerDiplomaService.analyzeScores(student1.getId()).getMessage(),
            "El alumno " + studentName1 + " ha obtenido un promedio de 9. Puedes mejorar."
        );

    }


}
