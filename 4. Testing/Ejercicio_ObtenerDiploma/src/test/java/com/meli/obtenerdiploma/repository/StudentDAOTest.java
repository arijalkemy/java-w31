package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO dao;
    private StudentDTO createdStudent;

    @BeforeEach
    void setup() throws IOException {
        dao = new StudentDAO();
        createdStudent = null;
    }

    @AfterEach
    void cleanup() {
        if (createdStudent != null && createdStudent.getId() != null) {
            dao.delete(createdStudent.getId());
        }
    }

    @Test
    public void testSaveStudent(){
        //Arrange
        createdStudent = new StudentDTO(1L, "Camilo", "StudentDtoTest", 4.6, List.of(new SubjectDTO("Math", 3.5)));
        //Act
        dao.save(createdStudent);
        //Assert
        StudentDTO found = dao.findById(createdStudent.getId());
        assertEquals(createdStudent, found);
    }

    @Test
    public void testSaveNullStudent_shouldThrowException(){
        assertThrows(NullPointerException.class, () -> {
        dao.save(null);});
    }

    @Test
    public void testSaveAssignsIdWhenNull() {
        // Arrange
        createdStudent= new StudentDTO(null, "Ana", "Nueva estudiante", null, List.of(new SubjectDTO("Ciencias", 8.0)));
        // Act
        dao.save(createdStudent);
        // Assert
        assertNotNull(createdStudent.getId(), "El ID debería ser asignado automáticamente");
        StudentDTO saved = dao.findById(createdStudent.getId());
        assertEquals("Ana", saved.getStudentName());
    }

    @Test
    void testDelete_shouldRemoveStudent() {
        //Arrange
        createdStudent = new StudentDTO();
        dao.save(createdStudent);
        System.out.println(createdStudent.getId());
        // Act
        boolean deleted = dao.delete(createdStudent.getId());
        //Assert
        assertTrue(deleted);
        System.out.println(createdStudent.getId());
        assertThrows(StudentNotFoundException.class, () -> dao.findById(createdStudent.getId()));
    }

    @Test
    void testDelete_shouldNotRemoveNotExistingStudent() {
        //Arrange
        Long student = 1000L;
        // Act
        boolean deleted = dao.delete(student);
        //Assert
        assertFalse(deleted);
        assertThrows(StudentNotFoundException.class, () -> dao.findById(student));
    }

    @Test
    void testExists_shouldReturnTrueWhenStudentExists() {
        //Arrange
        createdStudent = new StudentDTO();
        dao.save(createdStudent);
        // Act Assert
        assertTrue(dao.exists(createdStudent));
    }

    @Test
    void testExists_shouldReturnFalseWhenStudentNotExists() {
        // Act
        StudentDTO student = new StudentDTO();
        student.setId(Long.MAX_VALUE);
        // Act Assert
        assertFalse(dao.exists(student));
    }

    @Test
    public void testUpdateStudent() {
        // Arrange
        createdStudent= new StudentDTO(1L, "Juan Pérez", "Estudiante aplicado", 4.5, List.of(new SubjectDTO("Matemáticas", 5.0)));
        dao.save(createdStudent);
        // Act
        StudentDTO modified = new StudentDTO(1L, "Juan P. Rodríguez", "Estudiante mejorado", 4.8, List.of(new SubjectDTO("Física", 4.9)));
        dao.save(modified);
        StudentDTO updated = dao.findById(1L);
        // Assert
        assertEquals("Juan P. Rodríguez", updated.getStudentName());
        assertEquals("Estudiante mejorado", updated.getMessage());
        assertEquals(4.8, updated.getAverageScore());
        assertEquals("Física", updated.getSubjects().get(0).getName());
        assertEquals(4.9, updated.getSubjects().get(0).getScore());
    }

    @Test
    public void testFindById_NonExistentStudent_shouldThrowException() {
        // Arrange
        Long nonExistingId = 12345L;
        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> dao.findById(nonExistingId));
    }
}
