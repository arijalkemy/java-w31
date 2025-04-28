package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentRepositoryTest {
    @InjectMocks
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(studentRepository, "SCOPE", "test");
    }

    @Test
    void testFindAll() {
        Set<StudentDTO> students = studentRepository.findAll();
        assertEquals(2, students.size());
    }

    @Test
    void testFindAll_FileNotFound_LogsMessage() {
        // Capturar la salida de consola
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            StudentRepository repository = new StudentRepository();
            ReflectionTestUtils.setField(repository, "SCOPE", "inexistente"); // Forzamos error

            Set<StudentDTO> students = repository.findAll();

            assertNotNull(students);
            assertTrue(students.isEmpty());

            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("Failed while initializing DB, check your resources files"));
        } finally {
            System.setOut(originalOut);
        }
    }
}
