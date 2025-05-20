package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService service;

    @Test
    public void testGetAll(){
        //Arrange
        List<StudentDTO> students = Arrays.asList(
                new StudentDTO(1L, "Carlos", "Hola, soy Carlos", 0D, Arrays.asList(new SubjectDTO("materia 1", 10D))),
                new StudentDTO(2L, "Juan", "Hola, soy Juan", 0D, Arrays.asList(new SubjectDTO("materia 1", 5D))),
                new StudentDTO(3L, "Pedro", "Hola, soy Pedro", 0D, Arrays.asList(new SubjectDTO("materia 2", 8D)))
        );
        Set<StudentDTO> studentSet = new HashSet<>(students);
        when(studentRepository.findAll()).thenReturn(studentSet);
        //Act
        Set<StudentDTO> result = service.getAll();
        //Assert
        Assertions.assertEquals(studentSet, result);
    }

    @Test
    public void testDelete(){
        //Arrange
        Long id = 1L;
        when(studentDAO.delete(id)).thenReturn(Boolean.TRUE);
        //Act
        service.delete(id);
        //Assert
    }

    @Test
    public void testUpdate(){
        //Arrange
        StudentDTO stu = new StudentDTO(1L, "Marcela", "Hello!", 0D, Arrays.asList(new SubjectDTO("materia 1", 10D)));
        //Act
        service.update(stu);
        //Assert
    }

    @Test
    public void testCreate(){
        //Arrange
        StudentDTO stu = new StudentDTO(1L, "Marcela", "Hello!", 0D, Arrays.asList(new SubjectDTO("materia 1", 10D)));
        //Act
        service.create(stu);
        //Assert
    }

    @Test
    public void testRead(){
        //Arrange
        Long id = 1L;
        StudentDTO templateStudent = new StudentDTO(1L, "Marcela", "Hello!", 0D, Arrays.asList(new SubjectDTO("materia 1", 10D)));
        when(studentDAO.findById(id))
                .thenReturn(templateStudent);
        //Act
        StudentDTO student = service.read(id);
        //Assert
        Assertions.assertEquals(templateStudent, student);
    }
}
