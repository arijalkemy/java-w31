package com.meli.obtenerdiploma.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.Set;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentDAO iStudentDAO;

    @Mock
    private IStudentRepository iStudentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void is_Student_Created(){
        // Arrange

        StudentDTO stubStudent = new StudentDTO();
        stubStudent.setId(42L);
        stubStudent.setStudentName("Alice");

        // Act

        studentService.create(stubStudent);

        // Assert

        verify(iStudentDAO).save(stubStudent);
    }
    @Test
    void is_Student_Deleted(){

        // Arrange

        StudentDTO stubStudent = new StudentDTO();
        stubStudent.setId(42L);
        stubStudent.setStudentName("Alice");

        // Act

        studentService.delete(stubStudent.getId());

        // Assert

        verify(iStudentDAO).delete(stubStudent.getId());
    }
    @Test
    void is_Student_Read(){

        //Arrange

        StudentDTO studentDtoStubbed = new StudentDTO(
            1L, "Jhon", "Not fixed", 8.9, null);

        given(iStudentDAO.findById(studentDtoStubbed.getId())).willReturn(studentDtoStubbed);

        //Act

        StudentDTO studentDtoActual = studentService.read(studentDtoStubbed.getId());

        //Assert
        assertEquals(studentDtoStubbed, studentDtoActual);
        verify(iStudentDAO, atLeastOnce()).findById(studentDtoActual.getId());

    }
    @Test
    void is_Student_Updated(){

        // Arrange

        StudentDTO stubStudent = new StudentDTO();
        stubStudent.setId(42L);
        stubStudent.setStudentName("Alice");

        // Act

        studentService.update(stubStudent);

        // Assert

        verify(iStudentDAO).save(stubStudent);
            
    }

    @Test
    void get_All_Students(){
        
        //Arrange

        Set<StudentDTO> listOfStudentDtosStubbed = Set.of(
            new StudentDTO(1L, "Jhon", "Not fixed", 8.9, null),
            new StudentDTO(2L, "Jane", "Not fixed", 9.9, null),
            new StudentDTO(3L, "Marc", "Not fixed", 10.0, null));

        given(iStudentRepository.findAll()).willReturn(listOfStudentDtosStubbed);
            
        //Act

        Set<StudentDTO> studentDtosExpected = studentService.getAll();

        
        //Assert
        
        assertIterableEquals(listOfStudentDtosStubbed, studentDtosExpected);
        
        verify(iStudentRepository, atLeastOnce()).findAll();
    }

}
