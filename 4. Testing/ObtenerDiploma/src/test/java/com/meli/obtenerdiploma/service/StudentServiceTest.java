package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO studentDTO;
    private Set<StudentDTO> studentDTOSet;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO(1L, "John Doe", "", null, null);
        studentDTOSet = Set.of(studentDTO);
    }

    @Test
    void testCreate() {
        // Arrange
        doNothing().when(studentDAO).save(studentDTO);

        // Act
        studentService.create(studentDTO);

        // Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    void testDelete() {
        // Arrange
        when(studentDAO.delete(1L)).thenReturn(true);

        // Act
        studentService.delete(studentDTO.getId());
        // Assert
        verify(studentDAO, atLeast(1)).delete(studentDTO.getId());
    }

    @Test
    void testGetAll() {
        // Arrange
        Set<StudentDTO> expectedStudents = studentDTOSet;
        when(studentRepository.findAll()).thenReturn(studentDTOSet);

        // Act
        Set<StudentDTO> actualStudents = studentService.getAll();

        // Assert
        verify(studentRepository, atLeast(1)).findAll();
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    void testRead() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudent = studentDTO;
        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        // Act
        StudentDTO actualStudent = studentService.read(studentId);

        // Assert
        verify(studentDAO, atLeast(1)).findById(studentId);
        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    void testUpdate() {
        // Arrange
        studentDTO.setStudentName("Jane Doe");
        doNothing().when(studentDAO).save(studentDTO);

        // Act
        studentService.update(studentDTO);

        // Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }
}
