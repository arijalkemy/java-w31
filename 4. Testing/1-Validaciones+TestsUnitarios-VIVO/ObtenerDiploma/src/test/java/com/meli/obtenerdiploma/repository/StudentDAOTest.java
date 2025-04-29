package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

public class StudentDAOTest {

	// Add a Student to StudentDAO
	@Test
	public void save_saveAStudent_saveValidStudent(){

		// Arrange
		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(new SubjectDTO("Matematica", 8.0));

		StudentDTO studentDto = new StudentDTO(
			null,
			"Francisco",
			"This studen is a mess",
			7.0,
			subjects
		);
		StudentDAO studentDAO = new StudentDAO();

		// Act
		studentDAO.save(studentDto);

		// Assert
		assertTrue(studentDAO.exists(studentDto));
		studentDAO.delete(studentDto.getId());
	}

	// Delete a student from StudentDAO
	@Test
	public void delete_deleteAStudent_deleteAValidStudent(){

		// Arrange
		List<SubjectDTO> subjects = new ArrayList<>();

		subjects.add(new SubjectDTO("Matematica", 8.0));

		StudentDTO studentDto = new StudentDTO(
			null,
			"Felipe Pigna",
			"This is a random message",
			7.0,
			subjects
		);
		StudentDAO studentDAO = new StudentDAO();

		// Act
		studentDAO.save(studentDto);

		// Assert
		assertTrue(studentDAO.exists(studentDto));
		studentDAO.delete(studentDto.getId());
		assertFalse(studentDAO.exists(studentDto));
	}

	// Get a student by id
	@Test
	public void getId_getAddedUserId_ObtainId(){
		// Arrange
		List<SubjectDTO> subjects = new ArrayList<>();

		subjects.add(new SubjectDTO("Matematica", 8.0));

		StudentDTO studentDto = new StudentDTO(
			null,
			"Felipe Pigna",
			"This is a random message",
			7.0,
			subjects
		);
		
		StudentDAO studentDAO = new StudentDAO();

		// Act
		studentDAO.save(studentDto);

		// Assert
		assertNotNull(studentDto.getId());
		assertTrue(studentDAO.exists(studentDto));
		studentDAO.delete(studentDto.getId());
		assertTrue(!studentDAO.exists(studentDto));
	}

	// Modify the student data
	@Test
	public void findById_modifyUserData_findAndMOdifyValidUser(){
		
		// Arrange
		List<SubjectDTO> subjects = new ArrayList<>();

		subjects.add(new SubjectDTO("Matematica", 8.0));

		StudentDTO studentDto = new StudentDTO(
			null,
			"Felipe Pigna",
			"This is a random message",
			7.0,
			subjects
		);
		
		StudentDAO studentDAO = new StudentDAO();

		// Act
		studentDAO.save(studentDto);
		StudentDTO newStudentByID = studentDAO.findById(studentDto.getId());
		newStudentByID.setStudentName("Juan Jose San Martin");

		// Assert
		assertEquals(studentDto, newStudentByID);
		assertEquals(studentDto.getStudentName(), newStudentByID.getStudentName());
		studentDAO.delete(studentDto.getId());
	}
	
}
