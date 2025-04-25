package com.meli.obtenerdiploma;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;

import java.nio.file.Path;
import java.nio.file.Paths;

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

@SpringBootTest
class StudentRepositoryTests {

    private StudentRepository studentRepository;
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() throws IOException {
        studentRepository = new StudentRepository();
        studentDAO = new StudentDAO();

        ReflectionTestUtils.setField(studentRepository, "SCOPE", "test");
        ReflectionTestUtils.setField(studentDAO, "SCOPE", "test");

        Path resourcesDir = Paths.get("src", "test", "resources");
        Files.createDirectories(resourcesDir);
        Path jsonFile = resourcesDir.resolve("users.json");
        if (!Files.exists(jsonFile)) {
            String jsonContent = "[\n" +
                    "  {\n" +
                    "    \"id\": 1,\n" +
                    "    \"studentName\": \"Sample Student\",\n" +
                    "    \"subjects\": [],\n" +
                    "    \"averageScore\": null,\n" +
                    "    \"message\": null\n" +
                    "  }\n" +
                    "]";
            Files.writeString(jsonFile, jsonContent);
        }
    }

    @Test
    @DisplayName("Test StudentRepository: los alumnos se cargan correctamente.")
    void findAllTest() {
        Set<StudentDTO> result = studentRepository.findAll();
        assertNotNull(result);
        assertTrue(!result.isEmpty());
    }

    @Test
    @DisplayName("Test StudentRepository: no se puede cargar archivo inexistente.")
    void findAllTestSadPathI() {
        Path jsonFile = Paths.get("src", "test", "resources", "users.json");
        try {
            Files.deleteIfExists(jsonFile);
        } catch (IOException e) {
            fail("No se pudo eliminar el archivo de prueba: " + e.getMessage());
        }

        Set<StudentDTO> result = studentRepository.findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test StudentRepository: no se puede cargar archivo inválido.")
    void findAllTestSadPathII() {
        Path jsonFile = Paths.get("src", "test", "resources", "users.json");
        try {
            Files.writeString(jsonFile, "Contenido inválido");
        } catch (IOException e) {
            fail("No se pudo escribir contenido inválido en el archivo de prueba: " + e.getMessage());
        }
        Set<StudentDTO> result = studentRepository.findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test StudentDAO: un alumno se guarda correctamente.")
    void shouldSaveStudent() {
        StudentDTO student = new StudentDTO(null, "Mariana Lopez", null, null,
                List.of(new SubjectDTO("Mathematics", 9.0),
                        new SubjectDTO("Science", 8.5)));
        studentDAO.save(student);

        Set<StudentDTO> result = studentRepository.findAll();
        assertNotNull(result);

        Long expectedId = (long) result.size();
        boolean exists = result.stream()
                .anyMatch(s -> s.getId().equals(expectedId) && s.getStudentName().equals("Mariana Lopez"));
        assertTrue(exists);
    }

    @Test
    @DisplayName("Test StudentDAO: se intenta guardar un alumno con id existente -> se actualiza el alumno.")
    void shouldUpdateStudent() {
        Set<StudentDTO> initialStudents = studentRepository.findAll();
        assertTrue(initialStudents.size() > 0);

        StudentDTO duplicateStudent = new StudentDTO(1L, "Updated Student", null, null,
                List.of(new SubjectDTO("History", 7.5)));

        studentDAO.save(duplicateStudent);

        Set<StudentDTO> result = studentRepository.findAll();
        assertNotNull(result);

        StudentDTO studentFromDB = result.stream()
                .filter(s -> s.getId().equals(1L))
                .findFirst()
                .orElse(null);
        assertNotNull(studentFromDB);
        assertEquals("Updated Student", studentFromDB.getStudentName());
    }

    @Test
    @DisplayName("Test StudentDAO: un alumno se elimina correctamente.")
    void shouldDeleteStudent() {
        Set<StudentDTO> initialStudents = studentRepository.findAll();
        assertTrue(initialStudents.size() > 0);

        StudentDTO studentToDelete = initialStudents.iterator().next();
        Long studentToDeleteId = studentToDelete.getId();

        Boolean result = studentDAO.delete(studentToDelete.getId());
        assertTrue(result);

        Set<StudentDTO> finalStudents = studentRepository.findAll();
        assertTrue(finalStudents.size() < initialStudents.size());
        assertTrue(finalStudents.stream().noneMatch(s -> s.getId().equals(studentToDeleteId)));
    }

    @Test
    @DisplayName("Test StudentDAO: no se puede eliminar un alumno inexistente.")
    void shouldNotDeleteStudent() {
        Set<StudentDTO> initialStudents = studentRepository.findAll();

        StudentDTO studentToDelete = new StudentDTO(-1L, "Inexistente", null, null,
                List.of(new SubjectDTO("X", 0.0), new SubjectDTO("X", 0.5)));

        Boolean result = studentDAO.delete(studentToDelete.getId());
        assertFalse(result);

        Set<StudentDTO> finalStudents = studentRepository.findAll();
        assertEquals(finalStudents.size(), initialStudents.size());
        assertTrue(finalStudents.stream().noneMatch(s -> s.getId().equals(-1L)));
    }

    @Test
    @DisplayName("Test StudentDAO: se comprueba que un alumno existe correctamente.")
    void shouldExistStudent() {
        Set<StudentDTO> initialStudents = studentRepository.findAll();
        assertTrue(initialStudents.size() > 0);
        StudentDTO studentToCheck = initialStudents.iterator().next();
        Boolean result = studentDAO.exists(studentToCheck);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test StudentDAO: se comprueba que un alumno no existe correctamente.")
    void shouldNotExistStudent() {
        StudentDTO studentToCheck = new StudentDTO(-1L, "Inexistente", null, null,
                List.of(new SubjectDTO("X", 0.0), new SubjectDTO("X", 0.5)));
        Boolean result = studentDAO.exists(studentToCheck);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test StudentDAO: se encuentra a un alumno por Id correctamente.")
    void shouldFindStudent() {
        Set<StudentDTO> initialStudents = studentRepository.findAll();
        assertFalse(initialStudents.isEmpty(), "No hay estudiantes precargados para la prueba.");

        StudentDTO studentToFind = initialStudents.iterator().next();
        StudentDTO result = assertDoesNotThrow(() -> studentDAO.findById(studentToFind.getId()),
                "No se esperaba lanzar excepción al buscar un estudiante existente");

        assertNotNull(result);
        assertEquals(studentToFind.getId(), result.getId());
        assertEquals(studentToFind.getStudentName(), result.getStudentName());

    }

    @Test
    @DisplayName("Test StudentDAO: no se encuentra a un alumno de Id inexistente.")
    void shouldNotFindStudent() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(-1L));
    }
}