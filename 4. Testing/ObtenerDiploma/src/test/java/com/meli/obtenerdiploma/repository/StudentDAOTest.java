package com.meli.obtenerdiploma.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;


class StudentDAOTest {
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp(){
        studentDAO = new StudentDAO();
    }

    @Test
    void Is_Student_Saved (){
        //Arrange
        List<SubjectDTO> listOfSubjectDtos = List.of(new SubjectDTO("Math", 100.0));
        StudentDTO studentDTOExpected = new StudentDTO(null, "Michell",
                "Testing", 70.0, listOfSubjectDtos);
        // Act
        studentDAO.save(studentDTOExpected);
        StudentDTO studentDtoActual = studentDAO.findById(studentDTOExpected.getId());
        //Assert
        assertEquals(studentDTOExpected.getId(), studentDtoActual.getId());
    }

    @Test
    void Is_Student_Deleted (){
        //Arrange
        List<SubjectDTO> subjectDTOs = List.of(new SubjectDTO("Math", 100.0));
        StudentDTO studentDTO = new StudentDTO();
        // Act
        //Assert
    }

    @Test
    void Is_Student_Deleted_When_Not_Found (){
        //Arrange
        // Act
        //Assert
    }
}