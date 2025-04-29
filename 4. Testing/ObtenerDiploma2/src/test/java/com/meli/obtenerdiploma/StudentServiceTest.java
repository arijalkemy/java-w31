package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void  testCreate_exitoso(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Miguel");

        //Art
        studentService.create(studentDTO);

        //Assert
        // Chequea que se haya llamado una vez al metodo save de la clase studentDAO
        verify(studentDAO,times(1)).save(studentDTO);
    }

    @Test
    void testRead(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(12L);

        when(studentService.read(12L)).thenReturn(studentDTO);
        //Act

        StudentDTO resultado = studentService.read(12L);

        //Assert
        assertNotNull(resultado);
        assertEquals(12L,resultado.getId());
        verify(studentDAO,times(1)).findById(12L);
    }
    @Test
    void testUpdate(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Miguel");
        //Act
        studentService.update(studentDTO);
        //Assert
        verify(studentDAO,times(1)).save(studentDTO);
    }

    @Test
    void testDelete(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(100L);

        //Act
        studentService.delete(100L);

        //Assert
        assertNull(studentDAO.findById(100L));
    }

    @Test
    void testFindAll(){
        //Arrange
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        StudentDTO a = new StudentDTO();
        a.setId(125L);
        a.setStudentName("Miguel");

        studentDTOSet.add(a);
        when(studentService.getAll()).thenReturn(studentDTOSet);
        //Act

        Set<StudentDTO> result = studentService.getAll();

        //Assert
        assertEquals(1,result.size());
        assertTrue(result.contains(a));
        verify(studentRepository,times(1)).findAll();

    }
}
