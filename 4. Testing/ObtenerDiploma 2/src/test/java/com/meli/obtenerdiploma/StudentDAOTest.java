package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StudentDAOTest {
    StudentDAO dao;
    StudentDTO stu;
    @BeforeEach
    public void initialize(){

        dao = new StudentDAO();
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(new SubjectDTO("Mate", 10.0));
        stu = new StudentDTO(1L, "Nicolas", "", 8.0, materias);
    }
    @Test
    public void save_noExistsId(){
        //Arrange

        //Act
        dao.save(stu);
        //Asserts
        assertTrue(dao.exists(stu));
        dao.delete(1L);

    }

    @Test
    public void delete_existsId(){
        //Arrange
        dao.save(stu);
        //Act

        dao.delete(1L);
        //Asserts
        assertFalse(dao.exists(stu));
    }

    @Test
    public void delete_noExistsId(){
        //Act & Assert
        assertThrows(StudentNotFoundException.class , () -> dao.delete(2L));
    }

    @Test
    public void exists_existId(){
        //Arrange
        dao.save(stu);
        //Act

        dao.delete(1L);
        //Asserts
        assertFalse(dao.exists(stu));
    }
}
