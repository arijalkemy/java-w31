package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTests {

    private static final Long EXISTING_STUDENT_ID = 1L;
    private static final Long NON_EXISTENT_STUDENT_ID = 999L;

    private IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    void save_ShouldCreateNewStudent_WhenStudentDoesNotExist() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.save(student);

        // assert
        assertTrue(studentDAO.exists(student), "The student should exist after being saved.");
        assertEquals(EXISTING_STUDENT_ID, student.getId(), "The student ID should be set to 1.");
        assertEquals(student, studentDAO.findById(student.getId()), "The saved student should match the retrieved student.");
    }

    @Test
    void save_ShouldUpdateStudent_WhenStudentAlreadyExists() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // act
        student.setStudentName("Marco Polo");
        studentDAO.save(student);

        // assert
        assertTrue(studentDAO.exists(student), "The student should still exist after being updated.");
        assertEquals(EXISTING_STUDENT_ID, student.getId(), "The student ID should remain unchanged.");
        assertEquals("Marco Polo", studentDAO.findById(student.getId()).getStudentName(), "The student name should be updated.");
    }

    @Test
    void findById_ShouldReturnStudent_WhenStudentExists() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // act
        StudentDTO found = studentDAO.findById(student.getId());

        // assert
        assertEquals(student, found, "The retrieved student should match the saved student.");
    }

    @Test
    void findById_ShouldThrowException_WhenStudentDoesNotExist() {
        // act & assert
        assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(NON_EXISTENT_STUDENT_ID),
                "An exception should be thrown when the student does not exist.");
    }

    @Test
    void delete_ShouldRemoveStudent_WhenStudentExists() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // act
        studentDAO.delete(student.getId());

        // assert
        assertFalse(studentDAO.exists(student), "The student should no longer exist after being deleted.");
        assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(student.getId()),
                "An exception should be thrown when trying to find a deleted student.");
    }

    @Test
    void delete_ShouldDoNothing_WhenStudentDoesNotExist() {
        // act
        boolean result = studentDAO.delete(NON_EXISTENT_STUDENT_ID);

        // assert
        assertFalse(result, "Deleting a non-existent student should return false.");
    }

    @Test
    void exists_ShouldReturnTrue_WhenStudentExists() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // act
        boolean exists = studentDAO.exists(student);

        // assert
        assertTrue(exists, "The student should exist after being saved.");
    }

    @Test
    void exists_ShouldReturnFalse_WhenStudentDoesNotExist() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        boolean exists = studentDAO.exists(student);

        // assert
        assertFalse(exists, "The student should not exist if it has not been saved.");
    }
}