package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        // Usamos el constructor por defecto, pero seteamos SCOPE a mano
        studentDAO = new StudentDAO();

        try {
            var scopeField = StudentDAO.class.getDeclaredField("SCOPE");
            scopeField.setAccessible(true);
            scopeField.set(studentDAO, "test");
            var loadDataMethod = StudentDAO.class.getDeclaredMethod("loadData");
            loadDataMethod.setAccessible(true);
            loadDataMethod.invoke(studentDAO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void save_newStudent_shouldAddStudent() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Nuevo");

        //Act
        studentDAO.save(student);
        StudentDTO found = studentDAO.findById(student.getId());

        //Assert
        assertEquals("Nuevo", found.getStudentName());
    }

    @Test
    void delete_existingStudent_shouldRemoveIt() {

        //Act
        boolean deleted = studentDAO.delete(1L);

        //Assert
        assertTrue(deleted);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }

    @Test
    void delete_nonExistingStudent_shouldReturnFalse() {
        //Act
        boolean deleted = studentDAO.delete(999L);

        //Assert
        assertFalse(deleted);
    }

    @Test
    void findById_existingStudent_shouldReturnIt() {
        //Act
        StudentDTO student = studentDAO.findById(2L);
        //Assert
        assertEquals("Pedro", student.getStudentName());
    }

    @Test
    void findById_nonExistingStudent_shouldThrow() {
        //Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(999L));
    }

    @Test
    void save_nullStudent_shouldThrow() {
        //Assert
        assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }
}
