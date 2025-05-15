package com.meli.obtenerdiploma.services;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudentTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        // Act
         studentService.create(student1);
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(student1);
    }
    @Test
    public void readStudentTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        Mockito.when(studentDAO.findById(student1.getId())).thenReturn(student1);
        // Act
        StudentDTO readStudent = studentService.read(student1.getId());
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).findById(student1.getId());
        Assertions.assertEquals(student1, readStudent);
    }
    @Test
    public void updateStudentTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        // Act
        studentService.update(student1);
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(student1);
    }
    @Test
    public void deleteStudentTest() {
        // Arrange
        StudentDTO student1 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                Arrays.asList(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        // Act
        studentService.delete(student1.getId());
        // Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).delete(student1.getId());
    }
    @Test
    public void getAllStudentsTest() {
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

        Set<StudentDTO> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Mockito.when(studentRepository.findAll()).thenReturn(students);
        // Act
        Set<StudentDTO> studentsFind = studentService.getAll();
        // Assert
        Mockito.verify(studentRepository, Mockito.atLeastOnce()).findAll();
        Assertions.assertEquals(students, studentsFind);
        Assertions.assertEquals(3, studentsFind.size());
    }

}
