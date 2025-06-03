package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testCreateStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(3L, "New Student", null, null, null);

        // Act
        studentService.create(student);

        // Assert
        verify(studentDAO, times(1)).save(student);
    }
    @Test
    void testReadStudent() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Javier", null, null, null);
        when(studentDAO.findById(studentId)).thenReturn(student);

        // Act
        StudentDTO result = studentService.read(studentId);

        // Assert
        assertNotNull(result);
        assertEquals("Javier", result.getStudentName());
    }

    @Test
    void testUpdateStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Otro Nombre", null, null, null);

        // Act
        studentService.update(student);

        // Assert
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void testDeleteStudent() {
        // Arrange
        Long studentId = 1L;

        // Act
        studentService.delete(studentId);

        // Assert
        verify(studentDAO, times(1)).delete(studentId);
    }

    @Test
    void testGetAllStudents() {
        // Arrange
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L, "Alberto", null, null, null));
        students.add(new StudentDTO(2L, "Daniela", null, null, null));
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void testReadNonExistentStudent() {
        // Arrange
        Long studentId = 99L;
        when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentService.read(studentId));
    }

    @Test
    void testGetAllStudents_EmptyRepository() {
        // Arrange
        when(studentRepository.findAll()).thenReturn(Collections.emptySet());

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        assertTrue(result.isEmpty(), "El resultado debería ser una colección vacía");
    }
}
