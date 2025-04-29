package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void createTestSuccess() {

        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTO = new StudentDTO(2L,"Juan",null,null,subjectDTOList);

        //Act
        studentService.create(studentDTO);

        //Assert
        verify(studentDAO,atLeast(1)).save(studentDTO);
    }

    @Test
    void readSuccess() {

        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTOExpected = new StudentDTO(1L,"Juan",null,null,subjectDTOList);
        long id=1;

        //Act
        when(studentDAO.findById(id)).thenReturn(studentDTOExpected);
        StudentDTO studentDTO=studentService.read(id);

        //Assert
        verify(studentDAO,atLeast(1)).findById(id);
        assertEquals(studentDTOExpected,studentDTO);

    }
    @Test
    void updateTestSuccess() {

        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTO = new StudentDTO(2L,"Juan",null,null,subjectDTOList);

        //Act
        studentService.update(studentDTO);

        //Assert
        verify(studentDAO,atLeast(1)).save(studentDTO);
    }

    @Test
    void deleteTestSuccess() {

        //Arrange
        long id=1L;

        //Act
        studentService.delete(id);

        //Assert
        verify(studentDAO,atLeast(1)).delete(id);
    }

    @Test
    void getAllTestSuccess() {

        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        Set<StudentDTO> studentDTOSetExpected = new HashSet<>(List.of(new StudentDTO(1L, "Juan", null, null, subjectDTOList)));
        //Act
        when(studentRepository.findAll()).thenReturn(studentDTOSetExpected);
        Set<StudentDTO> studentDTOSet=studentService.getAll();

        //Assert
        verify(studentRepository,atLeast(1)).findAll();
        assertEquals(studentDTOSetExpected,studentDTOSet);
    }


}
