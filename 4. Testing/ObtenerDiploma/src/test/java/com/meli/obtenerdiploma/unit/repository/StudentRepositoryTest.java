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
    public void findAllStudents_shouldReturnStudentsSameSize(){
        // Arrange
        Set<StudentDTO> studentsExpected = new HashSet<>();
        studentsExpected.add(new StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))
        ));

        studentsExpected.add(new StudentDTO(2L, "Pedro", null, null,
                List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0))
        ));

        // Act
        Set<StudentDTO> students = studentRepository.findAll();

        // Assert
        assertTrue(students.containsAll(studentsExpected));
    }


}
