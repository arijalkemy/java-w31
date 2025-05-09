package com.meli.obtenerdiploma.repository;

/*Casos nulos, vacíos, inválidos.
Agregar un alumno. OK
Buscar un alumno por Id. OK
Modificar los datos de un alumno.
Eliminar un alumno. OK
Listar todos los alumnos.
 */


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SocketUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentDAOTest {

    IStudentDAO  studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    StudentDTO createStudent() {
        SubjectDTO s1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO s2 = new SubjectDTO("Lengua", 9.0);
        SubjectDTO s3 = new SubjectDTO("Historia", 10.0);
        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan");
        student.setId(1L);
        student.setSubjects(Arrays.asList(s1, s2, s3));
        return student;
    }

    StudentDTO createStudent2() {
        SubjectDTO s1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO s2 = new SubjectDTO("Lengua", 9.0);
        SubjectDTO s3 = new SubjectDTO("Historia", 10.0);
        StudentDTO student = new StudentDTO();
        student.setStudentName("Fer");
        student.setId(2L);
        student.setSubjects(Arrays.asList(s1, s2, s3));
        return student;
    }

    @Test
    void saveStudentSuccess() {
        //ARRANGE
        StudentDTO student = createStudent();
        //ACT
        studentDAO.save(student);
        //ASSERT
        assertTrue( studentDAO.exists(student));
    }

    @Test
    void saveStudentNotSuccess() {
        StudentDTO student = createStudent();
        assertFalse( studentDAO.exists(student));
    }

    @Test
    void saveStudentNullException() {
        assertThrows(NullPointerException.class, () -> {
            studentDAO.save(null);
        });
    }


    @Test
    void deleteSuccess() {
        //ARRANGE
        StudentDTO student = createStudent();
        //ACT
        studentDAO.save(student);
        studentDAO.delete(student.getId());
        //ASSERT
        assertFalse( studentDAO.exists(student));
    }

    @Test
    void deleteNotSuccess() {
        //ARRANGE
        StudentDTO student = createStudent();
        //ACT
        Boolean deleted = studentDAO.delete(student.getId());
        //ASSERT
        assertFalse( deleted);
    }

    @Test
    void deleteNull() {
        //ARRANGE
        StudentDTO student = createStudent();
        //ACT
        studentDAO.save(student);
        //ASSERT
        assertFalse(studentDAO.delete(null));
    }


    @Test
    void existsTrue() {
        StudentDTO student = createStudent();
        studentDAO.save(student);
        assertTrue( studentDAO.exists(student));
    }

    @Test
    void existsFalse() {
        StudentDTO student = createStudent();
        assertFalse( studentDAO.exists(student));
    }

    @Test
    void existsException() {
        assertThrows(NullPointerException.class, () -> {
            studentDAO.exists(null);
        });
    }


    @Test
    void findByIdSuccess() {
        StudentDTO student = createStudent();
        studentDAO.save(student);
        StudentDTO studentDTO = studentDAO.findById(student.getId());
        assertEquals(student, studentDTO);
    }

    @Test
    void findByIdNotFound() {
        StudentDTO student = createStudent();
        StudentDTO student2 = createStudent2();
        studentDAO.save(student);
        StudentDTO studentDTO = studentDAO.findById(student2.getId());
        assertNotEquals(student, studentDTO);
    }


    @Test
    void findByIdStudentNotException() {
        StudentDTO student = createStudent();
        studentDAO.save(student);
        assertThrows(StudentNotFoundException.class, () -> {
            StudentDTO studentDTO = studentDAO.findById(null);
        });
    }


    @Test
    void loadData() {
        StudentDTO student = createStudent();
        studentDAO.save(student);
        StudentDAO studentDAO2 = new StudentDAO();
        assertTrue( studentDAO2.exists(student));
    }

    @Test
    void saveData() {
    }


}
