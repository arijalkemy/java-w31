package com.meli.obtenerdiploma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;

/*
 * EJERCICIO 5: TEST UNITARIOS CON MOCKS
 * Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa
 * de controlador StudentController, mockeando su dependencia con el servicio.
 */

@SpringBootTest
class StudentControllerTests {
    @Mock
    private IStudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("Test StudentController - registerStudent: StudentDTO válido -> OK")
    void registerStudentTest() {
        ArgumentCaptor<StudentDTO> studentCaptor = ArgumentCaptor.forClass(StudentDTO.class);
        StudentDTO inputStudent = new StudentDTO(100L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0)));

        ResponseEntity<?> response = studentController.registerStudent(inputStudent);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(studentService).create(studentCaptor.capture());
        StudentDTO capturedStudent = studentCaptor.getValue();
        assertEquals(capturedStudent.getId(), inputStudent.getId());
        assertEquals(capturedStudent.getStudentName(), inputStudent.getStudentName());
    }

    @Test
    @DisplayName("Test StudentController - registerStudent: StudentDTO nulo -> llama al servicio igualmente")
    void registerStudentSadPath() {
        ArgumentCaptor<StudentDTO> studentCaptor = ArgumentCaptor.forClass(StudentDTO.class);
        StudentDTO inputStudent = null;

        studentController.registerStudent(inputStudent);

        verify(studentService, times(1)).create(studentCaptor.capture());
        StudentDTO capturedStudent = studentCaptor.getValue();
        assertNull(capturedStudent);
    }

    @Test
    @DisplayName("Test StudentController - getStudent: Id de estudiante válido -> devuelve el estudiante")
    void getStudentTest() {
        StudentDTO student = new StudentDTO(100L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0)));
        Mockito.when(studentService.read(student.getId())).thenReturn(student);

        StudentDTO result = studentController.getStudent(student.getId());

        assertEquals(student.getId(), result.getId());
        assertEquals(student.getStudentName(), result.getStudentName());
        assertEquals(student.getSubjects().size(), result.getSubjects().size());
    }

    @Test
    @DisplayName("Test StudentController - getStudent: Id de estudiante nulo -> lanza excepción ")
    void getStudentSadPath() {
        Mockito.when(studentService.read(null)).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(null));

    }

    @Test
    @DisplayName("Test StudentController - modifyStudent: StudentDto válido -> OK")
    void modifyStudentTest() {
        ArgumentCaptor<StudentDTO> studentCaptor = ArgumentCaptor.forClass(StudentDTO.class);
        StudentDTO student = new StudentDTO(15L, "Ana Lopez", null, null,
                List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0), new SubjectDTO("History", 7.0)));

        ResponseEntity<?> response = studentController.modifyStudent(student);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(studentService).update(studentCaptor.capture());
        StudentDTO capturedStudent = studentCaptor.getValue();
        assertEquals(capturedStudent.getId(), student.getId());
        assertEquals(capturedStudent.getStudentName(), student.getStudentName());
    }

    @Test
    @DisplayName("Test StudentController - modifyStudent: StudentDTO nulo -> llama al servicio igualmente")
    void modifyStudentSadPath() {
        ArgumentCaptor<StudentDTO> studentCaptor = ArgumentCaptor.forClass(StudentDTO.class);
        StudentDTO inputStudent = null;

        studentController.modifyStudent(inputStudent);

        verify(studentService, times(1)).update(studentCaptor.capture());
        StudentDTO capturedStudent = studentCaptor.getValue();
        assertNull(capturedStudent);
    }

    @Test
    @DisplayName("Test StudentController - removeStudent: Id de estudiante válido -> OK")
    void removeStudentTest() {
        ArgumentCaptor<Long> studentCaptor = ArgumentCaptor.forClass(Long.class);
        Long studentId = 100L;

        ResponseEntity<?> response = studentController.removeStudent(studentId);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(studentService).delete(studentCaptor.capture());
        Long capturedStudentId = studentCaptor.getValue();
        assertEquals(capturedStudentId, studentId);
    }

    @Test
    @DisplayName("Test StudentController - removeStudent: Id de estudainte válido -> Se llama al servicio igualmente.")
    void removeStudentSadPath() {
        ArgumentCaptor<Long> studentCaptor = ArgumentCaptor.forClass(Long.class);
        Long inputId = null;

        studentController.removeStudent(inputId);

        verify(studentService, times(1)).delete(studentCaptor.capture());
        Long capturedId = studentCaptor.getValue();
        assertNull(capturedId);
    }

    @Test
    @DisplayName("Test StudentController - listStudents: Sin parámetros -> devuelve el conjunto de estudiantes")
    void listStudentsTest() {
        Set<StudentDTO> students = Set.of(
                new StudentDTO(100L, "Ana Lopez", null, null,
                        List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 9.0),
                                new SubjectDTO("History", 7.0))),
                new StudentDTO(101L, "Juan Perez", null, null,
                        List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("Science", 5.0),
                                new SubjectDTO("History", 4.0))));
        Mockito.when(studentService.getAll()).thenReturn(students);

        Set<StudentDTO> result = studentController.listStudents();

        assertEquals(students.size(), result.size());
        assertEquals(students.iterator().next().getId(), result.iterator().next().getId());
        assertEquals(students.iterator().next().getStudentName(), result.iterator().next().getStudentName());
        assertEquals(students.iterator().next().getSubjects().size(), result.iterator().next().getSubjects().size());
    }
}
