package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private List<SubjectDTO> sampleSubjects(double... scores) {
        List<SubjectDTO> subjects = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            subjects.add(new SubjectDTO("Materia " + i, scores[i]));
        }
        return subjects;
    }

    @Test
    public void testCreateStudent_callsDaoSave() {
        // Arrange
        StudentDTO stu = new StudentDTO(1L, "Mateo", null, null, sampleSubjects(8.0, 7.0, 9.0));
        // Act
        studentService.create(stu);
        // Assert
        verify(studentDAO, times(1)).save(stu);
    }

    @Test
    void testRead_returnsStudent() {
        // Arrange
        StudentDTO expected = new StudentDTO(1L, "David", null, null, sampleSubjects(7.0, 8.0));
        when(studentDAO.findById(1L)).thenReturn(expected);
        // Act
        StudentDTO actual = studentService.read(1L);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testUpdate_callsDaoSave() {
        //  Arrange
        StudentDTO stu = new StudentDTO(2L, "Ana", null, null, sampleSubjects(6.0, 7.0));
        // Act
        studentService.update(stu);
        // Assert
        verify(studentDAO).save(stu);
    }

    @Test
    void testDelete_callsDaoDelete() {
        // Arrange
        studentService.delete(3L);
        // Act Assert
        verify(studentDAO).delete(3L);
    }

    @Test
    void testGetAll_returnsAllStudents() {
        // Arrange
        Set<StudentDTO> expected = Set.of(
                new StudentDTO(1L, "Pedro", null, null, sampleSubjects(8.0)),
                new StudentDTO(2L, "Laura", null, null, sampleSubjects(9.0))
        );
        when(studentRepository.findAll()).thenReturn(expected);
        // Act
        Set<StudentDTO> actual = studentService.getAll();
        // Assert
        assertEquals(expected, actual);
    }

}
