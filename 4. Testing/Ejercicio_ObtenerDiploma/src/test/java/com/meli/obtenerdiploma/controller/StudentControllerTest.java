package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController controller;

    private StudentDTO sampleStudent;

    @BeforeEach
    void setup() {
        sampleStudent = new StudentDTO(1L, "Camilo", "Alumno aplicado", 9.5,
                List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 10.0)));
    }

    @Test
    void testRegisterStudent_shouldCallCreateAndReturnOk() {
        // Act
        ResponseEntity<?> response = controller.registerStudent(sampleStudent);

        // Assert
        verify(studentService).create(sampleStudent);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testGetStudent_shouldReturnStudentDTO() {
        // Arrange
        when(studentService.read(1L)).thenReturn(sampleStudent);
        // Act
        StudentDTO result = controller.getStudent(1L);
        // Assert
        assertEquals(sampleStudent, result);
    }

    @Test
    void testModifyStudent_shouldCallUpdateAndReturnOk() {
        // Act
        ResponseEntity<?> response = controller.modifyStudent(sampleStudent);

        // Assert
        verify(studentService).update(sampleStudent);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testRemoveStudent_shouldCallDeleteAndReturnOk() {
        // Act
        ResponseEntity<?> response = controller.removeStudent(1L);

        // Assert
        verify(studentService).delete(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testListStudents_shouldReturnSetOfStudents() {
        // Arrange
        Set<StudentDTO> expected = new HashSet<>(List.of(sampleStudent));
        when(studentService.getAll()).thenReturn(expected);

        // Act
        Set<StudentDTO> result = controller.listStudents();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testGetStudent_whenNotFound_shouldThrowException() {
        // Arrange
        when(studentService.read(99L)).thenThrow(new StudentNotFoundException(99L));

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> controller.getStudent(99L));
    }
}
