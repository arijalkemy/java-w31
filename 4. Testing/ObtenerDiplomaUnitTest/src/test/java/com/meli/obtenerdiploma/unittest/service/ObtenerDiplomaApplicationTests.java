package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObetenerDiplomaApplicationTests {

	@Mock
	private IStudentDAO studentDAO;
	@InjectMocks
	private ObtenerDiplomaService obtenerDiplomaService;

	@Test
	public void testStudentAverage() {
		Long studentId = 2L;
		StudentDTO student2 = new StudentDTO();
		student2.setId(studentId);
		student2.setStudentName("Pedro");
		student2.setSubjects(List.of(
				new SubjectDTO("Matemática", 10.0),
				new SubjectDTO("Física", 8.0),
				new SubjectDTO("Química", 4.0)
		));

		when(studentDAO.findById(studentId)).thenReturn(student2);
		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);
		Double expectedScore = (10.0 + 8.0 + 4.0) / 3;

		assertEquals(expectedScore, result.getAverageScore(), "El promedio calculado no es el esperado.");
	}

	@Test
	public void testStudentMessage(){
		Long studentId = 2L;
		StudentDTO student2 = new StudentDTO();
		student2.setId(studentId);
		student2.setStudentName("Pedro");
		student2.setSubjects(List.of(
				new SubjectDTO("Matemática", 10.0),
				new SubjectDTO("Física", 8.0),
				new SubjectDTO("Química", 4.0)
		));

		when(studentDAO.findById(studentId)).thenReturn(student2);
		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);
		assertEquals(student2.getMessage(), result.getMessage(), "El mensaje del estudiante no es el esperado.");
	}

	@Test
	public void testStudentNotFound() {
		Long invalidId = 999L;
		when(studentDAO.findById(invalidId)).thenThrow(new StudentNotFoundException(invalidId));

		assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(invalidId));
	}

	@Test
	public void testHighScoresForHonors() {
		Long studentId = 4L;
		StudentDTO student = new StudentDTO();
		student.setId(studentId);
		student.setStudentName("Laura");
		student.setSubjects(List.of(
				new SubjectDTO("Matemática", 10.0),
				new SubjectDTO("Física", 10.0),
				new SubjectDTO("Química", 10.0)
		));

		when(studentDAO.findById(studentId)).thenReturn(student); // seteo el mock, le digo que ese estudiante debe estar

		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);
		assertEquals("El alumno Laura ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
	}

	@Test
	public void testBarelyNotHonors() {
		Long studentId = 5L;
		StudentDTO student = new StudentDTO();
		student.setId(studentId);
		student.setStudentName("María");
		student.setSubjects(List.of(
				new SubjectDTO("Historia", 9.0),
				new SubjectDTO("Geografía", 9.0),
				new SubjectDTO("Inglés", 9.0)
		));

		when(studentDAO.findById(studentId)).thenReturn(student);

		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);
		assertEquals("El alumno María ha obtenido un promedio de 9. Puedes mejorar.", result.getMessage());
	}
}