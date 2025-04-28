package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.Utils;

/*
 * EJERCICIO 1: TEST UNITARIOS SIN MOCKS
 * Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de repositorio
 * StudentDAO y StudentRepository. Tener en cuenta múltiples escenarios y “casos borde” de cada comportamiento.
 *  - Casos nulos, vacíos, inválidos.
 *  - Agregar un alumno.
 *  - Buscar un alumno por Id.
 *  - Modificar los datos de un alumno.
 *  - Eliminar un alumno.
 *  - Listar todos los alumnos.
 */
class StudentDAOTests {

    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
        try {
            Utils.emptyUsersFile();
        } catch (IOException e) {
            fail("Error al restaurar el archivo de usuarios: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test StudentDAO: un alumno se guarda correctamente.")
    void shouldSaveStudent() {
        // Arrange
        StudentDTO student = Utils.createStudent();
        Long expectedId = 1L;

        // Act
        studentDAO.save(student);

        // Assert
        assertTrue(studentDAO.exists(student));
        assertEquals(expectedId, student.getId());
        assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    @DisplayName("Test StudentDAO: se intenta guardar un alumno con id existente -> se actualiza el alumno.")
    void shouldUpdateStudent() {
        // Arrange
        StudentDTO initialStudent = Utils.createStudent();
        studentDAO.save(initialStudent);
        StudentDTO duplicatedStudent = new StudentDTO(initialStudent.getId(), "Nombre Modificado", null, null,
                initialStudent.getSubjects());

        // Act
        studentDAO.save(duplicatedStudent);

        // Assert
        assertTrue(studentDAO.exists(duplicatedStudent));
        assertEquals(duplicatedStudent.getId(), initialStudent.getId());
        assertEquals(studentDAO.findById(duplicatedStudent.getId()), duplicatedStudent);
    }

    @Test
    @DisplayName("Test StudentDAO: un alumno se elimina correctamente.")
    void shouldDeleteStudent() {
        // Arrange
        StudentDTO student = Utils.createStudent();
        studentDAO.save(student);
        Long id = student.getId();

        // Act
        Boolean result = studentDAO.delete(student.getId());

        // Assert
        assertTrue(result);
        assertFalse(studentDAO.exists(student));
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    @DisplayName("Test StudentDAO: no se puede eliminar un alumno inexistente.")
    void shouldNotDeleteStudent() {
        // Arrange
        Long invalidId = -1L;

        // Act
        Boolean result = studentDAO.delete(invalidId);

        // Assert
        assertFalse(result);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(invalidId));
    }

    @Test
    @DisplayName("Test StudentDAO: se comprueba que un alumno existe correctamente.")
    void shouldExistStudent() {
        // Arrange
        StudentDTO student = Utils.createStudent();
        studentDAO.save(student);

        // Act
        Boolean result = studentDAO.exists(student);

        // Assert
        assertTrue(result);
        assertEquals(student.getId(), studentDAO.findById(student.getId()).getId());
    }

    @Test
    @DisplayName("Test StudentDAO: se comprueba que un alumno no existe correctamente.")
    void shouldNotExistStudent() {
        // Arrange
        StudentDTO student = Utils.createStudent();
        Long invalidId = -1L;
        student.setId(invalidId);

        // Act
        Boolean result = studentDAO.exists(student);

        // Assert
        assertFalse(result);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(invalidId));
    }

    @Test
    @DisplayName("Test StudentDAO: se encuentra a un alumno por Id correctamente.")
    void shouldFindStudent() {
        // Arrange
        StudentDTO student = Utils.createStudent();
        studentDAO.save(student);

        // Act
        StudentDTO result = assertDoesNotThrow(() -> studentDAO.findById(student.getId()));

        // Assert
        assertNotNull(result);
        assertEquals(student.getId(), result.getId());
        assertEquals(student.getStudentName(), result.getStudentName());

    }

    @Test
    @DisplayName("Test StudentDAO: no se encuentra a un alumno de Id inexistente.")
    void shouldNotFindStudent() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(-1L));
    }
}
