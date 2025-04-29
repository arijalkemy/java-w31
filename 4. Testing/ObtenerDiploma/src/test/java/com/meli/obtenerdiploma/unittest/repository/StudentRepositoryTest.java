package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {
    private IStudentRepository studentRepository;

    @BeforeEach
    public void init() {
        studentRepository = new StudentRepository();
    }

    @Test
    public void findAll() {

        //Arrange
        Long expected=1L;

        //Act
        Set<StudentDTO> studentDTOS = studentRepository.findAll();

        //Assert
        assertEquals(expected, studentDTOS.size());

    }
}
