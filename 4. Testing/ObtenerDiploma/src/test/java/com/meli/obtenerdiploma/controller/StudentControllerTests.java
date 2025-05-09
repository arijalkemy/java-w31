package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
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
public class StudentControllerTests {

    private static final Long STUDENT_ID = 1L;

    @Mock
    private IStudentService service;

    @InjectMocks
    private StudentController controller;

    @Test
    public void registerStudent_ShouldCallServiceCreate() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        // act
        controller.registerStudent(student);

        // assert
        verify(service, times(1)).create(student);
    }

    @Test
    public void getStudent_ShouldReturnStudentFromService() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(STUDENT_ID)).thenReturn(student);

        // act
        StudentDTO result = controller.getStudent(STUDENT_ID);

        // assert
        verify(service, times(1)).read(STUDENT_ID);
        assertEquals(student, result, "The returned student should match the expected student.");
    }

    @Test
    public void modifyStudent_ShouldCallServiceUpdate() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.modifyStudent(student);

        // assert
        verify(service, times(1)).update(student);
    }

    @Test
    public void removeStudent_ShouldCallServiceDelete() {
        // arrange

        // act
        controller.removeStudent(STUDENT_ID);

        // assert
        verify(service, times(1)).delete(STUDENT_ID);
    }

    @Test
    public void listStudents_ShouldReturnAllStudentsFromService() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);

        // act
        Set<StudentDTO> result = controller.listStudents();

        // assert
        verify(service, times(1)).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, result), "The returned students should match the expected set.");
    }
}