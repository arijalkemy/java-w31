package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Valid;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    @Autowired
    StudentDAO studentDAO;

    @Test
    void save() {
        SubjectDTO subject1 = new SubjectDTO("Matematicas",5D);
        SubjectDTO subject2 = new SubjectDTO("Ingles",7D);
        SubjectDTO subject3 = new SubjectDTO("Fisica",2D);
        SubjectDTO subject4 = new SubjectDTO("Castellano",10D);

        StudentDTO studentDTO = new StudentDTO(1L,"Juan s",null,7.6D,
                List.of(subject1,subject2,subject3,subject4));

        this.studentDAO.save(studentDTO);
    }

    @Test
    void delete() {
        SubjectDTO subject1 = new SubjectDTO("Matematicas",5D);
        SubjectDTO subject2 = new SubjectDTO("Ingles",7D);
        SubjectDTO subject3 = new SubjectDTO("Fisica",2D);
        SubjectDTO subject4 = new SubjectDTO("Castellano",10D);

        StudentDTO studentDTO = new StudentDTO(1L,"Juan s",null,7.6D,
                List.of(subject1,subject2,subject3,subject4));

        this.studentDAO.save(studentDTO);
        this.studentDAO.delete(1L);
    }

    @Test
    void exists() {
    }

    @Test
    void findById() {
    }
}