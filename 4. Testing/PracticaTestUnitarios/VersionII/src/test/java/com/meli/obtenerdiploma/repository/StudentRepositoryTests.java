package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
@SpringBootTest(properties = { "api.scope=test" })
class StudentRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    void setUp() {
        try {
            Utils.emptyUsersFile();
        } catch (IOException e) {
            fail("Error al restaurar el archivo de propiedades: " + e.getMessage());
        }
    }

    @Test
    void findAllTest() {
        // Arrange
        Set<StudentDTO> students = Utils.generateStudentsSet();
        students.forEach(s -> studentDAO.save(s));

        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(students.size(), result.size());
        for (StudentDTO student : students) {
            assertTrue(result.stream().anyMatch(s -> s.getId().equals(student.getId())));
        }
    }
}