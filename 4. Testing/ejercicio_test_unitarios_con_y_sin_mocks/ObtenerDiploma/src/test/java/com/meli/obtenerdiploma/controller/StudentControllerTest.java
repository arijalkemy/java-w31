package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController controller;

    @Test
    void registerStudent_callsService_createAndReturnsOk() {
        StudentDTO student = new StudentDTO();
        ResponseEntity<?> response = controller.registerStudent(student);
        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(studentService).create(student);
    }

    @Test
    void getStudent_returnsStudentFromService() {
        StudentDTO stub = new StudentDTO();
        stub.setId(1L);
        when(studentService.read(1L)).thenReturn(stub);
        StudentDTO result = controller.getStudent(1L);
        assertSame(stub, result);
        verify(studentService).read(1L);
    }

    @Test
    void modifyStudent_callsService_updateAndReturnsOk() {
        StudentDTO student = new StudentDTO();
        ResponseEntity<?> response = controller.modifyStudent(student);
        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(studentService).update(student);
    }

    @Test
    void removeStudent_callsService_deleteAndReturnsOk() {
        ResponseEntity<?> response = controller.removeStudent(123L);
        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(studentService).delete(123L);
    }

    @Test
    void listStudents_returnsSetFromService() {
        Set<StudentDTO> stub = new HashSet<>();
        stub.add(new StudentDTO());
        when(studentService.getAll()).thenReturn(stub);

        Set<StudentDTO> result = controller.listStudents();

        assertEquals(stub, result);
        verify(studentService).getAll();
    }

    @Test
    void listStudents_whenNoStudents_returnsEmptySet() {
        when(studentService.getAll()).thenReturn(Collections.emptySet());

        Set<StudentDTO> result = controller.listStudents();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(studentService).getAll();
    }

    @Test
    void getStudent_whenNotFound_throwsStudentNotFoundException() {
        when(studentService.read(555L)).thenThrow(new StudentNotFoundException(555L));
        assertThrows(StudentNotFoundException.class, () -> controller.getStudent(555L));
        verify(studentService).read(555L);
    }
}