package com.meli.obtenerdiploma.service;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void create_callsDaoSave() {
        StudentDTO student = new StudentDTO();
        studentService.create(student);
        verify(studentDAO).save(student);
    }

    @Test
    void update_callsDaoSave() {
        StudentDTO student = new StudentDTO();
        studentService.update(student);
        verify(studentDAO).save(student);
    }

    @Test
    void read_returnsStudentFromDao() {
        StudentDTO student = new StudentDTO();
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = studentService.read(1L);

        assertSame(student, result);
        verify(studentDAO).findById(1L);
    }

    @Test
    void delete_callsDaoDeleteWithId() {
        Long id = 7L;
        studentService.delete(id);
        verify(studentDAO).delete(id);
    }

    @Test
    void getAll_returnsSetFromRepository() {
        Set<StudentDTO> expectedSet = new HashSet<>();
        expectedSet.add(new StudentDTO());
        when(studentRepository.findAll()).thenReturn(expectedSet);

        Set<StudentDTO> result = studentService.getAll();

        assertEquals(expectedSet, result);
        verify(studentRepository).findAll();
    }

    @Test
    void getAll_whenNoStudents_returnsEmptySet() {
        when(studentRepository.findAll()).thenReturn(Collections.emptySet());

        Set<StudentDTO> result = studentService.getAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(studentRepository).findAll();
    }
}