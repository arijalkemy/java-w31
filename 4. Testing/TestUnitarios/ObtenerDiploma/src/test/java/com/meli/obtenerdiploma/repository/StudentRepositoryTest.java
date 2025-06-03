package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository;

    @Test
    public void findAll_Students(){
        //Arrange

        //Dato que se espera obtener
        Set<StudentDTO> studentsExpected = new HashSet<>();

        //Objetos DTO 1
        studentsExpected.add(new StudentDTO(18L, "Luna", null, null,
                List.of( new SubjectDTO("Mate", 8.0),
                        new SubjectDTO("Algebra", 5.0),
                        new SubjectDTO("ISW", 8.0)
                ))
        );
        //Objetos DTO 2
        studentsExpected.add(new StudentDTO(19L, "Joa", null, null,
                List.of( new SubjectDTO("Mate", 6.0),
                        new SubjectDTO("Algebra", 8.0)
                ))
        );

        //Act
        Set<StudentDTO> students = studentRepository.findAll();

        //Assert
        assertTrue(students.containsAll(studentsExpected));

    }
}