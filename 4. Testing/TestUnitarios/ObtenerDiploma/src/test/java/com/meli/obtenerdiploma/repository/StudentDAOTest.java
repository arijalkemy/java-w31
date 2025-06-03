package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*Casos nulos, vacíos, inválidos.
Agregar un alumno.
Buscar un alumno por Id.
Modificar los datos de un alumno.
Eliminar un alumno.
Listar todos los alumnos.*/

@SpringBootTest
class StudentDAOTest {

    @Autowired
    IStudentDAO studentDAO;

    @Test
    void saveStudents_shouldHaveId() {
        //Arrange
        StudentDTO student = new StudentDTO(null, "juan", null, null,
                List.of(new SubjectDTO("Matemáticas", 8.0)));

        //Act
        studentDAO.save(student);

        //Assert
        assertNotNull(student.getId());
        assertEquals(student, studentDAO.findById(student.getId()));
    }

    @Test
    void saveStudent_NotHaveIdAndAssignId() {
        //Arrange
        StudentDTO student = new StudentDTO(null, "juan", null, null,
                List.of(new SubjectDTO("Matemáticas", 8.0)));

        //Act
        studentDAO.save(student);

        //Assert
        assertNotNull(student.getId());
        assertTrue(student.getId() > 0);

    }


    @Test
    void deleteStudent_shouldReturnTrue() {
        //Arrange
        StudentDTO student = new StudentDTO(null, "juan", null, null,
                List.of(new SubjectDTO("Matemáticas", 8.0)));

        //Act
        studentDAO.save(student);

        //Assert
        assertTrue(studentDAO.delete(student.getId()));
    }

    @Test
    void deleteStudent_shouldReturnFalse() {
        //Arrange
        StudentDTO student = new StudentDTO(null, "juan", null, null,
                List.of(new SubjectDTO("Matemáticas", 8.0)));

        //Act
        studentDAO.save(student);
        studentDAO.delete(student.getId());

        //Assert
        assertFalse(studentDAO.delete(student.getId()));
    }

    @Test
    void existsStudent_shouldReturnTrue() {
        //Arrange
        StudentDTO student = new StudentDTO(null, "juan", null, null,
                List.of(new SubjectDTO("Matemáticas", 8.0)));

        //Act
        studentDAO.save(student);

        //Assert
        assertTrue(studentDAO.exists(student));

    }

    @Test
    void existsStudent_shouldReturnFalse() {
        //Arrange
        StudentDTO student = new StudentDTO(null, "juan", null, null,
                List.of(new SubjectDTO("Matemáticas", 8.0)));

        //Act
        studentDAO.save(student);
        studentDAO.delete(student.getId());

        //Assert
        assertFalse(studentDAO.exists(student));

    }

    @Test
    void findById_shouldReturnAStudent() {
        //Arrange
        StudentDTO student = new StudentDTO(null, "juan", null, null,
                List.of(new SubjectDTO("Matemáticas", 8.0)));

        //Act
        studentDAO.save(student);
        studentDAO.findById(student.getId());

        //Assert
        assertEquals(student, studentDAO.findById(student.getId()));

    }

    @Test
    void findById_shouldThrowException() {
        //Arrange
        Long idNotExist = 777L;

        //Act & Assert
        assertThrows(StudentNotFoundException.class, () -> {studentDAO.findById(idNotExist); });

    }
}