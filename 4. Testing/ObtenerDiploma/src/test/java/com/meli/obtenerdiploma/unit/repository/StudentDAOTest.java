package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {
    @Autowired
    IStudentDAO studentDAO;


    @Test
    public void saveStudent_shouldContainId(){
        // Arrange
        StudentDTO student = new StudentDTO(null, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0)));
        //Act
        studentDAO.save(student);
        // Assert
        assertNotNull(student.getId());
        assertEquals(student, studentDAO.findById(student.getId()));

    }


    @Test
    public void deleteStudent_shouldReturnTrue(){
        // Arrange
        StudentDTO student = new  StudentDTO(null, "Juan", null, null,
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
        StudentDTO student = new  StudentDTO(null, "Juan", null, null,
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
        StudentDTO student = new  StudentDTO(null, "Juan", null, null,
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
        StudentDTO student = new  StudentDTO(null, "Juan", null, null,
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
        StudentDTO student = new StudentDTO(null, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        // Act
        studentDAO.save(student);
        StudentDTO studentObtained = studentDAO.findById(student.getId());
        // Assert
        assertEquals(student, studentObtained);
    }

    @Test
    public void findById_shouldThrowExceptionIfNotFound() {
        //Arrange
        Long nonExistentId = 999L;

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(nonExistentId);
        });
    }

    @Test
    public void saveStudentWithNullId_shouldAssignIdAutomatically() {
        // Arrange
        StudentDTO student = new StudentDTO(null, "Pedro", null, null,
                List.of(new SubjectDTO("Biología", 10.0)));

        // Act
        studentDAO.save(student);

        // Assert
        assertNotNull(student.getId());
        assertTrue(student.getId() > 0);
    }


}
