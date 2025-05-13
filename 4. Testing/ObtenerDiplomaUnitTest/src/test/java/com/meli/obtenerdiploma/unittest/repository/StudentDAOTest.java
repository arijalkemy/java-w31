package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    private  StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }



    @Test
    void testStudentNotFound(){
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(999L);
        });
    }

    @Test
    void testDeleteStudentNotFound(){
        assert(!studentDAO.delete(999L));
    }

    @Test
    void testStudenNotExists(){
        StudentDTO student999 = new StudentDTO();
        student999.setId(999L);
        student999.setStudentName("Pedro");
        student999.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));
        assert (!studentDAO.exists(student999));
    }

    @Test
    void testStudentExists(){
        StudentDTO student2 = new StudentDTO();
        student2.setId(2L);
        student2.setStudentName("Pedro");
        student2.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));
        assert (studentDAO.exists(student2));
    }

    @Test
    void testAddStudent() {
        StudentDTO student3 = new StudentDTO();
        student3.setId(3L);
        student3.setStudentName("Carlos");
        student3.setSubjects(List.of(
                new SubjectDTO("Historia", 8.0),
                new SubjectDTO("Geografía", 7.0)
        ));
        studentDAO.save(student3);
        assert(studentDAO.exists(student3));
    }

    @Test
    void testFindStudent(){
        StudentDTO student2 = studentDAO.findById(2L);
        assertNotNull(student2);
    }

    @Test
    void testModifyData(){
        StudentDTO studentToModify = studentDAO.findById(2L);
        studentToModify.setStudentName("Julio");
        String expectedName = "Julio";
        assertEquals(expectedName, studentToModify.getStudentName());

    }

    @Test
    void testDeleteStudent(){
        StudentDTO studentToDelete = studentDAO.findById(3L);
        boolean deleted = studentDAO.delete(3L);
        assert(deleted);
        assert(!studentDAO.exists(studentToDelete));
    }

}
