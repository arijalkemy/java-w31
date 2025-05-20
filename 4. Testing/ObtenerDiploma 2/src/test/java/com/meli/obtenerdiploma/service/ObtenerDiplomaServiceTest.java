package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    public void testAnalyzeScoresHighScore(){
        //Arrange
        Long id = 1L;
        StudentDTO stu = new StudentDTO(1L, "Carlos", "Soy un mock", 0D, Arrays.asList(new SubjectDTO("materia 1", 10D)));
        when(studentDAO.findById(id)).thenReturn(stu);
        //Act
        StudentDTO analyzedStu = service.analyzeScores(id);
        //Assert
        Assertions.assertTrue(
                analyzedStu.getAverageScore().equals(10D) &&
                        analyzedStu.getMessage().equals("El alumno Carlos ha obtenido un promedio de 10. Felicitaciones!")
        );
    }

    @Test
    public void testAnalyzeScoresLowScore(){
        //Arrange
        Long id = 1L;
        StudentDTO stu = new StudentDTO(1L, "Carlos", "Soy un mock", 0D, Arrays.asList(new SubjectDTO("materia 1", 4D)));
        when(studentDAO.findById(id)).thenReturn(stu);
        //Act
        StudentDTO analyzedStu = service.analyzeScores(id);
        //Assert
        Assertions.assertTrue(
                analyzedStu.getAverageScore().equals(4D) &&
                        analyzedStu.getMessage().equals("El alumno Carlos ha obtenido un promedio de 4. Puedes mejorar.")
        );
    }

    @Test
    @Disabled
    public void testAnalyzeScoresNoSubjects(){
        //Arrange
        Long id = 1L;
        StudentDTO stu = new StudentDTO(1L, "Carlos", "Soy un mock", null, new ArrayList<>());
        when(studentDAO.findById(id)).thenReturn(stu);
        //Act
        StudentDTO analyzedStu = service.analyzeScores(id);
        //Assert
        Assertions.assertEquals(0D, analyzedStu.getAverageScore());
    }
}
