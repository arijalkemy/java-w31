package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // inicializa los mocks automaticamente, sin esto podria usar un @beforeeach
public class ObtenerDiplomaServiceTest {
    //crear mock en la interfaz - mockear dependencia del DAO
    @Mock
    private IStudentDAO studentDAO;
    //inyectar mock en el service
    @InjectMocks
    private ObtenerDiplomaService service;

    //test 1: verificar calculo correcto de promedio y que el mensaje con promedio >9 sea correcto
    @Test
    void testCalculateAverageAndMessage(){
        //crear datos esperados
        StudentDTO expectedStudent = getSampleStudent(List.of(10.0, 9.0, 9.5));
        expectedStudent.setAverageScore(9.5);
        expectedStudent.setMessage("El alumno " + expectedStudent.getStudentName()+" ha obtenido un promedio de " + expectedStudent.getAverageScore() +
                ". Felicitaciones!");

        //comportamiento del mock
        when(studentDAO.findById(expectedStudent.getId())).thenReturn(expectedStudent);

        //ejecuto metodo
        StudentDTO actualStudent = service.analyzeScores(expectedStudent.getId());

        //verificar llamado mock
        verify(studentDAO,atLeast(1)).findById(expectedStudent.getId());

        //validar resultados usando AssertJ
        assertThat(actualStudent.getAverageScore()).isEqualTo(expectedStudent.getAverageScore());
        assertThat(actualStudent.getMessage()).contains("Felicitaciones!");
    }

    //test 2: chequeo que mensaje con promedio 7,8,9 sea correcto
    @Test
    void testMessageNoHonors(){
        StudentDTO student = getSampleStudent(List.of(7.0, 8.0, 6.5));
        when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO result = service.analyzeScores(student.getId());
        assertThat(result.getMessage()).contains("Puedes mejorar.");
    }

    //test 3: test entrada no nula - chequeo que lanze la excepcion
    @Test
    void testThrowExceptionWhenStudentNotFound() {
        when(studentDAO.findById(99L)).thenThrow(new RuntimeException("Student not found"));
        assertThrows(RuntimeException.class, () -> service.analyzeScores(99L));
    }

    private StudentDTO getSampleStudent(List<Double> notes) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Jose");

        List<SubjectDTO> subjects = notes.stream().map(n->{
            SubjectDTO sub = new SubjectDTO();
            sub.setName("Materia");
            sub.setScore(n);
            return sub;
        }).collect(Collectors.toList());
        studentDTO.setSubjects(subjects);
        return studentDTO;
    }


}
