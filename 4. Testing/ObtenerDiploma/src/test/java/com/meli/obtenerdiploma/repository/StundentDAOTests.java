package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StundentDAOTests {

    private StudentDAO studentDAO;
    private StudentRepository studentRepository;

    @BeforeEach @AfterEach
    public void setUp() {
        studentDAO = new StudentDAO();
        studentRepository = new StudentRepository();
    }


    //SIN MOCKS
    @Test
    public void studentDAOSaveTest() {
        // Arrange
        StudentDTO student = new StudentDTO( 1L, "John Doe", null, null, null);
        // Act
        studentDAO.save(student);
        // Assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(student, studentDAO.findById(student.getId()));
    }
    @Test
    public void studentDAOFindByIdTest() {
        // Arrange
        StudentDTO student = new StudentDTO( 1L, "John Doe", null, null, null);
        // Act
        studentDAO.save(student);
        // Assert
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }
    @Test
    public void studentDAOUpdateTest() {
        // Arrange
        StudentDTO student = new StudentDTO( 3L, "John Doe", null, null, null);
        studentDAO.save(student);
        StudentDTO updatedStudent = new StudentDTO( 3L, "Juan Doe", null, null, null);
        // Act
        studentDAO.save(updatedStudent);
        // Assert
        Assertions.assertNotEquals(studentDAO.findById(student.getId()), student);
        Assertions.assertEquals(studentDAO.findById(student.getId()), updatedStudent);
    }
    @Test
    public void studentDAODeleteTest() {
        // Arrange
        StudentDTO student = new StudentDTO( 3L, "John Doe", null, null, null);
        // Act
        studentDAO.delete(student.getId());
        // Assert
        Assertions.assertFalse(studentDAO.exists(student));
    }
    @Test
    public void studentDAONotFoundTest() {
        // Assert
        Assertions.assertThrows(StudentNotFoundException.class,()-> studentDAO.findById(-1L));
    }
}
