package com.meli.obtenerdiploma.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {


    @Mock 
    private IStudentDAO iStudentDAO;

    @InjectMocks
    private ObtenerDiplomaService iObtenerDiplomaService;
    
    @Test
    void analyze_Score_Based_On_Student_Id(){

        //Arrange

        StudentDTO stubStudent = new StudentDTO();
        stubStudent.setId(1L);
        stubStudent.setStudentName("Carlos");
        stubStudent.setSubjects(List.of(
            new SubjectDTO("Matemáticas", 9.0),
            new SubjectDTO("Historia",     8.0)
        ));

        //Act

        when(iStudentDAO.findById(1L)).thenReturn(stubStudent);

        StudentDTO result = iObtenerDiplomaService.analyzeScores(1L);

        verify(iStudentDAO, atLeastOnce()).findById(1L);

        //Assert

        assertEquals(8.5, result.getAverageScore(), 0,
                     "The average should be calculated as (9+8)/2 = 8.5");
    
    }
}
