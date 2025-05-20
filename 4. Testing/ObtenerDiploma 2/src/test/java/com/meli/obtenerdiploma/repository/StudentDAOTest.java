package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Objects;

@SpringBootTest
public class StudentDAOTest {

    @Test
    public void testAddStudentEquals() {
        //Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO student = new StudentDTO(999L, "Camila", "Hola desde NY", 78D, new ArrayList<>());
        //Act
        studentDAO.save(student);
        StudentRepository studentRepository = new StudentRepository();
        Integer currentLength = studentRepository.findAll().size();
        //Assert
        Assertions.assertEquals(studentDAO.findById(currentLength.longValue()), student);
    }

    @Test
    public void testAddStudentLength() {
        //Arrange
        StudentRepository studentRepository = new StudentRepository();
        Integer currentLength = studentRepository.findAll().size();
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO student = new StudentDTO(3L, "Camila", "Hola desde NY", 78D, new ArrayList<>());
        //Act
        studentDAO.save(student);
        //Assert
        Assertions.assertEquals(currentLength + 1, studentRepository.findAll().size());
    }

    @Test
    public void testFindByIdNotNull() {
        //Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO newStudent = new StudentDTO(999L, "Pedro", "Hola desde NY", 78D, new ArrayList<>());
        studentDAO.save(newStudent);
        StudentRepository studentRepository = new StudentRepository();
        Integer currentLength = studentRepository.findAll().size();
        //Act
        StudentDTO student = studentDAO.findById(currentLength.longValue());
        //Assert
        Assertions.assertFalse(Objects.isNull(student));
    }

    @Test
    public void testAddStudentEdit() {
        //Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO newStudent = new StudentDTO(999L, "Pedro", "Hola desde NY", 78D, new ArrayList<>());
        StudentDTO editStudent = new StudentDTO(999L, "Camila", "Hola desde NY", 78D, new ArrayList<>());
        //Act
        studentDAO.save(newStudent);
        studentDAO.save(editStudent);
        StudentRepository studentRepository = new StudentRepository();
        Integer currentLength = studentRepository.findAll().size();
        StudentDTO editedStudent = studentDAO.findById(currentLength.longValue());
        //Assert
        Assertions.assertEquals("Camila", editedStudent.getStudentName());
    }

    @Test
    public void testDeleteStudentLength() {
        //Arrange
        StudentRepository studentRepository = new StudentRepository();
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO newStudent = new StudentDTO(3L, "Camila", "Hola desde NY", 78D, new ArrayList<>());
        studentDAO.save(newStudent);
        Integer currentLength = studentRepository.findAll().size();
        //Act
        studentDAO.delete(studentRepository.findAll().stream().findFirst().get().getId());
        //Assert
        Assertions.assertEquals(currentLength - 1, studentRepository.findAll().size());
    }

    @Test
    public void testDeleteStudentTrue() {
        //Arrange

        StudentDAO studentDAO = new StudentDAO();
        StudentDTO newStudent = new StudentDTO(3L, "Camila", "Hola desde NY", 78D, new ArrayList<>());
        studentDAO.save(newStudent);
        StudentRepository studentRepository = new StudentRepository();
        Integer currentLength = studentRepository.findAll().size();
        //Act
        Boolean deleteResult = studentDAO.delete(currentLength.longValue());
        //Assert
        Assertions.assertTrue(deleteResult);
    }

    @Test
    public void testExistsNonExistent() {
        //Arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO newStudent = new StudentDTO(999L, "Camila", "Hola desde NY", 78D, new ArrayList<>());
        //Act
        Boolean result = studentDAO.exists(newStudent);
        //Assert
        Assertions.assertFalse(result);
    }
}
