package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService service;

    @InjectMocks
    private StudentController controller;

    @Test
    public void testRegisterStudent() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Jorge", "Suspenso", 34D, new ArrayList<>());
        //Act
        ResponseEntity<?> response = controller.registerStudent(studentDTO);
        //Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testModifyStudent() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Jorge", "Suspenso", 34D, new ArrayList<>());
        //Act
        ResponseEntity<?> response = controller.modifyStudent(studentDTO);
        //Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testRemoveStudent() {
        //Arrange
        Long id = 1L;
        //Act
        ResponseEntity<?> response = controller.removeStudent(id);
        //Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetStudent() {
        //Arrange
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO(1L, "Jorge", "Suspenso", 34D, new ArrayList<>());
        when(service.read(id)).thenReturn(studentDTO);
        //Act
        StudentDTO response = controller.getStudent(id);
        //Assert
        Assertions.assertEquals(studentDTO, response);
    }

    @Test
    public void testListStudents() {
        //Arrange
        List<StudentDTO> students = Arrays.asList(
                new StudentDTO(1L, "Jorge", "Suspenso", 34D, new ArrayList<>()),
                new StudentDTO(2L, "Carla", "Aprobada", 74D, new ArrayList<>())
        );
        Set<StudentDTO> studentsSet = new HashSet<>(students);
        when(service.getAll()).thenReturn(studentsSet);
        //Act
        Set<StudentDTO> response = controller.listStudents();
        //Assert
        Assertions.assertEquals(studentsSet, response);
    }
}
