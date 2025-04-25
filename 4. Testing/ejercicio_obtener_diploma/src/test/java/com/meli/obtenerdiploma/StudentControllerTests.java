package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController studentController;

    private StudentDTO studentDTO;

    @BeforeEach
    void setup() {
        studentDTO = new StudentDTO(1L, "Juan", null, null, null);
    }


    @Test
    public void registerUsers() {
        // Arrange
        doNothing().when(service).create(studentDTO);

        // Act
        ResponseEntity<?> response = studentController.registerStudent(studentDTO);

        // Assert
        verify(service).create(studentDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getStudentTest() {
        // Arrange
        Long studentId = 1L;

        // Act
        when(service.read(studentId)).thenReturn(studentDTO);
        StudentDTO obtained = studentController.getStudent(studentId);

        // Assert
        verify(service).read(studentId);
        assertEquals(obtained, studentDTO);
    }

    @Test
    public void updateStudentTest(){
        // Arrange
        doNothing().when(service).update(studentDTO);

        // Act
        ResponseEntity<?> response = studentController.modifyStudent(studentDTO);

        // Assert
        verify(service).update(studentDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteStudentTest() {
        // Arrange
        Long studentId = 1L;
        doNothing().when(service).delete(studentId);

        // Act
        ResponseEntity<?> response = studentController.removeStudent(studentId);

        // Assert
        verify(service).delete(studentId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void listStudentsTest() {
        // Arrange
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        StudentDTO student1 = new StudentDTO(1L, "Juan", null, null, null);
        StudentDTO student2 = new StudentDTO(2L, "Francisco", null, null, null);
        StudentDTO student3 = new StudentDTO(3L, "Rocio", null, null, null);
        studentDTOSet.add(student1);
        studentDTOSet.add(student2);
        studentDTOSet.add(student3);

        // Act
        when(service.getAll()).thenReturn(studentDTOSet);
        Set<StudentDTO> response = studentController.listStudents();

        // Assert
        assertEquals(response, studentDTOSet);
    }
}
