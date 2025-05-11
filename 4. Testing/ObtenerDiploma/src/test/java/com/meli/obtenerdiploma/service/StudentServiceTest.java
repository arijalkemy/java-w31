package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private StudentDTO student;

    @BeforeEach
    void setUp() {

        // Arrange
        student = new StudentDTO(1L, "Jane Doe", "Lorem ipsum", 9.0, List.of(new SubjectDTO("Maths", 9.0)));
    }

    @Test
    void createStudent() {

        // Act
        studentService.create(student);

        // Assert
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void readStudent() {

        // Arrange
        when(studentDAO.findById(1L)).thenReturn(student);

        // Act
        StudentDTO result = studentService.read(1L);

        // Assert
        assertNotNull(result);
        assertEquals(student.getId(), result.getId());
        assertEquals(student.getStudentName(), result.getStudentName());
    }

    @Test
    void updateStudent() {

        // Act
        studentService.update(student);

        // Assert
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void deleteStudent() {

        // Act
        studentService.delete(1L);

        // Assert
        verify(studentDAO, times(1)).delete(1L);
    }

    @Test
    void getAllStudents() {

        // Arrange
        when(studentRepository.findAll()).thenReturn(Set.of(student));

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }
}