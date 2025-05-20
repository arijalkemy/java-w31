package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

    @Test
    public void testFindAllNotEmpty() {
        //Arrange
        StudentRepository studentRepository = new StudentRepository();
        //Act
        Set<StudentDTO> students = studentRepository.findAll();
        //Assert
        Assertions.assertFalse(students.isEmpty());
    }

    @Test
    public void testFindAllNotNull() {
        //Arrange
        StudentRepository studentRepository = new StudentRepository();
        //Act
        Set<StudentDTO> students = studentRepository.findAll();
        //Assert
        Assertions.assertFalse(Objects.isNull(students));
    }

}
