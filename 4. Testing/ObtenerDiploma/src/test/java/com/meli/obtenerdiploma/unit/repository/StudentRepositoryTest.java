package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    IStudentRepository studentRepository;

    @Test
    public void findAllStudents_shouldcontaintStudents(){
        // Arrange
        Set<StudentDTO> studentsExpected = new HashSet<>();

        // Crear los objetos StudentDTO con los valores que coinciden con el JSON
        studentsExpected.add(new StudentDTO(18L, "Juan", null, null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        ));

        studentsExpected.add(new StudentDTO(31L, "Pedro", null, null,
                List.of(new SubjectDTO("Biología", 10.0))
        ));
        // Act
        Set<StudentDTO> students = studentRepository.findAll();

        // Assert
        assertTrue(students.containsAll(studentsExpected));
    }


}
