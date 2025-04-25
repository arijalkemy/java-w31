package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    private StudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO studentDTO;

    @BeforeEach
    void setup() {
        studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Roberto");
        studentDTO.setMessage(null);
        studentDTO.setAverageScore(null);
        studentDTO.setSubjects(null);
    }

    @Test
    public void createStudent() {
        studentService.create(studentDTO);
        verify(studentDAO).save(studentDTO);
        assertEquals(10L, studentDTO.getId());
    }

    @Test
    public void readStudent() {
        when(studentService.read(1L)).thenReturn(studentDTO);

        StudentDTO student = studentDAO.findById(1L);
        verify(studentDAO).findById(1L);
        assertNotNull(student);
    }

    @Test
    public void readNullStudent() {
        Long invalidId = 88888L;

        when(studentService.read(invalidId)).thenThrow(new StudentNotFoundException(invalidId));

        assertThrows(StudentNotFoundException.class, () -> studentService.read(invalidId));
        verify(studentDAO).findById(invalidId);
    }

    @Test
    public void updateStudent() {
        studentDTO.setStudentName("Roberto actualizado");
        studentService.update(studentDTO);
        verify(studentDAO).save(studentDTO);
        assertEquals("Roberto actualizado", studentDTO.getStudentName());
    }

    @Test
    public void deleteStudent() {
        studentService.delete(studentDTO.getId());
        verify(studentDAO).delete(studentDTO.getId());
    }
}
