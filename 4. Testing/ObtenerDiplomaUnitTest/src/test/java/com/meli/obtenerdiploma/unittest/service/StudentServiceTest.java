package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository  studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void readStudent(){
        StudentDTO param = new StudentDTO(4L, "Juan", " ", 5.9,
                List.of(
                        new SubjectDTO("Biologia",1.0)
                ));

        StudentDTO expected = param;
        when(studentService.read(param.getId())).thenReturn(param);
        studentService.create(param);
        StudentDTO student = studentService.read(expected.getId());
        assertEquals(student, expected);
    }

    @Test
    public void notFoundStudent(){
        Long id = 999L;
        when(studentService.read(id)).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class,
                () -> studentService.read(id));
    }

    @Test
    public void getAllStudents(){
        Set<StudentDTO> param = new HashSet<>();
        StudentDTO student1 = new StudentDTO(1L, "Alice", " ", 6.8, List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0))
        );

        StudentDTO student2 = new StudentDTO(2L, "Pedro", " ", 6.8, List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0))
        );
        param.add(student2);
        param.add(student1);

        Set<StudentDTO> expected = param;
        when(studentService.getAll()).thenReturn(param);
        Set<StudentDTO> students = studentService.getAll();
        assertEquals(students, expected);
    }

}
