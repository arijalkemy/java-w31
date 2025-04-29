package com.meli.obtenerdiploma.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTests {

    @Autowired
    IStudentRepository iStudentRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    void findAll(){
        this.iStudentRepository.findAll();
    }
}
