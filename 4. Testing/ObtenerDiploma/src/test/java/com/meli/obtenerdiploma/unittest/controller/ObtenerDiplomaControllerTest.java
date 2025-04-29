package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService diplomaService;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void analyzeScoresSuccess() {

        //Arrange
        Long id =1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTOExpected = new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",7.333333333333333,subjectDTOList);

        //Act
        when(diplomaService.analyzeScores(id)).thenReturn(new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",7.333333333333333,subjectDTOList));
        StudentDTO studentDTO =controller.analyzeScores(id);

        //Assert
        verify(diplomaService,atLeast(1)).analyzeScores(id);
        assertEquals(studentDTOExpected,studentDTO);

    }

}
