package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testRegisterStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(3L, "New Student", null, null, null);

        // Act
        studentController.registerStudent(student);

        // Assert
        verify(studentService).create(student);
    }

    @Test
    public void testGetStudent() {
        // Arrange
        Long studentId = 1L;
        StudentDTO mockStudent = new StudentDTO(studentId, "Juan", null, 8.0, null);
        when(studentService.read(studentId)).thenReturn(mockStudent);

        // Act
        StudentDTO result = studentController.getStudent(studentId);

        // Assert
        verify(studentService).read(studentId);
        assertEquals("Juan", result.getStudentName());
    }

    @Test
    public void testModifyStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(3L, "Updated Student", null, null, null);

        // Act
        studentController.modifyStudent(student);

        // Assert
        verify(studentService).update(student);
    }

    @Test
    public void testRemoveStudent() {
        // Arrange
        Long studentId = 1L;

        // Act
        studentController.removeStudent(studentId);

        // Assert
        verify(studentService).delete(studentId);
    }

    @Test
    public void testListStudents() {
        // Arrange
        Set<StudentDTO> mockStudents = new HashSet<>();

        // Adding examples
        mockStudents.add(new StudentDTO(1L, "Juan", null, null, null));
        mockStudents.add(new StudentDTO(2L, "Pedro", null, null, null));

        when(studentService.getAll()).thenReturn(mockStudents);

        // Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        verify(studentService).getAll();
        assertEquals(2, result.size());
    }
}
