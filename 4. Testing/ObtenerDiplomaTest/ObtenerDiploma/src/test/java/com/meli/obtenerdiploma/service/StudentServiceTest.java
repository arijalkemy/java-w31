package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO student;

    //crear alumno para usar en todos los test
    @BeforeEach
    void setUp() {
        student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Jose");
    }

    // test1 : crear alumno
    @Test
    void shouldCreateStudentSuccessfully() {
        // act
        studentService.create(student);
        // assert
        verify(studentDAO, times(1)).save(student);
    }

    // test 2: leer alumno por ID
    @Test
    void shouldReadStudentById() {
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = studentService.read(1L);

        verify(studentDAO).findById(1L);
        assertThat(result).isEqualTo(student);
    }

    // test 3: actualizar alumno
    @Test
    void shouldUpdateStudentSuccessfully() {
        student.setStudentName("Jose Modificado");
        studentService.update(student);
        verify(studentDAO).save(student);
    }

    // test 4: eliminar alumno
    @Test
    void shouldDeleteStudentById() {
        studentService.delete(1L);
        verify(studentDAO).delete(1L);
    }

    // test 5: listar todos los alumnos
    @Test
    void shouldReturnAllStudents() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(student);
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> result = studentService.getAll();
        verify(studentRepository).findAll();
        assertThat(result).hasSize(1).contains(student);
    }
}

