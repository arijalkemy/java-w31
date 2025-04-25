package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    public void createStudent_shouldReturn200OK(){
        // Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));

        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);

        // Act
        ResponseEntity<?> response = controller.registerStudent(mockStudent);

        // Assert
        verify(service).create(mockStudent);
        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    public void getStudent_shouldReturnStudent(){
        // Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));

        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);

        when(service.read(1L)).thenReturn(mockStudent);

        // Act
        StudentDTO student = controller.getStudent(1L);

        // Assert
        assertEquals(student, mockStudent);
    }

    @Test
    public void modifyStudent_shouldReturn200OK(){
        // Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));

        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);

        // Act
        ResponseEntity<?> response = controller.modifyStudent(mockStudent);

        // Assert
        verify(service).update(mockStudent);
        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    public void deleteStudent_shouldReturn200OK(){
        // Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));

        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);
        // Act
        ResponseEntity<?> response = controller.removeStudent(mockStudent.getId());

        // Assert
        verify(service).delete(mockStudent.getId());
        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());
    }


    @Test
    public void listOfStudents_shouldReturnAllStudents(){
        // Arrange
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        StudentDTO mockStudent = new StudentDTO(1L, "Juan", null, null, subjects);
        List<SubjectDTO> subjects2 =    List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0));
        StudentDTO mockStudent2 = new StudentDTO(1L, "Pedro", null, null, subjects2);

        Set<StudentDTO> students = Set.of(mockStudent, mockStudent2);
        when(service.getAll()).thenReturn(students);

        // Act
        Set<StudentDTO> response = controller.listStudents();

        // Assert
        assertEquals(response, students);
    }

}
