package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    private StudentDAO dao;

    @BeforeEach
    void setUp() {
        dao = new StudentDAO();  // carga desde users.json
    }

    @Test
    void testSaveStudent() {
        //crear un estudiante y guardar
        StudentDTO student = new StudentDTO();
        student.setStudentName("Test Alumno");
        dao.save(student);
        //buscar en el repositorio si el estudiante creado existe
        StudentDTO result = dao.findById(student.getId());
        assertNotNull(result); //verifica que el resultado no sea nulo
        assertEquals("Test Alumno", result.getStudentName()); //verifica que el nombre del alumno recuperado sea igual al del alumno creado
    }

    @Test
    void testSearchStudentByExistId() {
        //crear estudiante y guardar en lista
        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan Pérez");
        dao.save(student);

        //buscar alumno en la lista y verificar si el id recuperado es el mismo del creado
        StudentDTO found = dao.findById(student.getId());
        assertEquals(student.getId(), found.getId());
    }

    @Test
    void testSearchStudentByNonExistId() {
        //se asegura que el metodo de buscar por id devuelva una excepcion cuando mandamos un id que no existe
        assertThrows(StudentNotFoundException.class, () -> dao.findById(9999L));
    }

    @Test
    void testUpdateStudent() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Nombre original");
        dao.save(student);
        student.setStudentName("Nombre modificado");
        dao.save(student);
        StudentDTO updated = dao.findById(student.getId());
        assertEquals("Nombre modificado", updated.getStudentName());
    }

    @Test
    void testDeleteStudentExist() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Eliminar Alumno");
        dao.save(student);

        boolean removed = dao.delete(student.getId());
        assertTrue(removed);

        assertThrows(StudentNotFoundException.class, () -> dao.findById(student.getId()));
    }

    @Test
    void testDeleteStudentNonExist() {
        boolean result = dao.delete(999L);
        assertFalse(result);
    }

    @Test
    void testListAllStudents() {
        int initialAmount = dao.findAll().size();

        dao.save(new StudentDTO());
        dao.save(new StudentDTO());

        Set<StudentDTO> list = dao.findAll();
        assertTrue(list.size() >= initialAmount + 2);
    }

    @Test
    void testSaveStudentNull() {
        assertThrows(NullPointerException.class, () -> dao.save(null));
    }
}
