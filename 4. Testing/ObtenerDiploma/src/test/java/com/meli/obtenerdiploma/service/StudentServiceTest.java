package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void create() {
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, Collections.emptyList());
        doNothing().when(studentDAO).save(student);

        studentService.create(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void read() {
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, Collections.emptyList());
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = studentService.read(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Juan", result.getStudentName());
        verify(studentDAO, times(1)).findById(1L);
    }

    @Test
    void update() {
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, Collections.emptyList());
        doNothing().when(studentDAO).save(student);

        studentService.update(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void delete() {
        when(studentDAO.delete(1L)).thenReturn(true);

        studentService.delete(1L);

        verify(studentDAO, times(1)).delete(1L);
    }

    @Test
    void getAll() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L, "Juan", null, null, Collections.emptyList()));
        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> result = studentService.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(studentRepository, times(1)).findAll();
    }
}