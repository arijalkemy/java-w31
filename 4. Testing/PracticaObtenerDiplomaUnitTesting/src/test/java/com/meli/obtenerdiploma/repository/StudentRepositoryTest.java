package com.meli.obtenerdiploma.repository;


import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.model.StudentDTO;

class StudentRepositoryTest {

    StudentRepository studentRepository;
    

    @BeforeEach
    void setUp(){
        studentRepository = new StudentRepository();
    }

    @Test
    void get_None_Users_From_Json(){

        //Arrange
        Set<StudentDTO> listOfStudentDtos;

        //Act
        listOfStudentDtos = studentRepository.findAll();

        //Assert
        assertFalse(listOfStudentDtos::isEmpty, "La lista de estudiantes está vacia");
    }

}
