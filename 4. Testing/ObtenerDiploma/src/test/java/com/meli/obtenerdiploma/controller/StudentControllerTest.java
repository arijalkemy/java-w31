package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void registerStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(null, "Juan Perez", null, null, null);
        doNothing().when(studentService).create(student);

        // Act
        ResponseEntity<?> response = studentController.registerStudent(student);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(studentService, times(1)).create(student);
    }

    @Test
    void getStudent() {
        // Arrange
        Long studentId = 1L;
        StudentDTO mockStudent = new StudentDTO(studentId, "Juan Perez", null, null, null);
        when(studentService.read(studentId)).thenReturn(mockStudent);

        // Act
        StudentDTO result = studentController.getStudent(studentId);

        // Assert
        assertNotNull(result);
        assertEquals(studentId, result.getId());
        assertEquals("Juan Perez", result.getStudentName());
        verify(studentService, times(1)).read(studentId);
    }

    @Test
    void modifyStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Juan Modificado", null, null, null);
        doNothing().when(studentService).update(student);

        // Act
        ResponseEntity<?> response = studentController.modifyStudent(student);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(studentService, times(1)).update(student);
    }

    @Test
    void removeStudent() {
        // Arrange
        Long studentId = 1L;
        doNothing().when(studentService).delete(studentId);

        // Act
        ResponseEntity<?> response = studentController.removeStudent(studentId);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(studentService, times(1)).delete(studentId);
    }

    @Test
    void listStudents() {
        // Arrange
        Set<StudentDTO> mockStudents = Set.of(
                new StudentDTO(1L, "Juan Perez", null, null, null),
                new StudentDTO(2L, "Maria Lopez", null, null, null)
        );
        when(studentService.getAll()).thenReturn(mockStudents);

        // Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(studentService, times(1)).getAll();
    }
}