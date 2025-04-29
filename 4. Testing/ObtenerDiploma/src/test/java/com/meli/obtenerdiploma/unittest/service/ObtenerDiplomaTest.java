package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresSuccess() {

        //Arrange
        Long id =1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTO = new StudentDTO(1L,"Juan",null,null,subjectDTOList);
        StudentDTO studentDTOExpected = new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",7.333333333333333,subjectDTOList);

        //Act
        when(studentDAO.findById(id)).thenReturn(studentDTO);
        studentDTO=obtenerDiplomaService.analyzeScores(id);

        //Assert
        verify(studentDAO,atLeast(1)).findById(id);
        assertEquals(studentDTOExpected,studentDTO);

    }

    @Test
    public void analyzeScoresSuccessHonor() {

        //Arrange
        Long id =1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",9.0));
        subjectDTOList.add(new SubjectDTO("Química",9.6));
        StudentDTO studentDTO = new StudentDTO(1L,"Juan",null,null,subjectDTOList);
        StudentDTO studentDTOExpected = new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 9,2. Felicitaciones!",9.200000000000001,subjectDTOList);

        //Act
        when(studentDAO.findById(id)).thenReturn(studentDTO);
        studentDTO=obtenerDiplomaService.analyzeScores(id);

        //Assert
        verify(studentDAO,atLeast(1)).findById(id);
        assertEquals(studentDTOExpected,studentDTO);

    }


}
