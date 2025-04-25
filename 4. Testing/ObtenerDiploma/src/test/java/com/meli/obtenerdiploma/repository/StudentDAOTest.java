package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {
    IStudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
        studentDAO.clear();
    }

    @AfterEach
    public void tearDown() {
        studentDAO.clear();
    }

    @Test
    public void saveStudent_shouldContainIdOne(){
        // Arrange
        StudentDTO student = new  StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        Long studentIdExpected = 1L;

        //Act
        studentDAO.save(student);
        StudentDTO studentObtained = studentDAO.findById(1L);
        // Assert
        assertEquals(studentIdExpected, studentObtained.getId());

    }


    @Test
    public void deleteStudent_shouldReturnTrue(){
        // Arrange
        StudentDTO student = new  StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        // Act
        studentDAO.save(student);

        // Assert
        assertTrue(studentDAO.delete(student.getId()));
    }

    @Test
    public void deleteStudent_shouldReturnFalse(){
        // Arrange
        StudentDTO student = new  StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        // Act
        studentDAO.save(student);
        studentDAO.delete(student.getId());
        // Assert
        assertFalse(studentDAO.delete(student.getId()));
    }

    @Test
    public void exists_shouldReturnTrue(){
        // Arrange
        StudentDTO student = new  StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        // Act
        studentDAO.save(student);

        // Assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    public void exists_shouldReturnFalse(){
        // Arrange
        StudentDTO student = new  StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        // Act
        studentDAO.save(student);
        studentDAO.delete(student.getId());
        // Assert
        assertFalse(studentDAO.exists(student));
    }

    @Test
    public void findById_shouldReturnStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        // Act
        studentDAO.save(student);
        StudentDTO studentObtained = studentDAO.findById(1L);
        // Assert
        assertEquals(student, studentObtained);
    }

    @Test
    public void findById_shouldThrowExceptionIfNotFound() {
        Long nonExistentId = 999L;
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(nonExistentId);
        });
    }

    @Test
    public void saveStudentWithNullId_shouldAssignIdAutomatically() {
        StudentDTO student = new StudentDTO(null, "Pedro", null, null,
                List.of(new SubjectDTO("Biología", 8.0)));

        studentDAO.save(student);

        assertNotNull(student.getId());
        assertTrue(student.getId() > 0);
    }

    @Test
    public void saveStudentWithSameId_shouldOverwrite() {
        StudentDTO student1 = new StudentDTO(1L, "Lucía", null, null,
                List.of(new SubjectDTO("Historia", 7.0)));
        StudentDTO student2 = new StudentDTO(1L, "Lucía Modificada", null, null,
                List.of(new SubjectDTO("Historia", 10.0)));

        studentDAO.save(student1);
        studentDAO.save(student2);

        StudentDTO stored = studentDAO.findById(1L);

        assertEquals("Lucía Modificada", stored.getStudentName());
        assertEquals(10.0, stored.getSubjects().get(0).getScore());
    }

}
