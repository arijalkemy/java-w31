package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObetenerDiplomaApplicationTests {

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void invalidCases() {
		StudentDTO result = studentDAO.findById(1L);

		assertEquals(1, result.getId());
		assertNotNull(result.getStudentName());
		assertNull(result.getMessage());
		assertNull(result.getAverageScore());
	}

	@Test
	public void createStudent() {
		// Act
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		SubjectDTO matematicas = new SubjectDTO();
		matematicas.setName("Matemáticas");;
		matematicas.setScore(10.0);
		subjectDTOList.add(matematicas);

		SubjectDTO fisica = new SubjectDTO();
		fisica.setName("Física");
		fisica.setScore(9.0);
		subjectDTOList.add(fisica);

		SubjectDTO historia = new SubjectDTO();
		historia.setName("Historia");
		historia.setScore(8.0);
		subjectDTOList.add(historia);


		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(5L);
		studentDTO.setStudentName("Roberto");
		studentDTO.setMessage(null);
		studentDTO.setAverageScore(null);
		studentDTO.setSubjects(subjectDTOList);

		studentDAO.save(studentDTO);

		// assert
		assertTrue(studentDAO.exists(studentDTO));
	}

	@Test
	public void searchStudentById() {
		// Act
		StudentDTO result = studentDAO.findById(1L);

		// Assert
		assertEquals(1L, result.getId());
		assertEquals("Juan", result.getStudentName());
		assertEquals(3, result.getSubjects().size());
	}

	@Test
	public void searchStudentByIdFail() {
		// Assert
		assertThrows(StudentNotFoundException.class, () -> {
			studentDAO.findById(10L);
		});
	}

	@Test
	public void deleteStudent() {
		// Act
		boolean result = studentDAO.delete(5L);

		// Assert
		assertTrue(result);
	}

	@Test
	public void deleteStudentFail() {
		// Act
		boolean result = studentDAO.delete(6L);

		// Assert
		assertFalse(result);
	}

	@Test
	public void getAllStudents() {
		assertNotNull(studentRepository.findAll());
	}
}