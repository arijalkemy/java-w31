package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    private static final String STUDENT_NAME = "Marco";

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepo;

    @InjectMocks
    private StudentService service;

    @Test
    void createStudent_ShouldSaveStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects(STUDENT_NAME);

        // act
        service.create(student);

        // assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void readStudent_ShouldReturnStudent_WhenExists() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects(STUDENT_NAME);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        StudentDTO result = service.read(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(student, result, "The returned student should match the expected student.");
    }

    @Test
    void updateStudent_ShouldSaveUpdatedStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects(STUDENT_NAME);

        // act
        service.update(student);

        // assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void deleteStudent_ShouldRemoveStudent() {
        // arrange
        Long studentId = 1L;

        // act
        service.delete(studentId);

        // assert
        verify(studentDAO, atLeastOnce()).delete(studentId);
    }

    @Test
    void getAllStudents_ShouldReturnAllStudents() {
        // arrange
        Set<StudentDTO> expectedStudents = TestUtilsGenerator.getStudentSet();
        when(studentRepo.findAll()).thenReturn(expectedStudents);

        // act
        Set<StudentDTO> result = service.getAll();

        // assert
        verify(studentRepo, atLeastOnce()).findAll();
        assertTrue(CollectionUtils.isEqualCollection(expectedStudents, result),
                "The returned students should match the expected set.");
    }
}