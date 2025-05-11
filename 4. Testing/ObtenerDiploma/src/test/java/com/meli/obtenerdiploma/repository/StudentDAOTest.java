package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    @Autowired
    IStudentDAO studentDAO;

    @Autowired
    IStudentRepository studentRepository;

    private StudentDTO student1;
    private StudentDTO student2;

    @BeforeEach
    void setUp() {

        // Arrange
        student1 = new StudentDTO(1L, "Jane Doe", "Lorem ipsum", 9.0, List.of(new SubjectDTO("Maths", 9.0)));
        student2 = new StudentDTO(2L, "John Doe", "Lorem ipsum", 9.0, List.of(new SubjectDTO("English", 9.0)));

    }

    @Test
    void saveStudent() {

        // Act
        studentDAO.save(student1);
        studentDAO.save(student2);

        // Assert
        assertEquals(2, studentRepository.findAll().size());
    }

    @Test
    void deleteStudent() {

        // Arrange
        studentDAO.save(student1);
        studentDAO.save(student2);

        // Act
        studentDAO.delete(student2.getId());

        // Assert
        assertEquals(1, studentRepository.findAll().size());
    }

    @Test
    void findStudentById() {

        // Arrange
        studentDAO.save(student1);

        // Act
        StudentDTO result = studentDAO.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(student1.getId(), result.getId());
        assertEquals(student1.getStudentName(), result.getStudentName());
    }

    @Test
    void studentExists() {

        // Arrange
        studentDAO.save(student1);

        // Act
        boolean exists = studentDAO.exists(student1);

        // Assert
        assertTrue(exists);
    }

    @Test
    void studentNotFound() {

        // Arrange
        Long nonExistentId = 999L;

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(nonExistentId));
    }
}