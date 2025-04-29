package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    void testRegisterStudent(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(101L);
        studentDTO.setStudentName("Oliver");

        //Act
        ResponseEntity<?> resultado = controller.registerStudent(studentDTO);

        //Assert
        assertEquals(HttpStatus.OK,resultado.getStatusCode());
        verify(service,times(1)).create(studentDTO);
    }

    @Test
    void testGetStudent(){
        //Arrange
        StudentDTO a = new StudentDTO();
        a.setId(500L);
        a.setStudentName("j");
        when(service.read(500L)).thenReturn(a);
        //Act
        StudentDTO resultado = controller.getStudent(500L);

        //Assert
        assertEquals("j",resultado.getStudentName());
        verify(service,times(1)).read(500L);
    }

    @Test
    void testModiifyStudent(){
        StudentDTO a = new StudentDTO();
        a.setStudentName("k");
        a.setAverageScore(8.9);

        ResponseEntity<?> result = controller.modifyStudent(a);

        verify(service,times(1)).update(a);
        assertEquals(HttpStatus.OK,result.getStatusCode());
    }

    @Test
    void testRemoveStudent(){
        StudentDTO a = new StudentDTO();
        a.setId(5L);
        a.setStudentName("R");

        service.create(a);

        ResponseEntity<?> r = controller.removeStudent(5L);

        assertEquals(HttpStatus.OK,r.getStatusCode());
        verify(service,times(1)).delete(5L);
        assertNull(controller.getStudent(5L));
    }
    
    @Test
    void testListStudents(){
        StudentDTO a = new StudentDTO();
        a.setId(301L);
        StudentDTO b = new StudentDTO();
        b.setId(302L);

        Set<StudentDTO> c = new HashSet<>();
        c.add(a);
        c.add(b);

        when(service.getAll()).thenReturn(c);

        Set <StudentDTO> r = controller.listStudents();

        verify(service,times(1)).getAll();
        assertEquals(2,r.size());
        assertTrue(r.contains(a));
        assertTrue(r.contains(b));
    }
}
