package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {
    private StudentRepository studentRepository;

    @BeforeEach
    void setup(){
        studentRepository = new StudentRepository();
        // Setear el scope a mano porque @Value no funciona fuera del contexto Spring
        try {
            var scopeField = StudentRepository.class.getDeclaredField("SCOPE");
            scopeField.setAccessible(true);
            scopeField.set(studentRepository, "test"); // apunta a ./src/test/resources
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void findAll_shouldReturnStudentsFromJson() {

        //Act
        Set<StudentDTO> result = studentRepository.findAll();

        //Assert
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(s -> s.getId() == 2));
    }
}
