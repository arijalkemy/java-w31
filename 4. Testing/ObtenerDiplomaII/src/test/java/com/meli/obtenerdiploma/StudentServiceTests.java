package com.meli.obtenerdiploma;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;

/*
 * EJERCICIO 3 - TESTS UNITARIOS CON MOCKS
 * Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de
 * servicios StudentService, mockeando sus dependencia con los repositorios.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Test StudentService - Caso válido: StudentDTO existente -> se guarda el estudiante")
    void createTest() {
        StudentDTO inputStudent = new StudentDTO(100L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0)));
        ArgumentCaptor<StudentDTO> studentCaptor = ArgumentCaptor.forClass(StudentDTO.class);

        studentService.create(inputStudent);

        verify(studentDAO, times(1)).save(inputStudent);
        verify(studentDAO).save(studentCaptor.capture());
        StudentDTO capturedStudent = studentCaptor.getValue();
        assertEquals(inputStudent.getId(), capturedStudent.getId());
        assertEquals(inputStudent.getStudentName(), capturedStudent.getStudentName());
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: Id existente -> se devuelve el estudiante")
    void readTest() {
        StudentDTO student = new StudentDTO(100L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0)));

        Mockito.when(studentDAO.findById(student.getId())).thenReturn(student);

        StudentDTO result = studentService.read(student.getId());
        assertNotNull(result);
        assertEquals(student.getId(), result.getId());
        assertEquals(student.getStudentName(), result.getStudentName());
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: StudentDTO existente -> se guarda el nuevo estudiante")
    void updateTest() {
        StudentDTO originalStudent = new StudentDTO(100L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0)));
        StudentDTO updatedStudent = new StudentDTO(100L, "Tomas Fernandez", null, null,
                List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("Science", 4.0), new SubjectDTO("History", 5.0)));
        ArgumentCaptor<StudentDTO> studentCaptor = ArgumentCaptor.forClass(StudentDTO.class);

        studentService.create(originalStudent);
        studentService.update(updatedStudent);

        verify(studentDAO, times(1)).save(updatedStudent);
        verify(studentDAO, times(2)).save(studentCaptor.capture());
        List<StudentDTO> capturedStudents = studentCaptor.getAllValues();
        assertNotNull(capturedStudents);
        assertEquals(2, capturedStudents.size());
        assertEquals(originalStudent.getStudentName(), capturedStudents.get(0).getStudentName());
        assertEquals(updatedStudent.getStudentName(), capturedStudents.get(1).getStudentName());
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: Id existente -> se elimina el nuevo estudiante")
    void deleteTest() {
        Long targetId = 100L;
        ArgumentCaptor<Long> studentCaptor = ArgumentCaptor.forClass(Long.class);

        studentService.delete(targetId);

        verify(studentDAO, times(1)).delete(targetId);
        verify(studentDAO).delete(studentCaptor.capture());
        Long capturedId = studentCaptor.getValue();
        assertEquals(targetId, capturedId);
    }

    @Test
    @DisplayName("Test StudentService - Caso válido: Devuelve Set de StudentDTO")
    void getAllTest() {
        Set<StudentDTO> students = Set.of(new StudentDTO(100L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0))));
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> result = studentService.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.stream().anyMatch(s -> s.getId().equals(100L)));
        assertTrue(result.stream().anyMatch(s -> s.getStudentName().equals("Ana Lopez")));
    }

}
