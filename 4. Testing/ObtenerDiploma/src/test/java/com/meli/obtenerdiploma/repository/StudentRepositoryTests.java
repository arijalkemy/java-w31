package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTests {

    private IStudentRepository studentRepo;
    private IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    void findAll_ShouldReturnAllSavedStudents() {
        // arrange
        Set<StudentDTO> expectedStudents = TestUtilsGenerator.getStudentSet();
        expectedStudents.forEach(studentDAO::save);

        // act
        Set<StudentDTO> actualStudents = studentRepo.findAll();

        // assert
        assertTrue(CollectionUtils.isEqualCollection(expectedStudents, actualStudents),
                "The returned students should match the saved students.");
    }

    @Test
    void findAll_ShouldReturnEmptySet_WhenNoStudentsExist() {
        // act
        Set<StudentDTO> actualStudents = studentRepo.findAll();

        // assert
        assertTrue(actualStudents.isEmpty(), "The returned set should be empty when no students exist.");
    }
}