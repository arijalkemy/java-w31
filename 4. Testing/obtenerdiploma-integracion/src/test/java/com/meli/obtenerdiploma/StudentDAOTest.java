package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentDAOTest {

    @InjectMocks
    private StudentDAO studentDAO;
    private Set<StudentDTO> mockStudents;

    @BeforeEach
    void setUp() {
        mockStudents = new HashSet<>();
        mockStudents.add(new StudentDTO(1L, "John Doe", "Excellent", 95.0, null));
        mockStudents.add(new StudentDTO(2L, "Jane Smith", "Good", 85.0, null));
        mockStudents.add(new StudentDTO(3L, "Alice Johnson", "Average", 75.0, null));
        ReflectionTestUtils.setField(studentDAO, "students", mockStudents);
    }

    @Test
    void testSaveStudent() {
        StudentDTO newStudent = new StudentDTO(4L, "Bob Brown", "Good", 80.0, null);
        studentDAO.save(newStudent);
        assertTrue(mockStudents.contains(newStudent));
    }

    // GET OPERATIONS
    @Test
    void testFindByIdExisting() {
        Long studentIdToFind = 1L;
        StudentDTO foundStudent = studentDAO.findById(studentIdToFind);
        assertEquals(studentIdToFind, foundStudent.getId());
    }

    @Test
    void testFindByIdNonExisting() {
        Long nonExistingId = 99L;
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(nonExistingId));
    }

    @Test
    void testExists() {
        StudentDTO studentToCheck = new StudentDTO(1L, "John Doe", "Excellent", 95.0, null);
        boolean exists = studentDAO.exists(studentToCheck);
        assertTrue(exists);
    }

    @Test
    void testNotExists() {
        StudentDTO nonExistingStudent = new StudentDTO(99L, "Non Existent", "Unknown", 0.0, null);
        boolean exists = studentDAO.exists(nonExistingStudent);
        assertFalse(exists);
    }

    // DELETE OPERATIONS
    @Test
    void testDeleteExistingStudent() {
        Long studentIdToDelete = 2L;
        studentDAO.delete(studentIdToDelete);
        assertTrue(mockStudents.stream().noneMatch(student -> student.getId().equals(studentIdToDelete)));
    }

    @Test
    void testDeleteNonExistingStudent() {
        Long nonExistingId = 99L;
        boolean result = studentDAO.delete(nonExistingId);
        assertFalse(result);
    }
}

