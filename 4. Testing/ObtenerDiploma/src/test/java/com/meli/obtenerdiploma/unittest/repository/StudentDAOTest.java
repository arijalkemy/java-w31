package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private IStudentDAO studentDAO;

    @BeforeEach
    public void init() {
        studentDAO = new StudentDAO();
    }
    @Test
    void deleteSuccess() {
        //Arrange
        long id = 1;
        StudentDTO studentDTO = studentDAO.findById(id);

        //Act
        boolean result = studentDAO.delete(id);
        studentDAO.save(studentDTO);

        //Assert
        assertTrue(result);

    }

    @Test
    void deleteFail() {
        //Arrange
        long id = 4;

        //Act
        boolean result = studentDAO.delete(id);

        //Assert
        assertFalse(result);

    }

    @Test
    void existsSuccess() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTO = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //Act
        boolean result = studentDAO.exists(studentDTO);

        //Assert
        assertTrue(result);

    }

    @Test
    void existsFail() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Fisica",5.0));
        StudentDTO studentDTO = new StudentDTO(13L,"Rodrigo",null,null,subjectDTOList);

        //Act
        boolean result = studentDAO.exists(studentDTO);

        //Assert
        assertFalse(result);

    }

    @Test
    void findByIdSuccess() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTO = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //Act
        StudentDTO result = studentDAO.findById(studentDTO.getId());

        //Assert
        assertEquals(result, studentDTO);

    }

    @Test
    void findByIdFail() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Fisica",5.0));
        StudentDTO studentDTO = new StudentDTO(13L,"Rodrigo",null,null,subjectDTOList);

        //Act and Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentDTO.getId()));

    }

    @Test
    void save() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTO = new StudentDTO(null,"Juan",null,null,subjectDTOList);
        Long idExpected= 2L;

        //act
        studentDAO.save(studentDTO);
        studentDAO.delete(idExpected);


        //Assertion
        assertNotNull(studentDTO.getId());
        assertEquals(idExpected,studentDTO.getId());


    }
    @Test
    void saveExisted() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.0));
        subjectDTOList.add(new SubjectDTO("Física",7.0));
        subjectDTOList.add(new SubjectDTO("Química",6.0));
        StudentDTO studentDTO = new StudentDTO(1L,"Juan",null,null,subjectDTOList);
        Long idExpected= 1L;

        //act
        studentDAO.save(studentDTO);


        //Assertion
        assertNotNull(studentDTO.getId());
        assertEquals(idExpected,studentDTO.getId());


    }
}
