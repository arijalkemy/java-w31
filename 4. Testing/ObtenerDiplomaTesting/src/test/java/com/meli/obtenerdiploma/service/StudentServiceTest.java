package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO testStudent;

    @BeforeEach
    void setUp() {
        testStudent = new StudentDTO();
        testStudent.setId(1L);
        testStudent.setStudentName("Test Student");
    }

    @Test
    void testCreate() {
        studentService.create(testStudent);
        verify(studentDAO).save(testStudent);
        assertEquals(1L, testStudent.getId());
    }

    @Test
    void testReadValidStudent() {
        when(studentDAO.findById(1L)).thenReturn(testStudent);
        StudentDTO result = studentService.read(1L);
        assertEquals(testStudent, result);
    }

    @Test
    void testReadNonExistingStudent() {
        when(studentDAO.findById(999L)).thenThrow(new StudentNotFoundException(999L));
        assertThrows(StudentNotFoundException.class, () -> studentService.read(999L));
    }

    @Test
    void testUpdateExistingStudent() {
        testStudent.setStudentName("Updated Name");
        studentService.update(testStudent);
        verify(studentDAO).save(testStudent);
        assertEquals("Updated Name", testStudent.getStudentName());
    }

    @Test
    void testUpdateNonExistingStudent() {
        testStudent.setId(999L);
        studentService.update(testStudent);

        verify(studentDAO).save(testStudent);
        assertEquals(999L, testStudent.getId());
    }

    @Test
    void testDeleteExistingStudent() {
        when(studentDAO.delete(1L)).thenReturn(true);
        studentService.delete(1L);
        verify(studentDAO).delete(1L);
    }

    @Test
    void testDeleteNonExistingStudent() {
        when(studentDAO.delete(999L)).thenReturn(false);
        studentService.delete(999L);
        verify(studentDAO).delete(999L);
    }
}