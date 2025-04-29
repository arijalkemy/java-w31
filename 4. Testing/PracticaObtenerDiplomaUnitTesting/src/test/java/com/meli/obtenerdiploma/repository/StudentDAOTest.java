package com.meli.obtenerdiploma.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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
    void is_Student_Saved_Even_If_Already_Exists(){

        //Arrange
        StudentDTO studentDTOExpected = studentDAO.findById(1L);

        //Act
        studentDAO.save(studentDTOExpected);
        StudentDTO studentDTOActual = studentDAO.findById(studentDTOExpected.getId());

        //Assert
        assertEquals(studentDTOExpected, studentDTOActual);
    }



    @Test
    void is_Student_Saved(){

        //Arrange

        List<SubjectDTO> listOfSubjectDtos = List.of(new SubjectDTO("Math", 100.0));
        StudentDTO studentDTOExpected = new StudentDTO(null, "Michell", 
        "Testing", 70.0, listOfSubjectDtos);
        
        //Act

        studentDAO.save(studentDTOExpected);
        StudentDTO studentDtoActual = studentDAO.findById(studentDTOExpected.getId());

        //Assert

        assertEquals(studentDTOExpected.getId(), studentDtoActual.getId());
    }
    
    @Nested
    class DeleteOperation {
        
        void re_Save_Student_Deleted(StudentDTO studentDTODeleted){
            studentDAO.save(studentDTODeleted);
        }

        @Test
        void is_Student_Deleted(){
    
            //Arrange
    
            StudentDTO studentDTOExpected;      
    
            //Act
    
            studentDTOExpected = studentDAO.findById(3L);
    
            //Assert
    
            assertTrue(studentDAO.delete(studentDTOExpected.getId()));
            this.re_Save_Student_Deleted(studentDTOExpected);
            
        }
        
    }


    @Test
    void is_Student_Not_Deleted_Due_To_Not_Id_Found(){

        //Arrange 

        List<SubjectDTO> listOfSubjectDtos = List.of(new SubjectDTO("Math", 100.0));
        
        StudentDTO studentDTOToBeTested = new StudentDTO(7L, "Andres", 
        "Testing", 70.0, listOfSubjectDtos);
        
        Long studentDTOToBeTestedId = studentDTOToBeTested.getId();

        String supplierMessage = "Student with ID: " + studentDTOToBeTestedId + " was deleted";
        

        //Act & Assert

        assertFalse(() -> studentDAO.delete(studentDTOToBeTestedId), () -> supplierMessage);
        
    }

    @Test
    void does_Student_Exist (){
        
        //Arrange
        
        StudentDTO studentDTO = studentDAO.findById(5L);

        //Act
        
        boolean exists = studentDAO.exists(studentDTO);

        //Assert

        assertTrue(exists);


    } 
    
}
