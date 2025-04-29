package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    private StudentDAO dao;
    private StudentRepository repo;

    private StudentDTO student1;
    private StudentDTO student2;

    @BeforeEach
    void setup() {
        dao = new StudentDAO();
        repo = new StudentRepository();
        ReflectionTestUtils.setField(repo, "SCOPE", "test");

        student1 = new StudentDTO(null, "Ana", "Estudiante destacada", 4.7, List.of(new SubjectDTO("Lengua", 4.5)));
        student2 = new StudentDTO(null, "Carlos", "Nuevo estudiante", 3.9, List.of(new SubjectDTO("Ciencias", 3.8)));
        dao.save(student1);
        dao.save(student2);
    }

    @AfterEach
    void cleanup() {
        dao.delete(student1.getId());
        dao.delete(student2.getId());
    }

    @Test
    public void testFindAllStudents_afterAddingStudents() {
        Set<StudentDTO> students = repo.findAll();

        assertNotNull(students);
        assertEquals(5, students.size());
        assertTrue(students.stream().anyMatch(s -> s.getStudentName().equals("Andrés")));
        assertTrue(students.stream().anyMatch(s -> s.getStudentName().equals("Sofia")));
    }
}
