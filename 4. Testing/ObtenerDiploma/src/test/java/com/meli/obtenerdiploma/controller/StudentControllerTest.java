package com.meli.obtenerdiploma.controller;

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
import com.meli.obtenerdiploma.service.IStudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private StudentDTO studentDTO;
    private Set<StudentDTO> studentDTOSet;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO(1L, "John Doe", "", null, null);
        studentDTOSet = Set.of(studentDTO);
    }

    @Test
    void testGetStudent() {
        // Arrange
        Long id = studentDTO.getId();
        when(studentService.read(id)).thenReturn(studentDTO);

        // Act
        StudentDTO result = studentController.getStudent(id);

        // Assert
        verify(studentService, atLeast(1)).read(id);
        assertEquals(studentDTO, result);
    }

    @Test
    void testListStudents() {
        // Act
        when(studentService.getAll()).thenReturn(studentDTOSet);

        // Arrange
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        verify(studentService, atLeast(1)).getAll();
        assertEquals(studentDTOSet, result);
    }

    @Test
    void testModifyStudent() {
        // Arrange
        doNothing().when(studentService).update(studentDTO);

        // Act
        studentController.modifyStudent(studentDTO);

        // Assert
        verify(studentService, atLeast(1)).update(studentDTO);
    }

    @Test
    void testRegisterStudent() {
        // Arrange
        doNothing().when(studentService).create(studentDTO);

        // Act
        studentController.registerStudent(studentDTO);

        // Assert
        verify(studentService, atLeast(1)).create(studentDTO);
    }

    @Test
    void testRemoveStudent() {
        // Arrange
        Long id = studentDTO.getId();
        doNothing().when(studentService).delete(id);

        // Act
        studentController.removeStudent(id);

        // Assert
        verify(studentService, atLeast(1)).delete(id);
    }
}
