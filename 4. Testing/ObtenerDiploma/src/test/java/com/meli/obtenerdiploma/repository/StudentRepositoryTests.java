package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTests {

    private StudentRepository studentRepository;

    @BeforeEach @AfterEach
    public void setUp() {
        studentRepository = new StudentRepository();
    }
    @Test
    public void findAllAlumnosTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)
                )
        );

        StudentDTO student2 = new StudentDTO(
                1L,
                "John Doe",
                null,
                null,
                null
        );

        StudentDTO student3 = new StudentDTO(
                3L,
                "Juan Doe",
                null,
                null,
                null
        );

        // Almacenar los estudiantes en un conjunto
        Set<StudentDTO> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        // Act
        Set<StudentDTO> studentsFind = studentRepository.findAll();
        // Assert
        Assertions.assertEquals(students, studentsFind);
        Assertions.assertEquals(3, studentsFind.size());
    }
}
