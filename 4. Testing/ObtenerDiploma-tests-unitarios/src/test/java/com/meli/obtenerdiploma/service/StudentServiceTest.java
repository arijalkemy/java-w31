package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void createTest() {
        // arrange
        StudentDTO stu = new StudentDTO(
                null,
                "Sofia",
                null,
                null,
                List.of(
                        new SubjectDTO("Historia", 8.0),
                        new SubjectDTO("Arte", 10.0)
                ));
        // act
        studentService.create(stu);
        // assert
        verify(studentDAO, times(1)).save(stu);
    }

    @Test
    public void readTest() {
        // arrange
        Long id = 1L;

        StudentDTO expectedStudent = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));

        when(studentDAO.findById(id)).thenReturn(expectedStudent);

        // act
        StudentDTO obtainedStudent = studentService.read(id);
        // assert
        verify(studentDAO, times(1)).findById(id);
        assertThat(expectedStudent.getId()).isEqualTo(id);
    }

    @Test
    public void updateTest() {
        // arrange
        StudentDTO expectedStudent = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));
        // act
        studentService.update(expectedStudent);
        // assert
        verify(studentDAO, times(1)).save(expectedStudent);
    }

    @Test
    public void deleteTest() {
        // arrange
        Long id = 1L;
        // act
        studentService.delete(id);
        // assert
        verify(studentDAO, times(1)).delete(id);
    }

    @Test
    public void getAllTest() {
        // arrange
        Set<StudentDTO> expectedStudents = Set.of(
                new StudentDTO(
                        1L,
                        "Juan",
                        null,
                        null,
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )),
                new StudentDTO(
                        2L,
                        "Pedro",
                        null,
                        null,
                        List.of(
                                new SubjectDTO("Matemática", 10.0),
                                new SubjectDTO("Física", 8.0),
                                new SubjectDTO("Química", 4.0)
                        )),
                new StudentDTO(
                        3L,
                        "Romina",
                        null,
                        null,
                        List.of(
                                new SubjectDTO("Matemática", 10.0),
                                new SubjectDTO("Física", 9.0),
                                new SubjectDTO("Química", 9.0)
                        ))
        );

        when(studentRepository.findAll()).thenReturn(expectedStudents);

        // act
        Set<StudentDTO> obtainedStudents = studentService.getAll();

        // assert
        verify(studentRepository, times(1)).findAll();
        assertThat(obtainedStudents).isEqualTo(expectedStudents);
    }
}
