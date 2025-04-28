package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    //crear mock en la interfaz - mockear dependencia del DAO
    @Mock
    private IStudentService service;
    //inyectar mock en el service
    @InjectMocks
    private StudentController controller;

    // Test 1: Registrar alumno
    @Test
    void testRegisterStudent() {
        StudentDTO student = new StudentDTO();
        controller.registerStudent(student);

        verify(service).create(student);
    }

    // Test 2: Obtener alumno por ID
    @Test
    void testGetStudentById() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        when(service.read(1L)).thenReturn(student);
        StudentDTO result = controller.getStudent(1L);
        verify(service).read(1L);
        assertThat(result).isEqualTo(student);
    }

    // Test 3: Modificar alumno
    @Test
    void testModifyStudent() {
        StudentDTO student = new StudentDTO();
        controller.modifyStudent(student);
        verify(service).update(student);
    }

    // Test 4: Eliminar alumno
    @Test
    void testRemoveStudent() {
        controller.removeStudent(1L);
        verify(service).delete(1L);
    }

    // Test 5: Listar alumnos
    @Test
    void testListAllStudents() {
        Set<StudentDTO> students = new HashSet<>();
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        students.add(student);
        when(service.getAll()).thenReturn(students);
        Set<StudentDTO> result = controller.listStudents();
        verify(service).getAll();
        assertThat(result).hasSize(1).contains(student);
    }

    // Caso borde: getStudent devuelve null
    @Test
    void testReturnNullWhenStudentNotFound() {
        when(service.read(99L)).thenReturn(null);
        StudentDTO result = controller.getStudent(99L);
        verify(service).read(99L);
        assertThat(result).isNull();
    }

    // Caso borde: listar sin alumnos
    @Test
    void testReturnEmptyListWhenNoStudents() {
        when(service.getAll()).thenReturn(new HashSet<>());
        Set<StudentDTO> result = controller.listStudents();
        verify(service).getAll();
        assertThat(result).isEmpty();
    }
}
