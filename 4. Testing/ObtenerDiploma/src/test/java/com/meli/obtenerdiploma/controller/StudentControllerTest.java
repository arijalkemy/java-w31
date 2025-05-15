package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class StudentControllerTest {
    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 9.0)
                )
        );
        // Act
        studentController.registerStudent(student1);

        // Assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).create(student1);
    }
}
