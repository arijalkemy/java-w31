package com.meli.obtenerdiploma.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.Utils;

/*
 * EJERCICIO 3 - TESTS UNITARIOS CON MOCKS
 * Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de
 * servicios StudentService, mockeando sus dependencia con los repositorios.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        try {
            Utils.emptyUsersFile();
        } catch (IOException e) {
            fail("Error al restaurar el archivo de usuarios: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: estudiante válido -> crea estudiante")
    void createTest() {
        // Arrange
        StudentDTO student = Utils.createStudent();

        // Act
        studentService.create(student);

        // Assert
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: id existente -> encuentra estudiante")
    void readTest() {
        // Arrange
        StudentDTO student = Utils.createStudent();
        Mockito.when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = studentService.read(student.getId());

        // Assert
        verify(studentDAO, atLeast(1)).findById(student.getId());
        assertNotNull(result);
        assertEquals(student, result);
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: estudiante válido -> actualizar estudiante")
    void updateTest() {
        // Arrage
        StudentDTO student = Utils.createStudent();
        studentService.create(student);
        StudentDTO updatedStudent = Utils.createStudent();
        updatedStudent.setStudentName("Updated student");

        // Act
        studentService.update(updatedStudent);

        // Assert
        verify(studentDAO, atLeast(1)).save(updatedStudent);
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: id válida -> eliminar estudiante")
    void deleteTest() {
        // Arrange
        StudentDTO student = Utils.createStudent();
        studentService.create(student);

        // Act
        studentService.delete(student.getId());

        // Assert
        verify(studentDAO, atLeast(1)).delete(student.getId());
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: hay estudiantes -> devuelve lista de estudiantes")
    void getAllTest() {
        // Arrange
        Set<StudentDTO> students = Utils.generateStudentsSet();
        students.forEach(s -> studentService.create(s));
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        verify(studentRepository, atLeast(1)).findAll();
        assertEquals(students.size(), result.size());
        for (StudentDTO student : students) {
            assertTrue(result.contains(student));
        }
    }
}
