package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.Utils;

/*
 * EJERCICIO 5: TEST UNITARIOS CON MOCKS
 * Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa
 * de controlador StudentController, mockeando su dependencia con el servicio.
 */

@SpringBootTest
class StudentControllerTests {
    @Mock
    private IStudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        try {
            Utils.emptyUsersFile();
        } catch (IOException e) {
            fail("Error al restaurar el archivo de usuarios: " + e.getMessage());
        }
    }

    @Test
    void registerStudentTest() {
        // Arrange
        StudentDTO student = Utils.createStudent();

        // Act
        studentController.registerStudent(student);

        // Assert
        verify(studentService, atLeast(1)).create(student);
    }

    @Test
    void getStudentTest() {
        // Arrange
        StudentDTO student = Utils.createStudent();
        Mockito.when(studentService.read(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = studentController.getStudent(student.getId());

        // Assert
        verify(studentService, atLeast(1)).read(student.getId());
        assertEquals(student.getId(), result.getId());
        assertEquals(student.getStudentName(), result.getStudentName());
    }

    @Test
    void modifyStudentTest() {
        // Arrange
        StudentDTO student = Utils.createStudent();

        // Act
        studentController.modifyStudent(student);

        // Assert
        verify(studentService, atLeast(1)).update(student);
    }

    @Test
    void removeStudentTest() {
        // Arrange
        StudentDTO student = Utils.createStudent();

        // Act
        studentController.removeStudent(student.getId());

        // Assert
        verify(studentService, atLeast(1)).delete(student.getId());

    }

    @Test
    void listStudentTest() {
        // Arrange
        Set<StudentDTO> students = Utils.generateStudentsSet();
        when(studentService.getAll()).thenReturn(students);

        // Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        assertEquals(students.size(), result.size());
        for (StudentDTO student : students) {
            assertTrue(result.contains(student));
        }

    }
}
