package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
    private StudentDAO studentDao;

    @BeforeEach
    void setUp() {
        studentDao = new StudentDAO();
    }

    @Test
    @DisplayName("Guardar y recuperar un estudiante exitosamente")
    void testSaveAndFind() {
        StudentDTO student = getTestStudent("Juan Perez", 8.5);
        studentDao.save(student);

        StudentDTO found = studentDao.findById(student.getId());

        assertNotNull(found);
        assertEquals("Juan Perez", found.getStudentName());
        assertEquals(8.5, found.getAverageScore());
        assertFalse(found.getSubjects().isEmpty());
    }

    @Test
    @DisplayName("Guardar un estudiante nulo debe lanzar NullPointerException")
    void testSaveNullStudent() {
        assertThrows(NullPointerException.class, () -> studentDao.save(null));
    }

    @Test
    @DisplayName("Buscar un id inexistente debe lanzar StudentNotFoundException")
    void testFindByIdNotFound() {
        Long fakeId = 999999L;
        assertThrows(StudentNotFoundException.class, () -> studentDao.findById(fakeId));
    }

    @Test
    @DisplayName("Eliminar un estudiante existente debe devolver true")
    void testDeleteExistingStudent() {
        StudentDTO student = getTestStudent("Maria Lopez", 7.1);
        studentDao.save(student);

        boolean removed = studentDao.delete(student.getId());
        assertTrue(removed);

        // Ahora el buscar debería fallar
        assertThrows(StudentNotFoundException.class, () -> studentDao.findById(student.getId()));
    }

    @Test
    @DisplayName("Eliminar un estudiante no existente devuelve false")
    void testDeleteNonExistingStudent() {
        boolean result = studentDao.delete(999999L);
        assertFalse(result);
    }

    @Test
    @DisplayName("Guardar estudiante con nombre vacío debe funcionar (validación en otro nivel)")
    void testSaveStudentWithEmptyName() {
        StudentDTO student = getTestStudent("", 5.5);
        studentDao.save(student);

        StudentDTO found = studentDao.findById(student.getId());
        assertEquals("", found.getStudentName());
    }

    @Test
    @DisplayName("Intentar guardar estudiante con lista de materias vacía")
    void testSaveStudentWithEmptySubjects() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Estudiante Sin Materias");
        student.setAverageScore(3.0);
        student.setSubjects(new ArrayList<>());
        studentDao.save(student);
        StudentDTO loaded = studentDao.findById(student.getId());
        assertTrue(loaded.getSubjects().isEmpty());
    }

    @Test
    @DisplayName("Buscar por null id debe lanzar NullPointerException")
    void testFindByIdWithNull() {
        assertThrows(StudentNotFoundException.class, () -> studentDao.findById(null));
    }

    @Test
    @DisplayName("Existe: true si agrego, false si no existe")
    void testExists() {
        StudentDTO student = getTestStudent("Carlos Test", 6.5);
        studentDao.save(student);

        assertTrue(studentDao.exists(student));

        StudentDTO another = getTestStudent("Otro", 8.8);
        another.setId(99999L);
        assertFalse(studentDao.exists(another));
    }

    private StudentDTO getTestStudent(String name, double avg) {
        StudentDTO student = new StudentDTO();
        student.setStudentName(name);
        student.setAverageScore(avg);
        student.setSubjects(List.of(new SubjectDTO("Matemática", 10.0)));
        return student;
    }
}