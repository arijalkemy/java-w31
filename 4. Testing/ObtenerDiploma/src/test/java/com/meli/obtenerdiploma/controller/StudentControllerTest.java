package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    StudentDTO student;

    @BeforeEach
    void setUp() {

        // Arrange
        student = new StudentDTO(1L, "Jane Doe", "Lorem ipsum", 8.5, List.of(new SubjectDTO("Math", 9.0)));
    }

    @Test
    void registerStudent_ok() {

        // Act
        ResponseEntity<?> result = studentController.registerStudent(student);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void getStudent_ok() {

        // Arrange
        when(studentService.read(1L)).thenReturn(student);

        // Act
        StudentDTO result = studentController.getStudent(1L);

        // Assert
        assertNotNull(result);
        assertEquals(student.getId(), result.getId());
    }

    @Test
    void modifyStudent_ok() {

        // Act
        ResponseEntity<?> result = studentController.modifyStudent(student);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void removeStudent_ok() {

        // Act
        ResponseEntity<?> result = studentController.removeStudent(1L);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void listStudents_ok() {

        // Arrange
        when(studentService.getAll()).thenReturn(Set.of(student));

        // Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        assertNotNull(result);
        assertTrue(result.contains(student));
    }}