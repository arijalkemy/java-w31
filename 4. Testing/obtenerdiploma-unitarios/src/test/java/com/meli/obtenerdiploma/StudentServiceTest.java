package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @Test
    void testCreateUser() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe", "Excellent", 95.0, null);
        // Act
        studentService.create(studentDTO);
        // Assert
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void testReadUser() {
        // Arrange
        Long studentId = 998L;
        StudentDTO studentDTO = new StudentDTO(studentId, "John Doe", "Excellent", 95.0, null);
        when(studentDAO.findById(studentId)).thenReturn(studentDTO);
        // Act
        StudentDTO result = studentService.read(studentId);
        // Assert
        verify(studentDAO, times(1)).findById(studentId);
        assertEquals(studentDTO, result);
    }

    @Test
    void updateStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(998L, "John Doe", "Excellent", 95.0, null);
        // Act
        studentService.update(studentDTO);
        // Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void deleteStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(998L, "John Doe", "Excellent", 95.0, null);
        // Act
        studentService.delete(studentDTO.getId());
        // Assert
        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    void testReadAllStudents() {
        // Arrange
        Set<StudentDTO> studentSet = Set.of(
                new StudentDTO(1L, "John Doe", "Excellent", 95.0, null),
                new StudentDTO(2L, "Jane Smith", "Good", 85.0, null)
        );
        when(studentRepository.findAll()).thenReturn(studentSet);
        // Act
        Set<StudentDTO> result = studentService.getAll();
        // Assert
        verify(studentRepository, times(1)).findAll();
        assertEquals(studentSet, result);
    }
}
