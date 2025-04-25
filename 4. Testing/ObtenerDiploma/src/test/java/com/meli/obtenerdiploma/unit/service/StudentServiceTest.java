package com.meli.obtenerdiploma.unit.service;

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
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository repository;

    @InjectMocks
    StudentService service;

    @Test
    public void createStudent_shouldSaveStudent(){
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);

       // Act
        service.create(mockStudent);

        // Assert
        verify(studentDAO).save(mockStudent);
    }

    @Test
    public void readStudent_shouldReturnStudent(){
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);
        when(service.read(1L)).thenReturn(mockStudent);
        // Act
        StudentDTO result = service.read(mockStudent.getId());
        // Assert
        assertEquals(result, mockStudent);
    }

    @Test
    public void updateStudent_shouldContainTheStudent(){
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);
        // Act
        service.update(mockStudent);

        // Assert
        verify(studentDAO).save(mockStudent);
    }


    @Test
    public void deleteStudent_shouldNotContainTheStudent(){
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);
        // Act
        service.delete(mockStudent.getId());
        // Assert
        verify(studentDAO).delete(mockStudent.getId());
    }


    @Test
    public void getAllStudents_shouldReturnAllStudents(){
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);
        List<SubjectDTO> subjects2 =    List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0));
        StudentDTO mockStudent2 = new StudentDTO(1L, "Pedro", null, null, subjects2);

        Set<StudentDTO> students = Set.of(mockStudent, mockStudent2);
        when(repository.findAll()).thenReturn(students);

        // Act
        Set<StudentDTO> studentsObtained = service.getAll();

        // Assert
        assertTrue(service.getAll().containsAll(studentsObtained));
    }
}
