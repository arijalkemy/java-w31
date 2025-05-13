package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    private Set<StudentDTO> createStudentsSet(){
        Set<StudentDTO> studentsSet = new HashSet<>();
        StudentDTO student1 = new StudentDTO();
        student1.setId(1L);
        student1.setStudentName("Alice");
        student1.setSubjects(List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));

        StudentDTO student2 = new StudentDTO();
        student2.setId(2L);
        student2.setStudentName("Pedro");
        student2.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));
        studentsSet.add(student2);
        studentsSet.add(student1);

        return studentsSet;
    }

    @Test
    void testFindAll(){
        Set<StudentDTO> studentsFromRepo = studentRepository.findAll();
        Set<StudentDTO> expectedStudents = createStudentsSet();
        assert(expectedStudents.containsAll(studentsFromRepo));
    }
}
