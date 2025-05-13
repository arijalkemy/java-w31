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

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void getDiploma(){
        //param
        Long studentId = 2L;
        StudentDTO student = new StudentDTO();
        student.setId(studentId);
        student.setStudentName("Pedro");
        student.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));
        obtenerDiplomaController.analyzeScores(student.getId());

        // assert
        //chequeo si se llama al metodo realmente
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(student.getId());

    }
}
