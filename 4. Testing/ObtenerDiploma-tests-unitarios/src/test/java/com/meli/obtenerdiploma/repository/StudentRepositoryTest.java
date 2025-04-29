package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    private Set<StudentDTO> expectedStudents;

    @BeforeEach
    public void setUp() throws Exception {
        // Carga los datos esperados antes de cada prueba desde el archivo JSON
        expectedStudents = loadExpectedStudents();
    }

    @Test
    public void findAllStudentsTest() {
        // act
        Set<StudentDTO> obtained = studentRepository.findAll();
        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(obtained, expectedStudents));
    }

    private Set<StudentDTO> loadExpectedStudents() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new ClassPathResource("users.json").getFile();
        return objectMapper.readValue(file, new TypeReference<>() {
        });
    }
}
