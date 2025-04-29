package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.model.StudentDTO;

@SpringBootTest
public class StudentRepositoryTest {
    
    @Autowired
	IStudentRepository studentRepository;

    @Test
	public void findAll_ReturnAllValues_Test(){
		// 	Arrange
		Set<StudentDTO> setStudentDto = new HashSet<>();
		
		// Act
		setStudentDto = studentRepository.findAll();

		// Assert
		assertNotNull(setStudentDto);
	}
	
}
