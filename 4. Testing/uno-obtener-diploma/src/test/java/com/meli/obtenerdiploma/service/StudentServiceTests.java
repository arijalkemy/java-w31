package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void givenStudent_whenSaveStudent_thenSavesStudent() {
        // Arrange - Given
        StudentDTO inputStudentDTO = new StudentDTO(1L, "Mario",
                List.of(new SubjectDTO("Italian", 8D),
                        new SubjectDTO("English", 10D)
                ));
        Mockito.when(studentDAO.save(inputStudentDTO)).thenReturn(inputStudentDTO);

        // Act - When
        StudentDTO savedStudent = studentService.create(inputStudentDTO);

        // Assert - Then
        Mockito.verify(studentDAO, Mockito.atMostOnce()).save(inputStudentDTO);
        Assertions.assertEquals(savedStudent.getId(), inputStudentDTO.getId());
    }

    @Test
    public void givenExistingId_whenFindById_thenReturnsStudent() {
        // Arrange - Given
        StudentDTO expectedStudentDTO = new StudentDTO(1L, "Mario",
                List.of(new SubjectDTO("Italian", 8D),
                        new SubjectDTO("English", 10D)
                ));
        long id = expectedStudentDTO.getId();
        Mockito.when(studentDAO.findById(id)).thenReturn(expectedStudentDTO);

        // Act - When
        StudentDTO foundStudent = studentService.read(id);

        // Assert - Then
        Mockito.verify(studentDAO, Mockito.atMostOnce()).findById(id);
        Assertions.assertEquals(expectedStudentDTO, foundStudent);
    }

    @Test
    public void givenNotExistingId_whenFindById_thenThrowsStudentNotFoundException() {
        // Arrange - Given
        long id = 100L;
        Mockito.when(studentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));

        // Act - When & Assert - Then
        Mockito.verify(studentDAO, Mockito.atMostOnce()).findById(id);
        Assertions.assertThrows(StudentNotFoundException.class, () -> {studentDAO.findById(id);});
    }

    @Test
    public void givenUpdatedFields_whenUpdateStudent_thenSavesUpdatedStudent() {
        // Arrange - Given
        StudentDTO inputStudentDTO = new StudentDTO(1L, "Mario",
                List.of(new SubjectDTO("Italian", 5D),
                        new SubjectDTO("English", 9D)
                ));
        Mockito.when(studentDAO.save(inputStudentDTO)).thenReturn(inputStudentDTO);

        // Act - When
        StudentDTO updatedStudent = studentService.update(inputStudentDTO);

        // Assert - Then
        Mockito.verify(studentDAO, Mockito.atMostOnce()).save(inputStudentDTO);
        Assertions.assertEquals(updatedStudent.getId(), inputStudentDTO.getId());
    }

    @Test
    public void givenExistingId_whenDeleteStudent_thenDeletesStudent() {
        // Arrange - Given
        long id = 1L;
        Mockito.when(studentDAO.delete(id)).thenReturn(true);

        // Act - When
        studentService.delete(id);

        // Assert - Then
        Mockito.verify(studentDAO, Mockito.atMostOnce()).delete(id);
    }

    @Test
    public void whenGetAllStudents_thenGetAllStudents() {
        // Arrange - Given
        Set<StudentDTO> expectedStudents = TestUtilsGenerator.getStudentsSet();
        Mockito.when(studentRepository.findAll()).thenReturn(expectedStudents);

        // Act - When
        Set<StudentDTO> students = studentService.getAll();

        // Assert - Then
        Mockito.verify(studentRepository, Mockito.atMostOnce()).findAll();
        Assertions.assertEquals(expectedStudents, students);
    }
}
