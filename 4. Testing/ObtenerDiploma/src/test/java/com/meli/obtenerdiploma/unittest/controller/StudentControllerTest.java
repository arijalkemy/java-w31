package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void registerStudentSuccess() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        StudentDTO studentDTO = new StudentDTO(2L,"Juan",null,null,subjectDTOList);

        //Act
        studentController.registerStudent(studentDTO);

        //Arrange
        verify(studentService,atLeast(1)).create(studentDTO);

    }
    @Test
    void getStudentSuccess() {

        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTOExpected = new StudentDTO(1L,"Juan",null,null,subjectDTOList);
        long id=1;

        //Act
        when(studentService.read(id)).thenReturn(studentDTOExpected);
        StudentDTO studentDTO=studentController.getStudent(id);

        //Assert
        verify(studentService,atLeast(1)).read(id);
        assertEquals(studentDTOExpected,studentDTO);

    }

    @Test
    void modifyStudentSuccess() {

        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTO = new StudentDTO(2L,"Juan",null,null,subjectDTOList);

        //Act

        ResponseEntity<?> response= studentController.modifyStudent(studentDTO);

        //Assert
        verify(studentService,atLeast(1)).update(studentDTO);
        assertEquals(ResponseEntity.ok(null),response);
    }

    @Test
    void removeStudentSuccess() {

        //Arrange
        long id=1L;

        //Act
        studentController.removeStudent(id);

        //Assert
        verify(studentService,atLeast(1)).delete(id);
    }

    @Test
    void listStudentsSuccess() {

        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        Set<StudentDTO> studentDTOSetExpected = new HashSet<>(List.of(new StudentDTO(1L, "Juan", null, null, subjectDTOList)));
        //Act
        when(studentService.getAll()).thenReturn(studentDTOSetExpected);
        Set<StudentDTO> studentDTOSet=studentController.listStudents();

        //Assert
        verify(studentService,atLeast(1)).getAll();
        assertEquals(studentDTOSetExpected,studentDTOSet);
    }


}
